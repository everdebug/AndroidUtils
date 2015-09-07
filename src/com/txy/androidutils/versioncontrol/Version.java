package com.txy.androidutils.versioncontrol;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
public class Version extends Activity{
	/**
	 * 得到应用程序的版本名称
	 */
	private String getVersionInfo() {
		// apk包的管理者
		PackageManager pm = getPackageManager();
		try {
			// 得到功能文件清单info？
			PackageInfo info = pm.getPackageInfo(getPackageName(), 0);
			return info.versionName;
		} catch (Exception e) {
			e.printStackTrace();
			return "未找到包";
		}
	}
}
