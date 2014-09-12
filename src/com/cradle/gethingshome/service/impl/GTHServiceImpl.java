package com.cradle.gethingshome.service.impl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.cradle.gethingshom.repo.impl.GTHDataRepoImpl;
import com.cradle.gethingshome.service.GTHService;

public class GTHServiceImpl extends Service implements GTHService {

	public void talkToDB(String viewName) {
		 GTHDataRepoImpl entry=new GTHDataRepoImpl(GTHServiceImpl.this);                    // pass parameters to the constructor of Database class
         entry.open();
         if(viewName!=null){
        	 entry.createEntry(viewName);
         }
         entry.close();			
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
