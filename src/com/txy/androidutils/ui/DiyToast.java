package com.txy.androidutils.ui;

import com.txy.androidutils.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * 
 * 自定义toast 
 * @author lenovo
 *
 */
public class DiyToast extends Activity {

	private View toastView;
	private String TAG = "DiyToast";
private WindowManager wm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		wm = (WindowManager) getSystemService(WINDOW_SERVICE);
	}

	public void myToast(String addr) {
		/*
		 * tv_Toast = new TextView(getApplicationContext());
		 * tv_Toast.setTextSize(25); tv_Toast.setText(addr);
		 */
		int[] bgitems = { R.drawable.call_locate_white,
				R.drawable.call_locate_orange, R.drawable.call_locate_blue,
				R.drawable.call_locate_gray, R.drawable.call_locate_green };
		// 自定义吐司
		toastView = View.inflate(getApplicationContext(),
				R.layout.toast_call_addr, null);
		TextView tv_Toast = (TextView) toastView.findViewById(R.id.tv_addr);
		SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
		int i = sp.getInt("background", 0);
		Log.i(TAG, i + "");
		toastView.setBackgroundResource(bgitems[i]);
		tv_Toast.setTextColor(Color.BLACK);
		tv_Toast.setText(addr);
		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		params.format = PixelFormat.TRANSLUCENT;
		params.type = WindowManager.LayoutParams.TYPE_TOAST;
		wm.addView(toastView, params);

	}
}
