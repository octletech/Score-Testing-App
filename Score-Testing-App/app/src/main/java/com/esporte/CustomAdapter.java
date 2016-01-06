package com.esporte;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aky on 12/23/2015.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    CustomAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    /* private view holder class */
    private class ViewHolder {
        TextView player_name;
        TextView ranking;
        TextView playText;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        holder = new ViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);

            holder.player_name = (TextView) convertView
                    .findViewById(R.id.member_name);
            holder.ranking = (TextView) convertView
                    .findViewById(R.id.member_rank_text);
            holder.playText = (TextView) convertView
                    .findViewById(R.id.play_text);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        RowItem row_pos = rowItems.get(position);


        Animation animBlink = AnimationUtils.loadAnimation(context,
                R.anim.blink);
        holder.playText.setAnimation(animBlink);
        holder.player_name.setText(row_pos.getPlayer_name());
        holder.ranking.setText(row_pos.getRanking());
        return convertView;
    }

}