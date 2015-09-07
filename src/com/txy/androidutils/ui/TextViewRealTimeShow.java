package com.txy.androidutils.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextViewRealTimeShow extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		EditText et_number = new EditText(TextViewRealTimeShow.this);
		et_number.addTextChangedListener(new TextWatcher() {

			// 文本改变时使用
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.length() >= 3) {
					//String addr = NumberSelectUtils.getAddr(s.toString());
					//tv_result.setText(addr);
				}
			}

			//文本变化之前改变
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			//文本变化之后使用
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}
}
