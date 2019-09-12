package com.example.connect4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);

        img1.animate().translationYBy(1000f).setDuration(2000);

        img2.animate().translationXBy(-1000f).setDuration(2000);

    }

    public void fadeAgain(View view) {

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);

        img2.animate().alpha(0f).setDuration(2000);

        img1.animate().alpha(1f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img2 = (ImageView) findViewById(R.id.img2);

        img2.setTranslationX(1000f);
    }
}
