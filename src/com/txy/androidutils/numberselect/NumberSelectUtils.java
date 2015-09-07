package com.txy.androidutils.numberselect;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NumberSelectUtils {
	static String path = "data/data/com.txy.mobliesafe/files/address.db";

	/**
	 * �򵥵ĺ�������ز�ѯ
	 * 
	 * @param number
	 *            Ҫ��ѯ�ĺ���
	 * @return ������
	 */
	public static String getAddr(String number) {
		String location = "δ�ҵ�";
		SQLiteDatabase database = SQLiteDatabase.openDatabase(path, null,
				SQLiteDatabase.OPEN_READONLY);
		// �����ֻ�����
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
				location = "�������";
				break;
			case 4:
				location = "ģ����";
				break;
			case 5:
				location = "�ͷ��绰";
				break;
			case 7:
				location = "����";
				break;
			case 8:
				location = "����";
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
