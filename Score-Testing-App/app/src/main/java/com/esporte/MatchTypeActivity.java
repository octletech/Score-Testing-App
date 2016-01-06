package com.esporte;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MatchTypeActivity extends AppCompatActivity {
EditText pointsPerSets;
    EditText noSets;
    Button startPlaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_type);
        pointsPerSets = (EditText)findViewById(R.id.points_per_sets);
        noSets = (EditText)findViewById(R.id.no_of_sets);
        startPlaying = (Button) findViewById(R.id.start_play);

        startPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PointsPerSet = pointsPerSets.getText().toString();
                String NoOfSets = noSets.getText().toString();
                Toast.makeText(MatchTypeActivity.this,""+NoOfSets+PointsPerSet,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
