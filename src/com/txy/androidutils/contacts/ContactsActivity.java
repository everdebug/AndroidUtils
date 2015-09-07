package com.txy.androidutils.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.txy.androidutils.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
/**
 * 
 * 获取电话联系人基本信息，通过查询数据库
 * @author lenovo
 *
 */
public class ContactsActivity extends Activity {
	private ListView lv_contactlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);

		lv_contactlist = (ListView) findViewById(R.id.lv_contactlist);

		final List<Map<String, String>> contactlist = getContactList();

		lv_contactlist.setAdapter(new SimpleAdapter(this, contactlist,
				R.layout.item_contact, new String[] { "name", "phone" },
				new int[] { R.id.tv_contact_name, R.id.tv_contact_phone }));
		lv_contactlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Map<String, String> map = contactlist.get(position);
				Intent data = new Intent();
				data.putExtra("phone", map.get("phone"));
				setResult(0, data);

				finish();
			}
		});

	}

	/**
	 * 获取联系人信息
	 * 
	 * @return
	 */
	private List<Map<String, String>> getContactList() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 通过内容观察者得到数据
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri datauri = Uri.parse("content://com.android.contacts/data");
		// 在raw_contacts中获得contact_id
		Cursor cursor = resolver.query(uri, new String[] { "contact_id" },
				null, null, null);
		if (cursor != null) {
			while (cursor.moveToNext()) {
				String id = cursor.getString(0);
				if (id != null) {
					Map<String, String> map = new HashMap<String, String>();

					// 在data获得name和phone
					Cursor datecursor = resolver.query(datauri, new String[] {
							"data1", "mimetype" }, "raw_contact_id=?",
							new String[] { id }, null);
					if (datecursor != null) {
						while (datecursor.moveToNext()) {
							String data1 = datecursor.getString(0);
							String mimetype = datecursor.getString(1);
							if ("vnd.android.cursor.item/name".equals(mimetype)) {
								map.put("name", data1);
							}
							if ("vnd.android.cursor.item/phone_v2"
									.equals(mimetype)) {
								map.put("phone", data1);
							}
						}
						list.add(map);
						System.out.println(map.get("name") + "---"
								+ map.get("phone"));
					}
					datecursor.close();
				}
			}

		}
		cursor.close();
		return list;
	}
}
