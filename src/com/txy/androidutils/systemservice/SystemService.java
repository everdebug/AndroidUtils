package com.txy.androidutils.systemservice;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
/**
 * ��Ҫ���ܸ���ϵͳ����
 * @author lenovo
 *
 */
public class SystemService extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	/*
	 * �绰�����ߣ����Ի��sim����һ��Ψһֵ��
	 * */
	TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	
}
}
