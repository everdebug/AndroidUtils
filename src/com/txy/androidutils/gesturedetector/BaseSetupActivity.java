package com.txy.androidutils.gesturedetector;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * 定义手势类，进行对手势的识别和响应的操作
 * 
 * @author tian
 * 
 */
public abstract class BaseSetupActivity extends Activity {

	// 定义
	private GestureDetector gd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 实现监听类
		gd = new GestureDetector(this,
				new GestureDetector.SimpleOnGestureListener() {

					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						// 控制上下不能滑动
						if (Math.abs(e1.getRawY() - e2.getRawY()) > 100) {
							return true;
						}
						// 速度慢不能滑动
						if (Math.abs(velocityX) < 100) {
							return true;
						}
						// 下
						if (e1.getRawX() - e2.getRawX() > 200) {
							Log.e("BaseSetupActivity", "下");
							showNext();
							return true;
						}
						// 上
						if (e2.getRawX() - e1.getRawX() > 200) {
							Log.e("BaseSetupActivity", "上");
							// 上一个
							showPre();
							return true;
						}
						return super.onFling(e1, e2, velocityX, velocityY);
					}
				});
	}

	/**
	 * 定义两个抽象方法，让其他类调用时自定义
	 */
	public abstract void showNext();

	public abstract void showPre();

	// 识别手势事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		gd.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
}
