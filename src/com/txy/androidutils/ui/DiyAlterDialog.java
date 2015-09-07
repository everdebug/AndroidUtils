package com.txy.androidutils.ui;



import com.txy.androidutils.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * 自定义对话框 
 */
public class DiyAlterDialog extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		showSetPasswordDialog();

	}

	private SharedPreferences sp = getSharedPreferences("", MODE_PRIVATE);
	private EditText et_password1, et_password2;
	private Button bt_ok, bt_cancel;
	private AlertDialog dialog;

	protected void showSetPasswordDialog() {

		AlertDialog.Builder builder = new Builder(DiyAlterDialog.this);
		View view = View.inflate(DiyAlterDialog.this,
				R.layout.activity_lion_set_dialog, null);
		et_password1 = (EditText) view.findViewById(R.id.et_password1);
		et_password2 = (EditText) view.findViewById(R.id.et_password2);
		bt_ok = (Button) view.findViewById(R.id.bt_ok);
		bt_cancel = (Button) view.findViewById(R.id.bt_cancel);

		bt_cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		bt_ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String password1 = et_password1.getText().toString().trim();
				String password2 = et_password2.getText().toString().trim();
				if (TextUtils.isEmpty(password1)
						|| TextUtils.isEmpty(password2)) {
					Toast.makeText(DiyAlterDialog.this, "密码不能为空", 0).show();
					return;
				} else {
					if (password1.equals(password2)) {
						Editor editor = sp.edit();
						editor.putString("password", password1);
						editor.commit();
						Toast.makeText(DiyAlterDialog.this, "设置密码成功！", 0)
								.show();
					} else {
						Toast.makeText(DiyAlterDialog.this, "两次输入密码不一致", 0)
								.show();
						et_password1.setText("");
						et_password2.setText("");
						return;
					}
				}
				dialog.dismiss();
			}
		});

		//2.3兼容性视图
		dialog = builder.create();
		dialog.setView(view, 0, 0, 0, 0);
		dialog.show();
	}
}
