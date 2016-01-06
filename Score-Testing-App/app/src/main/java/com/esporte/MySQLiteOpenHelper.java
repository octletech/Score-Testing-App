package com.esporte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Aky on 12/22/2015.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users_table";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ID = "_id";
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME
            +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +NAME+" TEXT,"
            +EMAIL+" TEXT )";
    public static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
    public void addContact(String Name,String Email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,Name);
        values.put(EMAIL,Email);

        db.insert(TABLE_NAME, null, values);
    }

    public void updateContact(long studId,String Name,String Email) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        values.put(NAME,Name);
        values.put(EMAIL,Email);


        db.update(TABLE_NAME,values,NAME+ "= ?",new String[]{Name});

    }

    public ArrayList<String> getAllContacts()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    public Integer deleteContact (String Name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                NAME+ "= ?",
                new String[] {Name} );
    }
}
