package com.example.androidfirst;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderDialog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogtest);
	}

	public void mOnClick(View v) {
		final LinearLayout linear = (LinearLayout) View.inflate(this,
				R.layout.order, null);

		new AlertDialog.Builder(this)
				.setTitle("�ֹ� ������ �Է��Ͻÿ�")
				.setIcon(R.drawable.lee2)
				.setView(linear)
				.setPositiveButton("Ȯ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						EditText product = (EditText) linear
								.findViewById(R.id.product);
						EditText number = (EditText) linear
								.findViewById(R.id.number);
						CheckBox paymethod = (CheckBox) linear
								.findViewById(R.id.paymethod);
						TextView text = (TextView) findViewById(R.id.text);
						text.setText("�ֹ�����" + product.getText() + "��ǰ"
								+ number.getText() + "��."
								+ (paymethod.isChecked() ? "���Ұ���" : ""));
					}
				})
				.setNegativeButton("���", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						TextView text = (TextView) findViewById(R.id.text);
						text.setText("�ֹ��� ����߽��ϴ�");
					}
				}).show();
	}
}
