package com.txy.androidutils.intent;

import android.content.Intent;
import android.view.View;
import android.app.Activity;
/**
 * @Intent��һЩʵ�÷�ʽ������
 * */
public class IntentUtils {
	/**
	 * @�ڿ�������һ�������з�������
	 * */
	public static void returnintentdate(View view, Activity activity) {
		String smsinfo = "Ҫ���͵���Ϣ";
		Intent data = new Intent();
		data.putExtra("smsinfo", smsinfo);
		// ��������
		activity.setResult(0, data);// ���÷����뼰���ص���ͼ����ͼ�����������ݣ�
		activity.finish();
	}

	/**
	 * @����activity����дonActivityResult��������ͨ��switch case �����ֲ�ͬ�ķ���ֵ
	 * 
	 * */
	public static void getintentdate(int requestCode, int resultCode,
			Intent data) {

		// protected void onActivityResult(int requestCode, int resultCode,
		// Intent data) {
		// requestCode-->��startActivityForResult(intent,
		// 1)����/resultCode��setResult(0,data)������
		switch (requestCode) {
		case 0:
			if (data != null) {
				String smsinfo = data.getStringExtra("smsinfo");
				// et_sms.setText(smsinfo);����UI
			}
			break;
		case 1:
			if (data != null) {
				String numberinfo = data.getStringExtra("numberinfo");
				// et_number.setText(numberinfo);����UI
			}
			break;

		default:
			break;
		}

		// super.onActivityResult(requestCode, resultCode, data);
	}
}
