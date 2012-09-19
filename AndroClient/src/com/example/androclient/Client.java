package com.example.androclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


public class Client implements Runnable{
	String url=new String();
	String serverIP= new String();
	int port;
	Handler handler; 
	
	
	public Client(String url,String ip,int portNumber,Handler handler){
		this.url=url;
		this.serverIP=ip;
		this.port=portNumber;
		this.handler=handler;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		Log.i("client", "client thread called");
		//handler.sendMessage(handler.obtainMessage(10, "server is not running"))	;
		//handler.sendEmptyMessage(0);
		try {
			Socket sock= new Socket();
			Log.i("client", "socket creaded at "+this.serverIP + "at port :"+port);
			sock.connect(new InetSocketAddress(this.serverIP,this.port));
			Log.i("client", "connected");
			
			OutputStream out=sock.getOutputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
						
			out.write(this.url.getBytes());
			handler.sendMessage(handler.obtainMessage(10, reader.readLine()));
			
			out.close();
			sock.close();
			//sock.connect(remoteAddr)
		}
		catch (ConnectException e) {
			// TODO: handle exception
			handler.sendMessage(handler.obtainMessage(10, "server is not running"))	;
           
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
