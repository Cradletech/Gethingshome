package com.cradle.gethingshome.repo.impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cradle.gethingshome.repo.GTHDataRepo;

public class GTHDataRepoImpl implements GTHDataRepo {
	
	
	   public static final String KEY_ROWID="_id";      // to reference each time a row is created 
	   public static final String KEY_NAME="items_name";
	   public static final String KEY_PRICE="items_price";
	   
	   private static final String DATABASE_NAME="pricedb";              // name of db
	   private static final String DATABASE_TABLE="cart";                // table name  in db
	   private static final int DATABASE_VERSION=1;                      // db version

	   
	   
	   private DbHelper ourHelper;											// setting reference for some classes
	   private final Context ourContext;
	   private SQLiteDatabase ourDatabase;
	   
	   
	   private static class DbHelper extends SQLiteOpenHelper{                  //using SQLLiteHelper to create db

		public DbHelper(Context context) {
			super(context,DATABASE_NAME, null , DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

	@Override
	public void onCreate(SQLiteDatabase db) {                                    // called only when db is created for the first time
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
		          KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				  KEY_NAME + " TEXT NOT NULL, " +
		          KEY_PRICE + " TEXT NOT NULL);"
				);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {        // always called only after creation of database
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);                           //if table exists delete and create new one
		onCreate(db);
	}
		   
	   }

	   public  GTHDataRepoImpl(Context c){									// constructor of this class to pass user input to the class 
			ourContext=c;
		}



public GTHDataRepoImpl open() throws SQLException{
	ourHelper = new DbHelper(ourContext);                           // open database 
	ourDatabase=ourHelper.getWritableDatabase();                    // access to write to db
	return this;
			
}

public void close(){
	
	ourHelper.close();                                            // to close the database by closing the class SQLiteOpenHelper
	
	
}


public long createEntry(String name) {							// to write to db (note: we use long to return the value written to db)
	// TODO Auto-generated method stub
	
	ContentValues cv=new ContentValues();
	cv.put(KEY_NAME,name);
	return ourDatabase.insert(DATABASE_TABLE, null, cv);          // insert into table using content values
	
	
}



}
