package com.example.kkm.timestamp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by KKM on 12-May-15.
 */
public class DoingDBHelper extends SQLiteOpenHelper {
    public DoingDBHelper(Context context) {
        super(context, DoingContract.DB_NAME, null, DoingContract.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String sqlQuery =
                String.format("CREATE TABLE %s (" +
                                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "%s INTEGER)",
                        DoingContract.TABLE,
                        DoingContract.Columns.TIMESTAMP
                        );

        Log.d("TaskDBHelper", "Query to form table: " + sqlQuery);
        sqlDB.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS "+ DoingContract.TABLE);
        onCreate(sqlDB);
    }
}