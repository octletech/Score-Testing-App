package com.esporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlayMatchActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView playTextView;

    String[] player_names;
    String[] ranking;
    List<RowItem> rowItems;
    ListView mylistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_match);
        rowItems = new ArrayList<RowItem>();

        player_names = getResources().getStringArray(R.array.Member_names);
        ranking = getResources().getStringArray(R.array.ranking);

        for (int i = 0; i < player_names.length; i++) {
            RowItem item = new RowItem(player_names[i],ranking[i]);
            rowItems.add(item);
        }
        mylistview = (ListView) findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), rowItems);
        mylistview.setAdapter(adapter);
        mylistview.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        String member_name = rowItems.get(position).getPlayer_name();
        Toast.makeText(this, "" + member_name,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(),MatchTypeActivity.class);
        startActivity(intent);
    }
}
