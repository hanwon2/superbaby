package com.example.androidfirst;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ListAddDel extends Activity {
	ArrayList<String> Items;
	ArrayAdapter<String> Adaptor;
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listadddel);

		Items = new ArrayList<String>();

		Items.add("first");
		Items.add("second");
		Items.add("thrid");

		Adaptor = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, Items);

		list = (ListView) findViewById(R.id.list);
		list.setAdapter(Adaptor);
	}

	public void mOnClick(View v) {
		EditText ed = (EditText) findViewById(R.id.newitem);
		switch (v.getId()) {
		case R.id.add:
			String text = ed.getText().toString();
			if (text.length() != 0) {
				Items.add(text);
				ed.setText("");
				Adaptor.notifyDataSetChanged();
			}
			break;
		case R.id.delete:
			SparseBooleanArray sb = list.getCheckedItemPositions();
			if (sb.size() != 0) {
				for (int i = list.getCount() - 1; i >= 0; i--) {
					if (sb.get(i)) {
						Items.remove(i);
					}
				}
				list.clearChoices();
				Adaptor.notifyDataSetChanged();
			}
			break;
		}
	}
}
