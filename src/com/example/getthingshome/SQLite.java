package com.example.getthingshome;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
		et1 = (EditText) findViewById(R.id.et1); // for the input text from user

		ad.setOnClickListener(this); // for the add button
		view_cart.setOnClickListener(this); // for the view cart button

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {

		case R.id.add:
			
			boolean didItWork = true;

			try {
				String name = et1.getText().toString();

				Database entry = new Database(SQLite.this); 
				  
			    entry.open();
			    entry.createEntry(name);
				entry.close();

			} catch (Exception e) {

				didItWork = false;
				String error =e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Warning");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();


			} finally {

				if (didItWork){

					Dialog d = new Dialog(this);
					d.setTitle("Success");
					TextView tv = new TextView(this);
					tv.setText("item added to cart");
					d.setContentView(tv);
					d.show();

				}
			}
			break;
			
		case R.id.viewcart:
			Intent i = new Intent("com.example.getthingshome.SQLVIEW");
			startActivity(i);

			break;
		}

	}

}
