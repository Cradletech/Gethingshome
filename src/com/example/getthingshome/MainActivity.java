package com.example.getthingshome;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);  //activity_main);
	
		
		TabHost th = (TabHost)findViewById(R.id.tabhost);
		th.setup();
		
		TabSpec specs=th.newTabSpec("tag1");                          // linking java to tab.xml via layout references
		specs.setContent(R.id.Cereals);
		specs.setIndicator("Cereals");
		th.addTab(specs);
		
		specs=th.newTabSpec("tag2");                         
		specs.setContent(R.id.Beverages);
		specs.setIndicator("Beverages");
		th.addTab(specs);
		
		specs=th.newTabSpec("tag3");                          
		specs.setContent(R.id.Pulses);
		specs.setIndicator("Pulses");
		th.addTab(specs);
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
