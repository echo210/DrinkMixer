package com.hacienda.drinkmixer;


import android.os.Parcel;
import android.os.Parcelable;

public class BoxCheck implements Parcelable {
    private String name;
    private boolean box;
   

    public BoxCheck(String n, boolean b) {
      setName( n );
      setChecked( b );
    }
    
    public String getName() {
    	return name;
    }
    
    public boolean isChecked() {
    	return box;
    }
    
    public void setChecked( boolean value ) {
    	box = value;
    }
    
    public void setName( String n ) {
    	name = n;
    }

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString( getName() );
		out.writeInt( isChecked() ? 1 : 0 );
		
	}
	
    public static final Parcelable.Creator<BoxCheck> CREATOR = new Parcelable.Creator<BoxCheck>() {
    	public BoxCheck createFromParcel( Parcel in ) {
    		return new BoxCheck( in );
    	}

    	public BoxCheck[] newArray( int size ) {
    		return new BoxCheck[size];
    	}
    };

    private BoxCheck( Parcel in ) {
    	setName( in.readString() );
    	setChecked( ( in.readInt() != 0 ? true : false ) );
    	

    }


}
