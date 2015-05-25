package com.example.kkm.timestamp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.example.kkm.timestamp.db.DoingContract;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KKM on 5/22/2015.
 */
public class DoingAdapter extends CursorAdapter {

    public DoingAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    private String getDataFromCursor(Cursor cursor){
        Date date =new Date(cursor.getColumnIndex(DoingContract.Columns.TIMESTAMP));
        SimpleDateFormat ft = new SimpleDateFormat("E, d M y  hh:mm a");
        return ft.format(date);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        View view = rootView.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ListView lw = (ListView)view;
        //lw.setAdapter(cursor);
    }
}
