package com.txy.androidutils.animiation;

import com.txy.androidutils.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

public class AnimationEffect extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 设置渐变动画两个参数是开始和结束的对比度
		AlphaAnimation aa = new AlphaAnimation(0.2f, 1.0f);
		aa.setDuration(1000);// 渐变时间
		findViewById(com.txy.androidutils.R.id.root).startAnimation(aa);// 设置使用动画的view

		finish();
		//Activity切换过度动画		
		overridePendingTransition(R.anim.tran_in, R.anim.tran_out);

	}
}
