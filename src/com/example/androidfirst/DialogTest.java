package com.example.androidfirst;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class DialogTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
		new AlertDialog.Builder(this).setTitle("질문")
				.setMessage("김상형군에게 100만원을 기부하시겠습니까")
				.setIcon(R.drawable.lee2).setPositiveButton("확인", null)
				.setNegativeButton("취소", null).show();
	}
}
