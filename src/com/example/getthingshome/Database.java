package com.example.getthingshome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
	
	
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
		db.execSQL("CREATE TABLE " +DATABASE_TABLE + " (" +
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

public  Database(Context c){									// constructor of this class to pass user input to the class
	ourContext=c;
}


public Database open(){
	ourHelper = new DbHelper(ourContext);
	ourDatabase=ourHelper.getWritableDatabase();
	return this;
			
}





}
