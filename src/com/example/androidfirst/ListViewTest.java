package com.example.androidfirst;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		ArrayList<String> arGeneral = new ArrayList<String>();
		arGeneral.add("±èÀ¯½Å");
		arGeneral.add("ÀÌ¼ø½Å");
		arGeneral.add("À»Áö¹®´ö");
		
		ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arGeneral);
		
		ListView list =(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
	}

}
