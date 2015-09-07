package com.txy.androidutils.animiation;

import com.txy.androidutils.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

public class AnimationEffect extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ���ý��䶯�����������ǿ�ʼ�ͽ����ĶԱȶ�
		AlphaAnimation aa = new AlphaAnimation(0.2f, 1.0f);
		aa.setDuration(1000);// ����ʱ��
		findViewById(com.txy.androidutils.R.id.root).startAnimation(aa);// ����ʹ�ö�����view

		finish();
		//Activity�л����ȶ���		
		overridePendingTransition(R.anim.tran_in, R.anim.tran_out);

	}
}
