package com.app.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import com.app.configs.Configs;

public class CommunicationUtil {
	/**
	 * TCP通信でデータを送る
	 * @param sendDataList 送るデータ
	 * @throws Exception 
	 */
	public static void sendData(List<String> sendDataList) throws Exception {

		Configs configs = Configs.getInstance();

		String yourIP = configs.getYourIP();
		int yourPort = configs.getYourPort();

		try (
				Socket socket = new Socket(yourIP, yourPort);
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
			for (String sendData : sendDataList) {
				writer.println(sendData);
				System.out.println("[サーバーからの応答]" + reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**UDP通信でデータを送る
	 * @param sendDataList 送るデータ
	 * @throws Exception 
	 */
	public static void sendDataUDP(List<String> sendDataList) throws Exception {

		Configs configs = Configs.getInstance();

		String yourIP = configs.getYourIP();
		int yourPort = configs.getYourPort();

		byte[] data = sendDataList.get(0).getBytes();
		//UDP送信用ソケットの構築
		try (DatagramSocket socket = new DatagramSocket();) {
			//指定アドレス、ポートへ送信するパケットを構築
			DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress(yourIP, yourPort));
			socket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	/**
	 * TCP通信でデータを取得
	 * @return 
	 * @throws Exception
	 */
	public static List<String> getData() throws Exception {

		Configs configs = Configs.getInstance();

		int myPort = configs.getMyPort();

		List<String> getDataList = new LinkedList<String>();

		try (
				ServerSocket server = new ServerSocket(myPort);
				Socket sc = server.accept();
				// クライアントからの受取用
				BufferedReader reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				// サーバーからクライアントへの送信用
				PrintWriter writer = new PrintWriter(sc.getOutputStream(), true);) {
			while (true) {
				// クライアントから送信されたメッセージを取得
				String line = reader.readLine();
				if (ObjectUtils.isEmpty(line)) {
					break;
				}
				System.out.println("クライアントからのメッセージ＝" + line);
				getDataList.add(line);
			}
			writer.println("相手取得データ:" + Arrays.toString(getDataList.toArray()));
			return getDataList;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * UDP通信取得
	 * @return 取得データ
	 * @throws Exception
	 */
	public static List<String> getDataUDP() throws Exception {

		Configs configs = Configs.getInstance();

		int myPort = configs.getMyPort();

		List<String> getDataList = new LinkedList<String>();

		try (DatagramSocket socket = new DatagramSocket(myPort);){
			//受信最大バッファ
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			socket.receive(packet);
			getDataList.add(new String(Arrays.copyOf(packet.getData(),packet.getLength()),"UTF-8"));	
			return getDataList;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
