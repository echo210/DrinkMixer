package com.hacienda.drinkmixer;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<BoxCheck> objects;
    
    
    public ListAdapter(Context context, ArrayList<BoxCheck> Alcohol) {
        ctx = context;
        objects = Alcohol;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	@Override
	public int getCount() {
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		return objects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        BoxCheck p = getAlcohol(position);

        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.getName());

        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.isChecked());
        return view;
	}
	
	public BoxCheck getAlcohol( int position ) {
		return (BoxCheck) getItem( position );
	}
	
	
    ArrayList<BoxCheck> getBox() {
        ArrayList<BoxCheck> box = new ArrayList<BoxCheck>();
        for (BoxCheck p : objects) {
            if (p.isChecked())
                box.add(p);
        }
        return box;
    }


	
    OnCheckedChangeListener myCheckChangeList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getAlcohol((Integer) buttonView.getTag()).setChecked(isChecked);
        }
    };
}

