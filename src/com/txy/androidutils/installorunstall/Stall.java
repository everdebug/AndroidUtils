package com.txy.androidutils.installorunstall;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

public class Stall extends Activity {

	/**
	 * ��װapk ��ͼ����
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
	 * ���� ���ֻ��Ϲ���ǿ�󣬿��Է����������ͼ����send��Ӧ��
	 */
	private void share() {
		Intent intent = new Intent();
		intent.setAction("android.intent.action.SEND");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, "����ʱ�����������");
		startActivity(intent);
	}

	/**
	 * ж�س���
	 */
	private void uninstall() {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_DELETE);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setData(Uri.parse("package:" + getPackageName()));// ����Ӱ�������Ӧ������
		startActivityForResult(intent, 0);// ����д��û�з���ֵ��startActivity
	}

	/**
	 * ��Ӧ��
	 */
	private void openApp() {
		Intent intent;
		PackageManager pm = getPackageManager();
		intent = pm.getLaunchIntentForPackage(getPackageName());// ͬ��
		if (intent != null) {
			startActivity(intent);
		} else {
			Toast.makeText(Stall.this, "Ӧ���޷���", Toast.LENGTH_SHORT).show();
		}
	}
}
