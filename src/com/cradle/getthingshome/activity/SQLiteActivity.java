package com.cradle.getthingshome.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cradle.gethingshome.repo.impl.GTHDataRepoImpl;
import com.example.getthingshome.R;

public class SQLiteActivity extends Activity implements OnClickListener {
	private Button ad, view_cart;
	private EditText mAddToCart; // note et1 is replaced with mAddToCart, meaningful name convention	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		ad = (Button) findViewById(R.id.add);
		view_cart = (Button) findViewById(R.id.viewcart);
		mAddToCart = (EditText) findViewById(R.id.et1); // for the input text from user

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
				String name = mAddToCart.getText().toString();

				GTHDataRepoImpl entry = new GTHDataRepoImpl(SQLiteActivity.this); 
				  
			    entry.open();
			    entry.createEntry(name);
				entry.close();

			} catch (Exception e) {

				didItWork = false;

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

			break;
		}

	}

}
