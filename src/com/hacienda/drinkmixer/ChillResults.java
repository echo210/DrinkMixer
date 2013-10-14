package com.hacienda.drinkmixer;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChillResults extends ListActivity {
    ArrayList<BoxCheck> mixer = new ArrayList<BoxCheck>();
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    ArrayList<BoxCheck> alcohol = new ArrayList<BoxCheck>();
    ArrayList<Recipe> results = new ArrayList<Recipe>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		recipes = getIntent().getParcelableArrayListExtra("recipes");
		alcohol = getIntent().getParcelableArrayListExtra("alochol");
		mixer = getIntent().getParcelableArrayListExtra("mixer");
		
		search();

		String[] titles = new String[results.size()];
		for( int i = 0; i < titles.length; i++ ) {
			titles[i] = results.get( i ).getName();
		}
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, titles));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chill_results, menu);
		return true;
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Intent i = new Intent( this, ShowRecipe.class );
		i.putExtra("recipe", results.get( position ));
		startActivity( i );

	}
	
	private void search() {
		
		for( int i = 0; i < recipes.size(); i++ ) {
			if(recipes.get(i).contains(alcohol, mixer)) {
				results.add(recipes.get( i ));
			}
		}
	}
	
}
