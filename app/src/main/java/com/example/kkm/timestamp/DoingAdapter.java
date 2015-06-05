package com.example.kkm.timestamp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

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
        long time=cursor.getLong(cursor.getColumnIndex(DoingContract.Columns.TIMESTAMP));
        Date date =new Date(time);
        SimpleDateFormat ft = new SimpleDateFormat("E, d MMM y  hh:mm a");
        return ft.format(date);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.views_for_list, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView)view.findViewById(R.id.itemTextView);
        tv.setText(getDataFromCursor(cursor));
    }
}
