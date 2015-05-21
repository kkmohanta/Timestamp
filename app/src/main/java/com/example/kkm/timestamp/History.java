package com.example.kkm.timestamp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KKM on 12-May-15.
 */
public class History {
    /*public List<Transact> mTransactions;

    private Context context;
    private TransactionDBHelper helper;
    private int mMerchantID;

    public History(Context context, long mMerchantPhoneNumber){

        this.context = context;
        this.mMerchantID = getMerchantId(mMerchantPhoneNumber);
    }

    private int getMerchantId(long merchantPhoneNumber){
        int mMerchantId = -1;

        helper = new TransactionDBHelper(context);
        SQLiteDatabase sqlDB = helper.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TransactionContract.TABLE_MERCHANTS
                + " WHERE "+TransactionContract.MerchantColumns.PHONENUMBER
                + " = " + merchantPhoneNumber;

        Cursor cursor = sqlDB.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            mMerchantId = cursor.getInt(cursor.getColumnIndex(TransactionContract.MerchantColumns._ID));
        }else{
            sqlDB = helper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.clear();

            values.put(TransactionContract.MerchantColumns.PHONENUMBER, merchantPhoneNumber);

            sqlDB.insertWithOnConflict(TransactionContract.TABLE_MERCHANTS, null, values, SQLiteDatabase.CONFLICT_IGNORE);

            sqlDB = helper.getReadableDatabase();

            selectQuery = "SELECT  * FROM " + TransactionContract.TABLE_MERCHANTS
                    + " WHERE "+TransactionContract.MerchantColumns.PHONENUMBER
                    + " = " + merchantPhoneNumber;

            cursor = sqlDB.rawQuery(selectQuery,null);
            if (cursor.moveToFirst()) {
                mMerchantId = cursor.getInt(cursor.getColumnIndex(TransactionContract.MerchantColumns._ID));
            }else{
                //Error......
            }

        }

        return mMerchantId;
    }

    public void addTransaction(long mTransactionId, long mPhoneNumber, double mPayAmount,
                               Date mDate, String mStatus, boolean mStatusType) {
        helper = new TransactionDBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.clear();
        //Random ran = new Random();
        values.put(TransactionContract.Columns.TRANSACTIONID, mTransactionId);

        values.put(TransactionContract.Columns.MERCHANTID, mMerchantID);
        values.put(TransactionContract.Columns.PHONENUMBER, mPhoneNumber);
        values.put(TransactionContract.Columns.PAYMOUNT, mPayAmount);
        values.put(TransactionContract.Columns.TIMESTAMP, (mDate.getTime()));
        values.put(TransactionContract.Columns.STATUS, mStatus);

        int mStatusTypeInInt = 0;
        if(mStatusType) mStatusTypeInInt = 1;
        values.put(TransactionContract.Columns.STATUSTYPE, mStatusTypeInInt);

        db.insertWithOnConflict(TransactionContract.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);

    }

    public List<Transact> getHistoryList(){
        mTransactions = new ArrayList<>();

        helper = new TransactionDBHelper(context);
        SQLiteDatabase sqlDB = helper.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TransactionContract.TABLE
                + " WHERE " + TransactionContract.Columns.MERCHANTID + " = " +mMerchantID
                + " ORDER BY "+TransactionContract.Columns._ID+" DESC";

        Cursor cursor = sqlDB.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                long tid = cursor.getLong(cursor.getColumnIndex(TransactionContract.Columns.TRANSACTIONID));
                long pnum = cursor.getLong(cursor.getColumnIndex(TransactionContract.Columns.PHONENUMBER));
                double pay = cursor.getDouble(cursor.getColumnIndex(TransactionContract.Columns.PAYMOUNT));
                long tsp = (cursor.getLong(cursor.getColumnIndex(TransactionContract.Columns.TIMESTAMP)));
                String sts = (cursor.getString(cursor.getColumnIndex(TransactionContract.Columns.STATUS)));
                int statusTypeInInt = (cursor.getInt(cursor.getColumnIndex(TransactionContract.Columns.STATUSTYPE)));

                boolean statusInBoolean=false;
                if(statusTypeInInt==1)statusInBoolean=true;

                mTransactions.add(new Transact(tid,pnum,pay, new Date(tsp),sts,statusInBoolean));

            } while (cursor.moveToNext());
        }

        return mTransactions;
    }*/
}
