package com.example.androidfirst;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListIconText extends Activity {
	ArrayList<MyItem> arItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);

		arItem = new ArrayList<MyItem>();
		MyItem mi;
		mi = new MyItem(R.drawable.ic_launcher, "삼성노트북");
		arItem.add(mi);
		mi = new MyItem(R.drawable.ic_launcher, "LG 세탁기");
		arItem.add(mi);
		mi = new MyItem(R.drawable.ic_launcher, "대우 마티즈");
		arItem.add(mi);
		
		MyListAdaper mydaAdaper = new MyListAdaper(this, R.layout.icontext,
				arItem);

		ListView MyList;
		MyList = (ListView) findViewById(R.id.list);
		MyList.setAdapter(mydaAdaper);

	}

	class MyItem {
		int Icon;
		String Name;

		public MyItem(int aIcon, String aName) {
			// TODO Auto-generated constructor stub
			Icon = aIcon;
			Name = aName;

		}
	}

	class MyListAdaper extends BaseAdapter {
		Context maincon;
		LayoutInflater Inflater;
		ArrayList<MyItem> arSrc;
		int layout;

		public MyListAdaper(Context context, int alayout,
				ArrayList<MyItem> aarSrc) {
			// TODO Auto-generated method stub
			maincon = context;
			Inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arSrc = aarSrc;
			layout = alayout;
		}

		@Override
		public int getCount() {
			return arSrc.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return arSrc.get(position).Name;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View converView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final int pos = position;

			if (converView == null) {
				converView = Inflater.inflate(layout, parent, false);
			}
			ImageView img = (ImageView) converView.findViewById(R.id.img);
			img.setImageResource(arSrc.get(position).Icon);

			TextView txt = (TextView) converView.findViewById(R.id.text);
			txt.setText(arSrc.get(position).Name);

			Button btn = (Button) converView.findViewById(R.id.btn);
			btn.setOnClickListener(new Button.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String str = arSrc.get(pos).Name + "를 주문합ㄴ디ㅏ";
					Toast.makeText(maincon, str, Toast.LENGTH_SHORT).show();
				}

			});

			return converView;
		}
	}
}
