package com.example.androclient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;


public class Client implements Runnable{
	String url=new String();
	String serverIP= new String();
	int port;
	
	public Client(String url,String ip,int portNumber){
		this.url=url;
		this.serverIP.concat(ip);
		this.port=portNumber;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		Log.i("client", "client thread called");
		
		try {
			Socket sock= new Socket();
			Log.i("client", "socket creaded");
			sock.connect(new InetSocketAddress("192.168.1.4",9595));
			Log.i("client", "connected");
			OutputStream out=sock.getOutputStream();
			out.write(this.url.getBytes());
			out.close();
			sock.close();
			//sock.connect(remoteAddr)
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
