package com.example.getthingshome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLite extends Activity implements OnClickListener {

	Button ad, view_cart;
	EditText et1;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		ad = (Button) findViewById(R.id.add);
		view_cart = (Button) findViewById(R.id.viewcart);
		et1 = (EditText) findViewById(R.id.et1);
		ad.setOnClickListener(this);
		view_cart.setOnClickListener(this);

	}

	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {

		case R.id.add:

						break;
		case R.id.viewcart:

						break;
		}

	}

}
