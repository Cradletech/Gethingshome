package com.cradle.getthingshome.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.cradle.gethingshome.repo.impl.GTHDataRepoImpl;

public class SQLViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv=(TextView) findViewById(R.id.tvSQLinfo);      // link it to sqlview.xml
				GTHDataRepoImpl info=new GTHDataRepoImpl(this);                         // link to database class 
				info.open();                                              // open database class
				String data=info.getData();                               // get info from database
				info.close();                                             // close database
				tv.setText(data);                                         // set info as content
	}
	

}
