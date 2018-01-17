package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation blink,zoom_fade;
    TextView react;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        zoom_fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin_fadeout);
        react = findViewById(R.id.react);

        zoom_fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                react.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    int TeamApoints=0;
    int TeamAFouls=0;
    int TeamBPoints=0;
    int TeamBFouls=0;
    public void TeamApoints (View view)
    {
        react.setVisibility(View.VISIBLE);
        react.setText(getResources().getString(R.string.goal));
        react.startAnimation(zoom_fade);
        TeamApoints++;
        ShowTeamAPoints(TeamApoints);
    }
    public void TeamAFouls (View view)
    {
        react.setVisibility(View.VISIBLE);
        react.setText(getResources().getString(R.string.foul));
        react.startAnimation(zoom_fade);
        TeamAFouls++;
        ShowTeamAFouls(TeamAFouls);
    }
    public void TeamBPoints (View view)
    {
        react.setVisibility(View.VISIBLE);
        react.setText(getResources().getString(R.string.goal));
        react.startAnimation(zoom_fade);
        TeamBPoints++;
        ShowTeamBPoints(TeamBPoints);
    }
    public void TeamBFouls (View view)
    {
        react.setVisibility(View.VISIBLE);
        react.setText(getResources().getString(R.string.foul));
        react.startAnimation(zoom_fade);
        TeamBFouls++;
        ShowTeamBFouls(TeamBFouls);
    }
    public void ShowTeamAPoints (int TeamAPoints)
    {
        TextView t=findViewById(R.id.TeamAPointsText);
        t.startAnimation(blink);
        t.setText(""+TeamAPoints);
    }
    public void ShowTeamBPoints (int TeamBPoints)
    {

        TextView t=findViewById(R.id.TeamBPointsText);
        t.startAnimation(blink);
        t.setText(""+TeamBPoints);

    }
    public void ShowTeamAFouls (int TeamAFouls)
    {
        TextView t=findViewById(R.id.TeamAFoulsText);
        t.startAnimation(blink);
        t.setText(""+TeamAFouls);
    }
    public void ShowTeamBFouls (int TeamBFouls)
    {
        TextView t=findViewById(R.id.TeamBFoulsText);
        t.startAnimation(blink);
        t.setText(""+TeamBFouls);

    }
    public void reset (View view)
    {
        TeamApoints=0;
        TeamAFouls=0;
        TeamBPoints=0;
        TeamBFouls=0;
        ShowTeamAPoints(TeamApoints);
        ShowTeamAFouls(TeamAFouls);
        ShowTeamBPoints(TeamBPoints);
        ShowTeamBFouls(TeamBPoints);
    }
}