package com.example.android_samples;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView TxtCodPerson, TxtNamePerson;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        TxtCodPerson = itemView.findViewById(R.id.txt_cod_person);
        TxtNamePerson = itemView.findViewById(R.id.txt_name_person);
    }
}
