package com.example.kkm.timestamp.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by KKM on 5/21/2015.
 */
public class DoingProvider extends ContentProvider {

    private DoingDBHelper mOpenHelper;
    private SQLiteDatabase sqlDB;

    public static int counter;

    public static int getCursorSize(){
        return counter;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new DoingDBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        sqlDB = mOpenHelper.getReadableDatabase();

        Cursor cursor = sqlDB.query(DoingContract.TABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );
        counter = cursor.getCount();
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        sqlDB = mOpenHelper.getWritableDatabase();
        sqlDB.insertWithOnConflict(DoingContract.TABLE,
                null,  values, SQLiteDatabase.CONFLICT_IGNORE);

        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
