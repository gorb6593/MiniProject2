package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConsoleChatClient {
	public static void main(String[] args) {
		
		try {
			Socket server = new Socket("192.168.0.7", 12345);
			new ClientReceiveThread(server).start();
			new ClientSenderThread(server).start();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
