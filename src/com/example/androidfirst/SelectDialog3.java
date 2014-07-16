package com.example.androidfirst;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SelectDialog3 extends Activity {

	boolean[] mSelect = { false, false, false, false };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
		new AlertDialog.Builder(this)
				.setTitle("������ �����Ͻÿ�")
				.setIcon(R.drawable.lee2)
				.setMultiChoiceItems(R.array.foods, mSelect,
						new DialogInterface.OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which, boolean isChecked) {
								// TODO Auto-generated method stub
								mSelect[which] = isChecked;
							}
						})
				.setPositiveButton("Ȯ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String[] foods = getResources().getStringArray(
								R.array.foods);
						TextView text = (TextView) findViewById(R.id.text);
						String result = "������ ���� =";
						for (int i = 0; i < mSelect.length; i++) {
							if (mSelect[i]) {
								result += foods[i] + " ";
							}
						}
						text.setText(result);
					}
				}).setNegativeButton("���", null).show();
	}
}
