package com.txy.androidutils.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedpreferenceUtils {
	public static void save2PhoneMm(Context context, String username,
			String password) {
		// 使用sharedpreference 保存数据
		SharedPreferences sp = context.getSharedPreferences("config",
				Context.MODE_PRIVATE);//在shared_prefs目录下新建**。xml文件
		// 得到一个sp的编辑器
		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		// 使用edit，必须使用commit进行提交，文件才能保存。
		// 类似数据库的事务，保证数据同时提交成功
		editor.commit();
		
		
		//sharedpreference可以用来存储大量config即配置信息或设置信息
		
		editor.putBoolean("open", true);
		editor.putInt("count", 32);
		editor.putFloat("pi", 3.1415926f);
		
		

	}
}
