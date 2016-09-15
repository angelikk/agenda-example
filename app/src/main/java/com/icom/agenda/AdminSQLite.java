package com.icom.agenda;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by angelicazavala on 15/09/16.
 */
public class AdminSQLite extends SQLiteOpenHelper {

    public AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table contacts(dni integer primary key, name text, telephone text, mail text, address text, picture text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist contacts");
        sqLiteDatabase.execSQL("create table contacts(dni integer primary key, name text, telephone text, mail text, address text, picture text)");
    }
}
