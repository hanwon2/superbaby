package com.example.androidfirst;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListOfViews extends Activity {
	ArrayList<ListItem> arItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewtest);
		arItem = new ArrayList<ListItem>();

		arItem.add(new ListItem(0, "제목", "입력내용", "", 0));
		arItem.add(new ListItem(1, "", "", "push", R.drawable.ic_launcher));
		arItem.add(new ListItem(0, "이름을 입력하시오", "니 이름", "", 0));
		arItem.add(new ListItem(0, "나이도 입력하시오", "명살이니", "", 0));
		arItem.add(new ListItem(1, "", "", "누르시오", R.drawable.ic_launcher));
		arItem.add(new ListItem(1, "", "", "업로드", R.drawable.ic_launcher));
		arItem.add(new ListItem(0, "주소", "어디 사니?", "", 0));

		MultiAdapter MyAapter = new MultiAdapter(this, arItem);

		ListView MyList;
		MyList = (ListView) findViewById(R.id.list);
		MyList.setAdapter(MyAapter);
	}

	class ListItem {
		int Type;
		String Text;
		String BtnText;
		String EditText;
		int IconRes;

		public ListItem(int aType, String aText, String aEditText,
				String aBtnText, int aIconRes) {
			// TODO Auto-generated constructor stub
			Type = aType;
			Text = aText;
			EditText = aEditText;
			BtnText = aBtnText;
			IconRes = aIconRes;
		}
	}

	class MultiAdapter extends BaseAdapter {
		LayoutInflater mInflater;
		ArrayList<ListItem> arSrc;

		public MultiAdapter(Context context, ArrayList<ListItem> arItem) {
			// TODO Auto-generated method stub
			mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arSrc = arItem;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arSrc.size();
		}

		@Override
		public ListItem getItem(int position) {
			// TODO Auto-generated method stub
			return arSrc.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		@Override
		public int getItemViewType(int position) {
			// TODO Auto-generated method stub
			return arSrc.get(position).Type;
		}

		public int getViewTypeCount() {
			return 2;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				int res = 0;
				switch (arSrc.get(position).Type) {
				case 0:
					res = R.layout.textedit;
					break;
				case 1:
					res = R.layout.btnicon;
					break;

				}
				convertView = mInflater.inflate(res, parent, false);
			}

			switch (arSrc.get(position).Type) {
			case 0:
				TextView txt = (TextView) convertView.findViewById(R.id.text);
				txt.setText(arSrc.get(position).Text);
				EditText edit = (EditText) convertView.findViewById(R.id.edit);
				edit.setText(arSrc.get(position).EditText);
				break;
			case 1:
				Button btn = (Button) convertView.findViewById(R.id.btn);
				btn.setText(arSrc.get(position).BtnText);
				ImageView img = (ImageView) convertView.findViewById(R.id.img);
				img.setImageResource(arSrc.get(position).IconRes);
				break;
			}
			return convertView;
		}
		
	}
}
