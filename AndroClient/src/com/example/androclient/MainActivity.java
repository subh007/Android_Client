package com.example.androclient;

import android.R.string;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	Handler handler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//       EditText ip=(EditText)findViewById(R.id.ipaddress);
//        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.hideSoftInputFromWindow(ip.getWindowToken(), 0);
         handler=new Handler(){
        	 public void handleMessage(Message msg) {
         		Log.i("test","testzdfds");
         		Toast.makeText(getApplicationContext(),msg.obj.toString(), Toast.LENGTH_LONG).show();
 				
 			}
        };
        Button submit=(Button) findViewById(R.id.submitbutton);
        
        submit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("client", "botton clicked");
				EditText url=(EditText)findViewById(R.id.url);
				EditText ip=(EditText)findViewById(R.id.ipaddress);
		        EditText port=(EditText)findViewById(R.id.port);
		        
		        Log.i("client", ip.getText().toString());
		        Client connReq=new Client(url.getText().toString(),ip.getText().toString(),Integer.parseInt(port.getText().toString()), handler);
		        //Client connReqst=new Client(url.getText().toString(),ip.getText().toString(),Integer.parseInt(port.getText().toString()),handler);
		        Thread clientThread=new Thread(connReq);
		        clientThread.start();
			}
		});
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

   
}
