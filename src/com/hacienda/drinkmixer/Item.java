package com.hacienda.drinkmixer;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

	
    private String name;
    private boolean alcohol;
    
    
    public Item( String n ) {
        setName( n );
        
        if( n.equals("Bourbon") || n.equals("Brandy") || n.equals("Coffee Liqueur") 
                || n.equals("Gin") || n.equals("Rum") || n.equals("Tequila") 
                || n.equals("Triple Sec") || n.equals("Whiskey") || n.equals("Vodka")) {
            setAlcohol( true );
        }
        else {
            setAlcohol( false );
        }
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isAlcohol() {
        return alcohol;
    }
    
    public final void setName( String n ) {
        name = n;
    }
    
    public final void setAlcohol( boolean a ) {
        alcohol = a;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString( getName() );
		out.writeInt( isAlcohol() ? 1 : 0 );

	}
	
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
    	public Item createFromParcel( Parcel in ) {
    		return new Item( in );
    	}

    	public Item[] newArray( int size ) {
    		return new Item[size];
    	}
    };

    private Item( Parcel in ) {
    	setName( in.readString() );
    	setAlcohol( ( in.readInt() != 0 ? true : false ) );

    }


}