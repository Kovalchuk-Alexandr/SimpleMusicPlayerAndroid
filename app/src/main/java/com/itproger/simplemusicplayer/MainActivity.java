package com.itproger.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton playImageButton, stopImageButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playImageButton = findViewById(R.id.playImageButton);
        stopImageButton = findViewById(R.id.stopImageButton);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ringtone);
    }

    @SuppressLint("NonConstantResourceId")
    public void musicButtons(View view) {
        switch (view.getId()) {
            // При нажатии кнопки Play
            case R.id.playImageButton:
                if (!mediaPlayer.isPlaying()) {
                    // Если плейер не включен, запускаем
                    mediaPlayer.start();
                    //... и устанавливаем иконку - пауза
                    playImageButton.setImageResource(R.drawable.ic_pause_icon);
                } else {
                    mediaPlayer.pause();
                    playImageButton.setImageResource(R.drawable.ic_play);
                }
                break;
            case R.id.stopImageButton:
                // Если мелодия играет, будем останавливать
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    playImageButton.setImageResource(R.drawable.ic_play);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ringtone);
                }
                break;
        }

    }
}