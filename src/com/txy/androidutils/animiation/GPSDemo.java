package com.txy.androidutils.animiation;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class GPSDemo extends Activity {

	public static final String TAG = "GPSDemo";
	private LocationManager lm;
	private MyLocationListener mll;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lm = (LocationManager) getSystemService(LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		criteria.setAccuracy(criteria.ACCURACY_FINE);//�ȷ�Ķ�λ--����
		String provider = lm.getBestProvider(criteria, true);//�Զ�ʹ����õķ�ʽ�ṩ��λ��ʽ
		
		mll = new MyLocationListener();
		lm.requestLocationUpdates(provider, 0, 0, mll);//ͨ�������ṩ�ߣ����ṩ��λ��ʽ
		textView = new TextView(GPSDemo.this);
		setContentView(textView);
	}

	@Override
	protected void onDestroy() {
		// �ͷ���Դ
		super.onDestroy();
		lm.removeUpdates(mll);
		mll = null;
	}

	class MyLocationListener implements LocationListener {

		// ��λ�÷����仯 ִ���߷���
		@Override
		public void onLocationChanged(Location location) {
			String Altitude = "γ��" + location.getAltitude();// γ��
			String Latitude = "����" + location.getLatitude();// ����
			String Longtitude = "�߶�" + location.getLongitude();// �߶�
			textView.setText(Altitude + "\r\n" + Latitude + "\r\n" + Longtitude);
		}

		// ��ĳһ��λ���ṩ��״̬�����仯��ʱ�� �ر�--������ ���߿���--���ر�
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.i(TAG, status + "");
		}

		@Override
		public void onProviderEnabled(String provider) {

		}

		@Override
		public void onProviderDisabled(String provider) {

		}

	}
}
