package com.txy.androidutils.intent;

import android.content.Intent;
import android.view.View;
import android.app.Activity;
/**
 * @Intent的一些实用方式工具类
 * */
public class IntentUtils {
	/**
	 * @在开启的另一个界面中返回数据
	 * */
	public static void returnintentdate(View view, Activity activity) {
		String smsinfo = "要传送的信息";
		Intent data = new Intent();
		data.putExtra("smsinfo", smsinfo);
		// 设置数据
		activity.setResult(0, data);// 设置返回码及返回的意图（意图用来传送数据）
		activity.finish();
	}

	/**
	 * @在主activity中重写onActivityResult方法，并通过switch case 来区分不同的返回值
	 * 
	 * */
	public static void getintentdate(int requestCode, int resultCode,
			Intent data) {

		// protected void onActivityResult(int requestCode, int resultCode,
		// Intent data) {
		// requestCode-->在startActivityForResult(intent,
		// 1)设置/resultCode在setResult(0,data)中设置
		switch (requestCode) {
		case 0:
			if (data != null) {
				String smsinfo = data.getStringExtra("smsinfo");
				// et_sms.setText(smsinfo);更新UI
			}
			break;
		case 1:
			if (data != null) {
				String numberinfo = data.getStringExtra("numberinfo");
				// et_number.setText(numberinfo);更新UI
			}
			break;

		default:
			break;
		}

		// super.onActivityResult(requestCode, resultCode, data);
	}
}
