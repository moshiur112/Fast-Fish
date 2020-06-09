package com.example.fastfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread()
        {
            @Override
            public void run(){
                try {
                    sleep(1000);
                } catch (Exception e) {

                }finally {
                    Intent authenticationIntent = new Intent(SplashActivity.this, Authentication.class);
                    startActivity(authenticationIntent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
