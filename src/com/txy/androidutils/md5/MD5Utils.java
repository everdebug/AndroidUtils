package com.txy.androidutils.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5һ�ּ����㷨
 */
public class MD5Utils {
	public static String MD5Password(String password) {

		try {
			// �õ���ϢժҪ
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] bs = digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			// �㷨����,ÿһλ������������
			for (byte b : bs) {
				int number = b & 0xff;
				String str = Integer.toString(number);
				if (str.length() == 1) {
					buffer.append(0);
				}
				buffer.append(str);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}

	}
}
