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
    TextView react,BFouls,AFouls,BPoints,APoints;
    int TeamAFouls,TeamBPoints,TeamBFouls,TeamApoints;
    String PointsOfTeamA = "APOINTS",PointsOfTeamB="BPOINTS",FoulsOfTeamA="AFOULS",FoulsOfTeamB="BFOULS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        zoom_fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin_fadeout);

        react = findViewById(R.id.react);

        BFouls=findViewById(R.id.TeamBFoulsText);
        AFouls=findViewById(R.id.TeamAFoulsText);

        BPoints=findViewById(R.id.TeamBPointsText);
        APoints=findViewById(R.id.TeamAPointsText);

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
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(PointsOfTeamA,TeamApoints);
        savedInstanceState.putInt(PointsOfTeamB, TeamBPoints);
        savedInstanceState.putInt(FoulsOfTeamA,TeamAFouls);
        savedInstanceState.putInt(FoulsOfTeamB,TeamBFouls);
        super.onSaveInstanceState(savedInstanceState);
    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TeamApoints = savedInstanceState.getInt(PointsOfTeamA);
        TeamBPoints = savedInstanceState.getInt(PointsOfTeamB);
        TeamAFouls = savedInstanceState.getInt(FoulsOfTeamA);
        TeamBFouls = savedInstanceState.getInt(FoulsOfTeamB);
        ShowTeamAPoints(TeamApoints);
        ShowTeamAFouls(TeamAFouls);
        ShowTeamBPoints(TeamBPoints);
        ShowTeamBFouls(TeamBFouls);
    }
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
        APoints.startAnimation(blink);
        APoints.setText(""+TeamAPoints);
    }
    public void ShowTeamBPoints (int TeamBPoints)
    {
        BPoints.startAnimation(blink);
        BPoints.setText(""+TeamBPoints);
    }
    public void ShowTeamAFouls (int TeamAFouls)
    {
        AFouls.startAnimation(blink);
        AFouls.setText(""+TeamAFouls);
    }
    public void ShowTeamBFouls (int TeamBFouls)
    {
        BFouls.startAnimation(blink);
        BFouls.setText(""+TeamBFouls);
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