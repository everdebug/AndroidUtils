package com.txy.androidutils.animiation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GPSIntent extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(this, GPSService.class);
		startService(intent);
	}
}
