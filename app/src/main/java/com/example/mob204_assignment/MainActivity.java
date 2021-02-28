package com.example.mob204_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mob204_assignment.Activities.BanDoActivity;
import com.example.mob204_assignment.Activities.MangXaHoiActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout hoctap,mangXH,tintuc,bando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();

        ClickItemEvents();
    }

    private void ClickItemEvents() {
        hoctap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HocTapActivity.class);
                startActivity(intent);
            }
        });

        mangXH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MangXaHoiActivity.class);
                startActivity(intent);
            }
        });

        tintuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "tin tuc activity", Toast.LENGTH_SHORT).show();
            }
        });

        bando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BanDoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        hoctap = findViewById(R.id.menu_hoctap);
        mangXH = findViewById(R.id.menu_mangxahoi);
        tintuc = findViewById(R.id.menu_tintuc);
        bando = findViewById(R.id.menu_bando);
    }
}