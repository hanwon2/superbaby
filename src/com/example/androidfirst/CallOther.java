package com.example.androidfirst;

import java.io.File;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class CallOther extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callother);
	}

	public void mOnClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.web:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.naver.com"));
			startActivity(intent);
			break;
		case R.id.dial :
			intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:051-123-4567"));
			startActivity(intent);
			break;
			
		case R.id.picture :
			intent = new Intent(Intent.ACTION_VIEW);
			String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
			Uri uri = Uri.fromFile(new File(sd+"/storage/emulated/0/DCIM/20140703_131041.jpg"));
			intent.setDataAndType(uri, "image/jpeg");
			startActivity(intent);
			break;
			
		case R.id.other : 
			intent =new Intent(this,ListViewTest.class);
//			intent.setComponent(new ComponentName("com.example.androidfirst", "com.example.androidfirst.ListViewTest"));
			startActivity(intent);
		}
	}
}
