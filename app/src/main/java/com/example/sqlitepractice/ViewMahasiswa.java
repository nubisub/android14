package com.example.sqlitepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class ViewMahasiswa extends AppCompatActivity {

    private ArrayList<MahasiswaModal>
            mahasiswaModalArrayList;
    private DBHandler dbHandler;
    private MahasiswaRVAdapter mahasiswaRVAdapter;
    private RecyclerView mahasiswaRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mahasiswa);

        mahasiswaModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewMahasiswa.this);

        mahasiswaModalArrayList =
                dbHandler.readMahasiswa();

        mahasiswaRVAdapter = new
                MahasiswaRVAdapter(mahasiswaModalArrayList,
                ViewMahasiswa.this);
        mahasiswaRV = findViewById(R.id.idRVMahasiswa);

        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(ViewMahasiswa.this,
                RecyclerView.VERTICAL, false);
        mahasiswaRV.setLayoutManager(linearLayoutManager);

        mahasiswaRV.setAdapter(mahasiswaRVAdapter);
    }
}