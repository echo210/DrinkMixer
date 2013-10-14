package com.hacienda.drinkmixer;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ShowRecipe extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_recipe);
		TextView result = (TextView) findViewById(R.id.result);
		Recipe rec = getIntent().getParcelableExtra("recipe");
		result.setText( rec.toString() );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_recipe, menu);
		return true;
	}

}