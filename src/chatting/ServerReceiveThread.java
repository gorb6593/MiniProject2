package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceiveThread extends Thread{
	Socket client; 
	public ServerReceiveThread(Socket client) {
		super();
		this.client = client;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
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
