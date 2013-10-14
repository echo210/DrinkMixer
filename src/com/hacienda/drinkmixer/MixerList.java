package com.hacienda.drinkmixer;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MixerList extends Activity {
    ArrayList<BoxCheck> mixer = new ArrayList<BoxCheck>();
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    ArrayList<BoxCheck> alcohol = new ArrayList<BoxCheck>();
    
    ListAdapter boxAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		recipes = getIntent().getParcelableArrayListExtra("recipes");
		alcohol = getIntent().getParcelableArrayListExtra("alochol");
		setContentView(R.layout.mixer_list);
		
		mixer.add( new BoxCheck( "Cola", false ));
		mixer.add( new BoxCheck( "Cranberry Juice", false ));	
		mixer.add( new BoxCheck( "Grapefruit Juice", false ));
		mixer.add( new BoxCheck( "Grenadine", false ));
		mixer.add( new BoxCheck( "Lemon Juice", false ));
		mixer.add( new BoxCheck( "Lime Juice", false ));
		mixer.add( new BoxCheck( "Orange Juice", false ));
		mixer.add( new BoxCheck( "Pineapple Juice", false ));
		mixer.add( new BoxCheck( "Tomato Juice", false ));
		
        boxAdapter = new ListAdapter( this, mixer );

        ListView lvMain = (ListView) findViewById( R.id.lvMain );
        lvMain.setAdapter( boxAdapter );

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mixer_list, menu);
		return true;
	}
	
    public void showResult(View v) {
        
    	Intent i=new Intent( this, ChillResults.class );
    	i.putParcelableArrayListExtra( "recipes", recipes );
    	i.putParcelableArrayListExtra( "alochol", alcohol );
    	i.putParcelableArrayListExtra( "mixer", mixer);
        startActivity(i);
      }

}

