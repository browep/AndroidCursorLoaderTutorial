package com.github.browep.cursorloader;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

public class SlowContentProvider extends ContentProvider {
    
    public static final String TAG = SlowContentProvider.class.getSimpleName();
    
    @Override
    public boolean onCreate() {
        Log.i(TAG,"onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        try {
            Log.i(TAG,"sleeping");
            Thread.sleep(3000);

            MatrixCursor cursor = new MatrixCursor(new String[]{"_id","col1"});
            for(String name : new String[]{"poodle","labrador","german shephard","boston terrier","hound"}){
                cursor.addRow(new Object[]{0,name});
            }
            Log.i(TAG,"returning " + cursor);
            return cursor;
            
        } catch (InterruptedException e) {
            Log.e(TAG,"error sleeping",e);
            return null;

        }
    }

    @Override
    public String getType(Uri uri) {
        return null;  
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;  
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;  
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;  
    }
}
