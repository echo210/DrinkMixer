package com.hacienda.drinkmixer;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {
	
    private String quantity;
    private Item item;
    
    public Ingredient( String quan, Item i ) {
        setQuantity( quan );
        setItem( i );
        
    }
   
    
    public String getQuantity() {
        return quantity;
    }
    
    public final void setQuantity( String quan ) {
        quantity = quan;
    }
    
    public Item getItem() {
        return item;
    }
    
    public final void setItem( Item i ) {
        item = new Item( i.getName() );
    }
    
    
    @Override
    public String toString() {
    	if( getQuantity().equals( "" ) ) {
    		return String.format( "%s", item.toString() );
    	}
        return String.format( "%s  %s", getQuantity(), item.toString() );
    }
    
    

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString( getQuantity() );
		out.writeValue( item );
		
		
	}
	
    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
    	public Ingredient createFromParcel( Parcel in ) {
    		return new Ingredient( in );
    	}

    	public Ingredient[] newArray( int size ) {
    		return new Ingredient[size];
    	}
    };

    private Ingredient( Parcel in ) {
    	setQuantity( in.readString() );
    	setItem( (Item) in.readValue( Item.class.getClassLoader() ));

    }

}
