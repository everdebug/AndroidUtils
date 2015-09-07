package com.txy.androidutils.installorunstall;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

public class Stall extends Activity {

	/**
	 * 安装apk 意图过滤
	 */
	@SuppressWarnings("unused")
	private void installAPK(File t) {
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.setDataAndType(Uri.fromFile(t),
				"application/vnd.android.package-archive");
		startActivity(intent);
	}

	/**
	 * 分享 在手机上功能强大，可以分享给所有意图中有send的应用
	 */
	private void share() {
		Intent intent = new Intent();
		intent.setAction("android.intent.action.SEND");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, "分享时候输入的数据");
		startActivity(intent);
	}

	/**
	 * 卸载程序
	 */
	private void uninstall() {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_DELETE);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setData(Uri.parse("package:" + getPackageName()));// 后面加包名不是应用名称
		startActivityForResult(intent, 0);// 可以写成没有返回值的startActivity
	}

	/**
	 * 打开应用
	 */
	private void openApp() {
		Intent intent;
		PackageManager pm = getPackageManager();
		intent = pm.getLaunchIntentForPackage(getPackageName());// 同上
		if (intent != null) {
			startActivity(intent);
		} else {
			Toast.makeText(Stall.this, "应用无法打开", Toast.LENGTH_SHORT).show();
		}
	}
}
