package com.txy.androidutils.systemservice;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
/**
 * 主要介绍各种系统服务
 * @author lenovo
 *
 */
public class SystemService extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	/*
	 * 电话管理者，可以获得sim卡的一个唯一值。
	 * */
	TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	
}
}
