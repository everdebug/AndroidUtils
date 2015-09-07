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
		criteria.setAccuracy(criteria.ACCURACY_FINE);//最精确的定位--条件
		String provider = lm.getBestProvider(criteria, true);//自动使用最好的方式提供定位方式
		
		mll = new MyLocationListener();
		lm.requestLocationUpdates(provider, 0, 0, mll);//通过内容提供者，来提供定位方式
		textView = new TextView(GPSDemo.this);
		setContentView(textView);
	}

	@Override
	protected void onDestroy() {
		// 释放资源
		super.onDestroy();
		lm.removeUpdates(mll);
		mll = null;
	}

	class MyLocationListener implements LocationListener {

		// 当位置发生变化 执行者方法
		@Override
		public void onLocationChanged(Location location) {
			String Altitude = "纬度" + location.getAltitude();// 纬度
			String Latitude = "经度" + location.getLatitude();// 经度
			String Longtitude = "高度" + location.getLongitude();// 高度
			textView.setText(Altitude + "\r\n" + Latitude + "\r\n" + Longtitude);
		}

		// 当某一个位置提供者状态发生变化的时候 关闭--》开启 或者开启--》关闭
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
