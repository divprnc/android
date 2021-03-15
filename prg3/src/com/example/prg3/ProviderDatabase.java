package com.example.prg3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ProviderDatabase extends SQLiteOpenHelper{
	public ProviderDatabase(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		Toast.makeText(context, "Database Created", Toast.LENGTH_LONG).show();
		// TODO Auto-generated constructor stub
	}

	public static String Db_Name = "noteprovider.db";
	public static String Table_Name = "notes";
	public static String C_Date = "note_date";
	public static String C_Note = "content";
	
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		String sql = "create table " + Table_Name + "(" + C_Date + " VARCHAR, " + C_Note + " VARCHAR)";
		arg0.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
