package com.example.bios;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        audioMediaPlayer();

    }
    public void audioMediaPlayer(){
        MediaPlayer mp =MediaPlayer.create(this, R.raw.bienvenido_a_gaia);
        mp.start();
    }
}