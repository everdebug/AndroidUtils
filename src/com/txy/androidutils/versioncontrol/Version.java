package com.txy.androidutils.versioncontrol;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
public class Version extends Activity{
	/**
	 * �õ�Ӧ�ó���İ汾����
	 */
	private String getVersionInfo() {
		// apk���Ĺ�����
		PackageManager pm = getPackageManager();
		try {
			// �õ������ļ��嵥info��
			PackageInfo info = pm.getPackageInfo(getPackageName(), 0);
			return info.versionName;
		} catch (Exception e) {
			e.printStackTrace();
			return "δ�ҵ���";
		}
	}
}
