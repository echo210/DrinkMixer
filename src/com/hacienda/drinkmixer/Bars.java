package com.hacienda.drinkmixer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Bars extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] bars={"Bogart's Lounge & Tech Pub",
				"Faultline Brewing Company","Bennigan's",
				"Quarter Note Bar & Grill"};
		setListAdapter(new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1, bars));
		
	}
		
		protected void onListItemClick(ListView l, View v, int position, long id){
			switch (position) {
			case 0:
				startActivity(new Intent(Bars.this, Bogarts.class));
				break;

			case 1:
				startActivity(new Intent(Bars.this, Faultline.class));
				break;
				
			case 2:
				startActivity(new Intent(Bars.this, Bennigans.class));
				break;
				
			case 3:
				startActivity(new Intent(Bars.this, QuarterNote.class));
				break;
				
			
			}
	}

}
