package com.txy.androidutils.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedpreferenceUtils {
	public static void save2PhoneMm(Context context, String username,
			String password) {
		// ʹ��sharedpreference ��������
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);//��shared_prefsĿ¼���½�**��xml�ļ�
		// �õ�һ��sp�ı༭��
		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		// ʹ��edit������ʹ��commit�����ύ���ļ����ܱ��档
		// �������ݿ�����񣬱�֤����ͬʱ�ύ�ɹ�
		editor.commit();
		
		
		//sharedpreference���������洢����config��������Ϣ��������Ϣ
		
		editor.putBoolean("open", true);
		editor.putInt("count", 32);
		editor.putFloat("pi", 3.1415926f);
		
		

	}
}
