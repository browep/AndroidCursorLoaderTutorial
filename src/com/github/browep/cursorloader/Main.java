package com.github.browep.cursorloader;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] listItems = {"Simple Loader example with a TextView", "ListView Loader example"};
        setContentView(R.layout.main);
        setListAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listItems));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this,SimpleCursorLoader.class));
                break;
            case 1:
                startActivity(new Intent(this,ListViewCursorLoader.class));
                break;
        }
    }
}
