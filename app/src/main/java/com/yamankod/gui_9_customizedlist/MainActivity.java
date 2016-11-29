package com.yamankod.gui_9_customizedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ListActivity {
    TextView selection;
    String[] items = { "1900", "1-9-1-0", "1920", "1-9-3-0", "-1940-", "1950",
            "1960", "1970", "1980", "1990" };
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_guicustomized_list);
        setListAdapter(new IconicAdapter(this));
        selection = (TextView) findViewById(R.id.selection);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(items[position]);
    }

    public class IconicAdapter extends ArrayAdapter<Object> {

        Activity context;
        IconicAdapter(Activity context) {
            super(context, R.layout.satir, items);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View row = inflater.inflate(R.layout.satir, null);
            TextView label = (TextView) row.findViewById(R.id.label);
            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            label.setText(items[position]);
            if (items[position].length() > 4)
                icon.setImageResource(R.drawable.delete);
            else
                icon.setImageResource(R.drawable.ok);
            return (row);
        }
    }
}
