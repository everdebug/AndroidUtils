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

			// �ı��ı�ʱʹ��
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.length() >= 3) {
					//String addr = NumberSelectUtils.getAddr(s.toString());
					//tv_result.setText(addr);
				}
			}

			//�ı��仯֮ǰ�ı�
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			//�ı��仯֮��ʹ��
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}
}
