package com.hacienda.drinkmixer;


import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {
	
	private String name;
	private ArrayList<Ingredient> ingredients;
	private String directions;

	
	
	public Recipe( String title, String steps, ArrayList<Ingredient> items ) {
		setName( title );
		setDirections( steps );
        ingredients = new ArrayList<Ingredient>();
		for( int i = 0; i < items.size(); i++ ) {
			addIngredient( items.get(i) );
        }
	}


	public String getName() {
		return name;
	}
	
	public String getDirections() {
		return directions;
	}
	
	public Ingredient getIngredient( int i ) {
		return ingredients.get( i );
	}
	
	
	public int getIngredientSize() {
		return ingredients.size();
	}
	
	public void setName( String n ) {
		name = n;
	}
	
	
	public void setDirections( String d ) {
		directions = d;
	}
	
	public void addIngredient( Ingredient ingred ) {
		ingredients.add( ingred );
	}
	
	public boolean contains(ArrayList<BoxCheck> alcohol, ArrayList<BoxCheck> mixer) {
		boolean value = false;
		int alcoholCount = 0;
		int count = 2;
		
		for( int i = 0; i < getIngredientSize(); i++ ) {
			if( getIngredient( i ).getItem().isAlcohol() ) {
				for( int j = 0; j < alcohol.size(); j++ ) {
					if( getIngredient( i ).getItem().getName().equals( alcohol.get( j ).getName() ) ) {
						if( alcohol.get( j ).isChecked() ) {
							count++;
						} else {
							alcoholCount--;
							if( alcoholCount < 0 )
								return value;
						}
						break;
					} 

				}
			} else {
			
				for( int j = 0; j < mixer.size(); j++ ) {
					if( getIngredient( i ).getItem().getName().equals( mixer.get( j ).getName() ) ) {
						if( mixer.get( j ).isChecked() ) {
							count++;
						}
					
						break;
					}
				}
				count--;
			}
		}
		
		if( count > 0 ) {
			value = true;
		}
		return value;
	}
	
	@Override
	public String toString() {
		
		String text = getName() + "\n\n";
		for( int i = 0; i < ingredients.size(); i++ )
			text += ingredients.get( i ) + "\n";
		
		text += "\n" + getDirections();
		
		return text;
	}


	@Override
	public int describeContents() {
		return 0;
	}


	@Override
	public void writeToParcel( Parcel out, int flags ) {
		out.writeString( getName() );
		out.writeInt( ingredients.size() );
		for( int i = 0; i < ingredients.size(); i++ ) {
			out.writeValue( ingredients.get( i ) );
		}
		out.writeString( getDirections() );
		
	}
	
    public static final Parcelable.Creator<Recipe> CREATOR
    		= new Parcelable.Creator<Recipe>() {
    	public Recipe createFromParcel( Parcel in ) {
    		return new Recipe( in );
    	}

    	public Recipe[] newArray( int size ) {
    		return new Recipe[size];
    	}
    };

    private Recipe( Parcel in ) {
    	setName( in.readString() );
    	int size = in.readInt();
    	ingredients = new ArrayList<Ingredient>();
    	for( int i = 0; i < size; i++ ) {
    		addIngredient( (Ingredient) in.readValue( Ingredient.class.getClassLoader() ) );
    	}
    	setDirections( in.readString() );
    }

}
