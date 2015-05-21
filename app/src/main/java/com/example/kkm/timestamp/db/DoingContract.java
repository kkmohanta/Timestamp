package com.example.kkm.timestamp.db;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by KKM on 12-May-15.
 */
public class DoingContract {
    public static final String DB_NAME = "com.example.kkm.timestamp.db.doing_database";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "doing_time";

    public static final String CONTENT_AUTHORITY = "com.example.kkm.timestamp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_LOCATION = "/"+TABLE;

    public static class Columns {
        public static final String _ID = BaseColumns._ID;
        public static final String TIMESTAMP = "TIMESTAMP";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATION).build();
        public static Uri buildUri() {
            return CONTENT_URI;
        }
    }
}
