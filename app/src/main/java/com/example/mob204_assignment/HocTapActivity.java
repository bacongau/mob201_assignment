package com.example.mob204_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mob204_assignment.Activities.DangKyHocActivity;
import com.example.mob204_assignment.Activities.XemLichHocActivity;
import com.example.mob204_assignment.Activities.XemLichThiActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HocTapActivity extends AppCompatActivity {
    Button button_dangkyhoc, button_lichhoc, button_lichthi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_tap);

        anhxa();

        ClickButtonEvent();
    }

    private void ClickButtonEvent() {
        button_dangkyhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HocTapActivity.this, DangKyHocActivity.class));
            }
        });

        button_lichhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HocTapActivity.this, XemLichHocActivity.class));
            }
        });

        button_lichthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HocTapActivity.this, XemLichThiActivity.class));
            }
        });

    }

    private void anhxa() {
        button_dangkyhoc = findViewById(R.id.button_dangkyhoc);
        button_lichhoc = findViewById(R.id.button_xemlichhoc);
        button_lichthi = findViewById(R.id.button_xemlichthi);
    }
}