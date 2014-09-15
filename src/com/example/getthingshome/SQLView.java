package com.example.getthingshome;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv=(TextView) findViewById(R.id.tvSQLinfo);      // link it to sqlview.xml
		Database info=new Database(this);                         // link to database class 
		info.open();                                              // open database class
		String data=info.getData();                               // get info from database
		info.close();                                             // close database
		tv.setText(data);                                         // set info as content
		
		
		
		
		
	}
	

}
