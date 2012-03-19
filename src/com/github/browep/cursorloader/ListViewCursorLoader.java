package com.github.browep.cursorloader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.Adapter;
import android.widget.ListView;

public class ListViewCursorLoader extends FragmentActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    private static final int LOADER_ID = 0x02;
    private CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_cursor_adapter);
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);

        adapter = new SimpleCursorAdapter(this, R.layout.listview_item_layout, null,
                new String[]{"col1"}, new int[]{R.id.text_view},
                Adapter.NO_SELECTION);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        return new CursorLoader(this,
                Uri.parse("content://com.github.browep.cursorloader.data")
                , new String[]{"col1"}, null, null, null);
    }

    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        adapter.swapCursor(null);
    }
}
