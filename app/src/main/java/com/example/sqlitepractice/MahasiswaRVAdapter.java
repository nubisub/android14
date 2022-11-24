package com.example.sqlitepractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaRVAdapter extends
        RecyclerView.Adapter<MahasiswaRVAdapter.ViewHolder> {

    private ArrayList<MahasiswaModal>
            mahasiswaModalArrayList;
    private Context context;

    public MahasiswaRVAdapter(ArrayList<MahasiswaModal>
                                      mahasiswaModalArrayList, Context context) {
        this.mahasiswaModalArrayList =
                mahasiswaModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull
                                                 ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .mahasiswa_rv_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder
                                         holder, int position) {
        MahasiswaModal modal =
                mahasiswaModalArrayList.get(position);
        holder.nimTV.setText(modal.getNim());
        holder.namaTV.setText(modal.getNama());
        holder.kelasTV.setText(modal.getKelas());
        holder.nohpTV.setText(modal.getNohp());
    }

    @Override
    public int getItemCount() {
        return mahasiswaModalArrayList.size();
    }

    public class ViewHolder extends
            RecyclerView.ViewHolder {

        private TextView nimTV, namaTV, kelasTV, nohpTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nimTV =
                    itemView.findViewById(R.id.nimTextView);
            namaTV =
                    itemView.findViewById(R.id.namaTextView);
            kelasTV =
                    itemView.findViewById(R.id.kelasTextView);
            nohpTV =
                    itemView.findViewById(R.id.nohpTextView);
        }
    }
}