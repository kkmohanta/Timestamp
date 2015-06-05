package com.example.kkm.timestamp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.kkm.timestamp.db.DoingContract;
import com.example.kkm.timestamp.db.DoingProvider;

import java.util.Date;


public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    DoingAdapter adapter;
    Button doingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doingButton = (Button)findViewById(R.id.button);
        updateList();

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    ContentResolver contentResolver = getContentResolver();

                    ContentValues mContentValues = new ContentValues();
                    mContentValues.clear();
                    long time = new Date().getTime();
                    mContentValues.put(DoingContract.Columns.TIMESTAMP, time);
                    contentResolver.insert(
                            DoingContract.Columns.CONTENT_URI,
                            mContentValues
                    );
                }catch (Exception e){
                    //Log.v("kkm-",e.toString());
                }

                updateList();
            }
        };
        doingButton.setOnClickListener(listener);


    }

    private void updateList() {

        adapter = new DoingAdapter(getApplicationContext(), null, 0);
        getSupportLoaderManager().restartLoader(0, null, this);
        ListView listView = (ListView)findViewById(R.id.contactListView);
        listView.setAdapter(adapter);
        doingButton.setText("" + DoingProvider.getCursorSize());
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new CursorLoader(getApplicationContext(),
                DoingContract.Columns.CONTENT_URI,
                new String[]{DoingContract.Columns._ID,DoingContract.Columns.TIMESTAMP},
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
