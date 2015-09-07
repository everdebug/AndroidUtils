package com.txy.androidutils.numberselect;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NumberSelectUtils {
	static String path = "data/data/com.txy.mobliesafe/files/address.db";

	/**
	 * 简单的号码归属地查询
	 * 
	 * @param number
	 *            要查询的号码
	 * @return 归属地
	 */
	public static String getAddr(String number) {
		String location = "未找到";
		SQLiteDatabase database = SQLiteDatabase.openDatabase(path, null,
				SQLiteDatabase.OPEN_READONLY);
		// 正常手机号码
		if (number.matches("^1[345678]\\d{9}$")) {
			Cursor cursor = database
					.rawQuery(
							"select location from data2 where id = (select outkey from data1 where id = ?)",
							new String[] { number.substring(0, 7) });

			// "select location from data2 where id = (select out key from data1 where id = ?)",
			// new String[] { number.substring(0, 7) });
			while (cursor.moveToNext()) {
				String Addr = cursor.getString(0);
				location = Addr;
			}

			cursor.close();
		} else {
			switch (number.length()) {
			case 3:
				location = "特殊号码";
				break;
			case 4:
				location = "模拟器";
				break;
			case 5:
				location = "客服电话";
				break;
			case 7:
				location = "本地";
				break;
			case 8:
				location = "本地";
				break;
			default:
				if (number.length() > 0 && number.startsWith("0")) {
					Cursor cursor = database.rawQuery(
							"select location from data2 where area = ?",
							new String[] { number.substring(1, 3) });
					while (cursor.moveToNext()) {
						location = cursor.getString(0);
						location = location.substring(0, location.length() - 2);

					}
					cursor.close();

					cursor = database.rawQuery(
							"select location from data2 where area = ?",
							new String[] { number.substring(1, 4) });
					while (cursor.moveToNext()) {
						location = cursor.getString(0);
						location = location.substring(0, location.length() - 2);

					}
					cursor.close();

				}
				break;
			}
		}

		return location;
	}
}
