package com.txy.androidutils.gesturedetector;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * ���������࣬���ж����Ƶ�ʶ�����Ӧ�Ĳ���
 * 
 * @author tian
 * 
 */
public abstract class BaseSetupActivity extends Activity {

	// ����
	private GestureDetector gd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ʵ�ּ�����
		gd = new GestureDetector(this,
				new GestureDetector.SimpleOnGestureListener() {

					@Override
					public boolean onFling(MotionEvent e1, MotionEvent e2,
							float velocityX, float velocityY) {
						// �������²��ܻ���
						if (Math.abs(e1.getRawY() - e2.getRawY()) > 100) {
							return true;
						}
						// �ٶ������ܻ���
						if (Math.abs(velocityX) < 100) {
							return true;
						}
						// ��
						if (e1.getRawX() - e2.getRawX() > 200) {
							Log.e("BaseSetupActivity", "��");
							showNext();
							return true;
						}
						// ��
						if (e2.getRawX() - e1.getRawX() > 200) {
							Log.e("BaseSetupActivity", "��");
							// ��һ��
							showPre();
							return true;
						}
						return super.onFling(e1, e2, velocityX, velocityY);
					}
				});
	}

	/**
	 * �����������󷽷��������������ʱ�Զ���
	 */
	public abstract void showNext();

	public abstract void showPre();

	// ʶ�������¼�
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		gd.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
}
