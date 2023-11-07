package com.example.pruebavideo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video_view;
    MediaPlayer mediaPlayer;
    Button audioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video_view = findViewById(R.id.videoView);
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        audioButton = findViewById(R.id.audioButton);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri videoUri = Uri.parse(path);
        video_view.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(this);
        video_view.setMediaController(mediaController);
        mediaController.setAnchorView(video_view);

        video_view.start();

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); 
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}




