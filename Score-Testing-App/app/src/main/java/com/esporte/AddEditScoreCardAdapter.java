package com.esporte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
* Created by Aky on 1/7/2016.
*/
class AddEditScoreCardAdapter extends ArrayAdapter<RowPointItem> {

private final Context context;
private final ArrayList<RowPointItem> rowPointItemArrayList;

public AddEditScoreCardAdapter(Context context, ArrayList<RowPointItem> rowPointItemArrayList) {

   super(context, R.layout.row_point_item, rowPointItemArrayList);

   this.context = context;
   this.rowPointItemArrayList = rowPointItemArrayList;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

   LayoutInflater inflater = (LayoutInflater) context
           .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

   View rowView = inflater.inflate(R.layout.row_edit_point_item, parent, false);

   TextView setNumber = (TextView) rowView.findViewById(R.id.set_number_add);
   EditText PlayerOnePointEt = (EditText) rowView.findViewById(R.id.player_one_points_edittext);
   EditText PlayerTwoPointEt = (EditText) rowView.findViewById(R.id.player_two_points_edittext);

   setNumber.setText(rowPointItemArrayList.get(position).getSet());
   PlayerOnePointEt.setText(rowPointItemArrayList.get(position).getPpoint1());
   PlayerTwoPointEt.setText(rowPointItemArrayList.get(position).getPpoint2());
   return rowView;
}
}
