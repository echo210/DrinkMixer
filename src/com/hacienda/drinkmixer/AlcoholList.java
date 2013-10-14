package com.hacienda.drinkmixer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class AlcoholList extends Activity {
    ArrayList<BoxCheck> alcohol = new ArrayList<BoxCheck>();
    ArrayList<Recipe> recipes;
    ListAdapter boxAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alcohol_list);
		
		alcohol.add( new BoxCheck( "Blue Curacao", false ));
		alcohol.add( new BoxCheck( "Bourbon", false ));
		alcohol.add( new BoxCheck( "Brandy", false ));
		alcohol.add( new BoxCheck( "Coffee Liqueur", false ));
		alcohol.add( new BoxCheck( "Gin", false ));
		alcohol.add( new BoxCheck( "Rum", false ));
		alcohol.add( new BoxCheck( "Tequila", false ));
		alcohol.add( new BoxCheck( "Triple Sec", false ));
		alcohol.add( new BoxCheck( "Whiskey", false ));
		alcohol.add( new BoxCheck( "Vodka", false ));
		
        boxAdapter = new ListAdapter( this, alcohol );
        ListView lvMain = (ListView) findViewById( R.id.lvMain );
        lvMain.setAdapter( boxAdapter );
        
        Scanner input = null;
        AssetManager assetManager = getResources().getAssets();
        
        recipes = new ArrayList<Recipe>();

        // try to open the input file
        try
        {
            input = new Scanner( assetManager.open("drink_recipes.txt") );
        }// end of try
        catch (IOException e) {
        	System.err.println( "Error opening file." );
			e.printStackTrace();
		}

        try
        {
            while( input.hasNext() ) {

            	String name = input.nextLine();
            	String quan = input.nextLine();
            	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
            	while( !quan.equals("done") )  {
            		String n = input.nextLine();
            		ingredients.add( new Ingredient( quan, new Item( n ) ) );
            		quan = input.nextLine();
            	}
            	String directions = input.nextLine();
            	recipes.add( new Recipe(name, directions, ingredients ));
            	quan = input.nextLine();
            	quan = input.nextLine();
            }

        }// end of try
        catch ( NoSuchElementException elementException )
        {
            System.err.println( "File improperly formed." );
            input.close();
            System.exit( 1 );
        }// end of catch
        catch ( IllegalStateException stateException )
        {
            System.err.println( "Error reading from file." );
            System.exit( 1 );
        }// end of catch

        // close input
        if( input != null ) {
            input.close();
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alcohol_list, menu);
		return true;
	}
	
    public void showResult(View v) {
    	
    	Intent i=new Intent(this, MixerList.class);
    	i.putParcelableArrayListExtra("recipes", recipes);
    	i.putParcelableArrayListExtra("alochol", alcohol);
        startActivity(i);
    	
      }

}
