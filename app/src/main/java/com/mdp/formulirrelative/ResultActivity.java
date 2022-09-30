package com.mdp.formulirrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvnpm, tvnama, tvjk, tvprodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvnpm = findViewById(R.id.tv_npm);
        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvprodi = findViewById(R.id.tv_prodi);

        Intent intent = getIntent();
        tvnpm.setText(intent.getStringExtra("varNPM"));
        tvnama.setText(intent.getStringExtra("varNama"));
        tvprodi.setText(intent.getStringExtra("varProdi"));
        tvjk.setText(intent.getStringExtra("varJK"));

    }
}