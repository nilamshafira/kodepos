package com.example.kodepos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void info(View view) {
        Intent info = new Intent(MainActivity.this,info.class);
        startActivity(info);
    }

    public void katalog(View view) {
        Intent katalog = new Intent(MainActivity.this,katalog.class);
        startActivity(katalog);
    }

    public void order(View view) {
        Intent order = new Intent(MainActivity.this,Order.class);
        startActivity(order);
    }

    public void api(View view) {
        Intent api = new Intent(MainActivity.this,api.class);
        startActivity(api);
    }
}
