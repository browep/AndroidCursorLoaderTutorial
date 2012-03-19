package com.github.browep.cursorloader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.Html;
import android.widget.TextView;

public class SimpleCursorLoader extends FragmentActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    public static final String TAG = SimpleCursorLoader.class.getSimpleName();
    private static final int LOADER_ID = 0x01;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_cursor_loader);
        textView = (TextView) findViewById(R.id.text_view);
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);


    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        return new CursorLoader(this,
                Uri.parse("content://com.github.browep.cursorloader.data")
                , new String[]{"col1"}, null, null, null);
    }

    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        cursor.moveToFirst();
        String text = (String) textView.getText();
        while (!cursor.isAfterLast()) {
            text += "<br />" + cursor.getString(1);
            cursor.moveToNext();
        }
        textView.setText(Html.fromHtml(text) );

    }

    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }
}
