package com.example.androidfirst;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabTest extends TabActivity {
	TabHost mTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 TabHost mTab = getTabHost();
		 
		 LayoutInflater inflater = LayoutInflater.from(this);
		 inflater.inflate(R.layout.tabtest, mTab.getTabContentView(),true);
		 
		 mTab.addTab(mTab.newTabSpec("tag").setIndicator("�Ϲ�").setContent(R.id.opt_general));
		 mTab.addTab(mTab.newTabSpec("tag").setIndicator("������").setContent(R.id.opt_compiler));
		 mTab.addTab(mTab.newTabSpec("tag").setIndicator("��Ŀ").setContent(R.id.opt_linker));
	}

}
