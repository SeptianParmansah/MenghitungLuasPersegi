package com.example.septian.menghitungluaspersegi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinenerPilihan;
    String [] pilihanHitung= {"Volume Persegi", "Keliling Persegi", "Luas Permukaan Persegi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSisi = findViewById(R.id.ed_sisi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        spinenerPilihan = findViewById(R.id.spinner_pilihan);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinenerPilihan.getSelectedItem().toString().equals(pilihanHitung[0])) {
                    //Rumus Volume Persegi
                    rumusVolumePersegi();
                } else if (spinenerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])) {
                    //Rumus Keliling Persegi
                    RumusKelilingPersegi();
                } else if (spinenerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])) {
                    //Rumus Luas Permukaan Persegi
                    RumusLuasPermukaanPersegi();
                }
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spinenerPilihan.setAdapter(adapter);
    }

    private void RumusLuasPermukaanPersegi() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = 12 * sisi;
        tvHasil.setText(hasil.toString());
    }

    private void RumusKelilingPersegi() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = 6 * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }

    private void rumusVolumePersegi() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tvHasil.setText(hasil.toString());
    }
}
