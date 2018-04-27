package com.udakita.youtubeapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String YOUTUBEAPI = "AIzaSyBuN-HOJkK79A1QRIWmXx5SYs8d5coX9hM";
    String youtubeid="DVuZ97S6PM0";

    YouTubePlayerView youTubePlayer;
    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnStop)
    Button btnStop;
    YouTubePlayer youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        youTubePlayer =(YouTubePlayerView)findViewById(R.id.youTubePlayer);
        youTubePlayer.initialize(YOUTUBEAPI,this);
    }

    @OnClick({R.id.btnPlay, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                youtube.play();
                break;
            case R.id.btnStop:
                youtube.pause();
                break;
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youtube = youTubePlayer;
        if (youtubeid!=null){
            if (b){
                youtube.play();
            }else{
                youtube.loadVideo(youtubeid);
            }
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "gagal memuat video youtube", Toast.LENGTH_SHORT).show();
    }
}
