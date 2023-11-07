package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Create","Estoy en onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start","Estoy en onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Resume","Estoy en onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause","Estoy en onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop","Estoy en onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy","Estoy en onDestroy");

    }
}