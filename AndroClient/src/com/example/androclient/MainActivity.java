package com.example.androclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//       EditText ip=(EditText)findViewById(R.id.ipaddress);
//        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.hideSoftInputFromWindow(ip.getWindowToken(), 0);
        
        Button submit=(Button) findViewById(R.id.submitbutton);
        
        submit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("client", "botton clicked");
				EditText url=(EditText)findViewById(R.id.url);
				EditText ip=(EditText)findViewById(R.id.ipaddress);
		        EditText port=(EditText)findViewById(R.id.port);
		        
		        Log.i("client", ip.getText().toString());
		        
		        Client connReqst=new Client(url.getText().toString(),ip.getText().toString(),Integer.parseInt(port.getText().toString()));
		        Thread clientThread=new Thread(connReqst);
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
