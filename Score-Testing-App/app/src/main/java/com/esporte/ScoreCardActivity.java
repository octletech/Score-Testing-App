package com.esporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        ArrayList<RowPointItem> items = new ArrayList<RowPointItem>();
        items.add(new RowPointItem("Set 1","5","3"));
        items.add(new RowPointItem("Set 2","6","6"));
        items.add(new RowPointItem("Set 3","4","5"));

        ScoreCardAdapter adapter = new ScoreCardAdapter(this, items);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        //for add/edit points table
        ArrayList<RowPointItem> additems = new ArrayList<RowPointItem>();
        additems.add(new RowPointItem("Set 1","","" +
                ""));
        additems.add(new RowPointItem("Set 2","",""));
        additems.add(new RowPointItem("Set 3","",""));
        AddEditScoreCardAdapter addEditScoreCardAdapter = new AddEditScoreCardAdapter(this,additems);
        ListView addEditListview = (ListView)findViewById(R.id.add_edit_listview); //add_edit_listview
        addEditListview.setAdapter(addEditScoreCardAdapter);

        Button result = (Button) findViewById(R.id.result_buton);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreCardActivity.this,MatchResultActivity.class);
                startActivity(intent);
            }
        });
    }
}

