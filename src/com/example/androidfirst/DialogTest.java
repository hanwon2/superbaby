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
		new AlertDialog.Builder(this).setTitle("����")
				.setMessage("����������� 100������ ����Ͻðڽ��ϱ�")
				.setIcon(R.drawable.lee2).setPositiveButton("Ȯ��", null)
				.setNegativeButton("���", null).show();
	}
}
