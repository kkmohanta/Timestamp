package com.example.kkm.timestamp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.kkm.timestamp.db.DoingContract;


public class MainActivity extends Activity {

    DoingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateList();
        Button doingButton = (Button)findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    ContentResolver contentResolver = getContentResolver();

                    ContentValues con = new ContentValues();
                    contentResolver.insert(
                            DoingContract.Columns.CONTENT_URI,
                            con
                    );
                }catch (Exception e){e.printStackTrace();}

                updateList();
            }
        };
        doingButton.setOnClickListener(listener);


    }

    private void updateList() {
        Cursor mDoingHistory = null;
        try {
            ContentResolver contentResolver = getContentResolver();
            mDoingHistory = contentResolver.query(
                    DoingContract.Columns.CONTENT_URI,
                    new String[]{DoingContract.Columns._ID,DoingContract.Columns.TIMESTAMP},
                    null,
                    null,
                    null
            );
        }catch (Exception e){e.printStackTrace();}

        /*String[] from = new String[]{DoingContract.Columns.TIMESTAMP};
        int[]  to = new int[] { R.id.itemTextView };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.views_for_list,
                mDoingHistory, from, to);
                */
        //ListView lv = (ListView)findViewById(R.id.contactListView);

        adapter = new DoingAdapter(getApplicationContext(), mDoingHistory, 0);

        ListView listView = (ListView)findViewById(R.id.contactListView);
        listView.setAdapter(adapter);
        //TextView tw=(TextView) findViewById(R.id.textview);
        //tw.setText("dates of doing\n");

        //ArrayList<String> list = new ArrayList<String>();
        /*
        if (mDoingHistory.moveToFirst()){
            do {
                Date date =new Date(mDoingHistory.getInt(mDoingHistory.getColumnIndex(DoingContract.Columns.TIMESTAMP)));
                //tw.append("\n" + date.toString());
            }while (mDoingHistory.moveToNext());
        }
        */
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
