package com.mdp.formulirrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private TextView tvnpm, tvnama, tvjk, tvprodi;
    private Button btnkonfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvnpm = findViewById(R.id.tv_npm);
        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvprodi = findViewById(R.id.tv_prodi);
        btnkonfirm = findViewById(R.id.btn_konfirm);

        btnkonfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ResultActivity.this);
                dialog.setTitle("Konfirmasi");
                dialog.setMessage("Apakah Data Anda Sudah Benar ?");

                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ResultActivity.this, "Terima Kasih , Pendaftaran Anda Berhasil.", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });

                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }

                });

                dialog.show();
            }
        });

        Intent intent = getIntent();
        tvnpm.setText(intent.getStringExtra("varNPM"));
        tvnama.setText(intent.getStringExtra("varNama"));
        tvprodi.setText(intent.getStringExtra("varProdi"));
        tvjk.setText(intent.getStringExtra("varJK"));

    }
}