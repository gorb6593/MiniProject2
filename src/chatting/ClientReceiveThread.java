package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveThread extends Thread{
	Socket server; 
	public ClientReceiveThread(Socket socket) {
		super();
		this.server = socket;
	}
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			
			String resMsg="";
			while(true) {
				resMsg = in.readLine();
				if(resMsg==null) {
					break;
				}
				System.out.println(resMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
}
