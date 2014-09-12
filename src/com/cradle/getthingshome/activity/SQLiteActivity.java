package com.cradle.getthingshome.activity;

import com.cradle.gethingshom.repo.impl.GTHDataRepoImpl;
import com.cradle.gethingshome.service.impl.GTHServiceImpl;
import com.example.getthingshome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteActivity extends Activity implements OnClickListener {
	private Button ad, view_cart;
	private EditText mAddToCart;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);				
		ad = (Button) findViewById(R.id.add);
		view_cart = (Button) findViewById(R.id.viewcart);
		mAddToCart = (EditText) findViewById(R.id.et1);                                  // for the input text from user		
		ad.setOnClickListener(this);                                              // for the add button
		view_cart.setOnClickListener(this);                                       // for the view cart button
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.add:
			//String name =mAddToCart.getText().toString();
			GTHServiceImpl gTHServiceImpl = new GTHServiceImpl();
			gTHServiceImpl.talkToDB(mAddToCart.getText().toString());
		break;
		
		case R.id.viewcart:
		break;
		}

	}

}
