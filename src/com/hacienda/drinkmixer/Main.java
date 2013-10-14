package com.hacienda.drinkmixer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final RadioButton chill = (RadioButton) findViewById(R.id.chillAtHome);
		final RadioButton town = (RadioButton) findViewById(R.id.hitTheTown);
	
		Button submit = (Button) findViewById(R.id.btnPartay);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(chill.isChecked()){
					startActivity(new Intent(Main.this, AlcoholList.class));
				}
				
				if(town.isChecked()){
					startActivity(new Intent(Main.this, Bars.class));
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		startActivity(new Intent(Main.this, GetCab.class));
		return super.onOptionsItemSelected(item);
	}
}

