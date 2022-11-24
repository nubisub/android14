package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMahasiswa extends
        AppCompatActivity {

    private EditText nimEdt, namaEdt, kelasEdt, nohpEdt;
    private Button updateMahasiswaBtn,
            deleteMahasiswaBtn;
    private DBHandler dbHandler;
    String nim, nama, kelas, nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mahasiswa);

        nimEdt = findViewById(R.id.nimEdtEditText);
        namaEdt = findViewById(R.id.namaEdtEditText);
        kelasEdt = findViewById(R.id.kelasEdtEditText);
        nohpEdt = findViewById(R.id.nohpEdtEditText);
        updateMahasiswaBtn = findViewById(R.id.updateButton);
        deleteMahasiswaBtn = findViewById(R.id.deleteButton);

        dbHandler = new DBHandler(UpdateMahasiswa.this);

        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kelas = getIntent().getStringExtra("kelas");
        nohp = getIntent().getStringExtra("nohp");

        nimEdt.setText(nim);
        namaEdt.setText(nama);
        kelasEdt.setText(kelas);
        nohpEdt.setText(nohp);
        updateMahasiswaBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  dbHandler.updateMahasiswa(nim,
                          nimEdt.getText().toString(),
                          namaEdt.getText().toString(),
                          kelasEdt.getText().toString(),
                          nohpEdt.getText().toString());

                  Toast.makeText(UpdateMahasiswa.this, "Mahasiswa telah di-Update..", Toast.LENGTH_SHORT).show();

                  Intent i = new Intent(UpdateMahasiswa.this, MainActivity.class);
                  startActivity(i);
              }
          });

        deleteMahasiswaBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  dbHandler.deleteMahasiswa(nim);
                  Toast.makeText(UpdateMahasiswa.this, "Mahasiswa telah di-Delete..", Toast.LENGTH_SHORT).show();
                  Intent i = new Intent(UpdateMahasiswa.this, MainActivity.class);
                  startActivity(i);
              }
          });
    }
}