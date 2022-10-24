package com.mdp.formulirrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText etnpm, etnama;
    private RadioGroup rgjk;
    private RadioButton rbjk;
    private Spinner spprodi;
    private Button btndaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnpm = findViewById(R.id.et_npm);
        etnama = findViewById(R.id.et_nama);
        rgjk = findViewById(R.id.rg_jk);
        spprodi = findViewById(R.id.sp_prodi);
        btndaftar = findViewById(R.id.btn_daftar);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String npm, nama, jk, prodi;
                int selectedID;

                npm = etnpm.getText().toString();
                nama = etnama.getText().toString();
                prodi = spprodi.getSelectedItem().toString();
                selectedID = rgjk.getCheckedRadioButtonId();
                rbjk = findViewById(selectedID);
                jk = rbjk.getText().toString();

                if (npm.trim().equals("")) {
                    etnpm.setError("NPM TIDAK BOLEH KOSONG");
                    return;
                }
                if (nama.trim().equals("")) {
                    etnama.setError("NAMA TIDAK BOLEH KOSONG");
                    return;
                }

                Intent intent = new Intent
                        (MainActivity.this, ResultActivity.class);
                intent.putExtra("varNPM", npm);
                intent.putExtra("varNama", nama);
                intent.putExtra("varJK", jk);
                intent.putExtra("varProdi", prodi);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        etnama.setText("");
        etnpm.setText("");
        rgjk.check(R.id.rb_laki);
        spprodi.setSelection(0);
    }

}
