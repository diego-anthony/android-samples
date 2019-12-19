package com.example.android_samples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemFragmentRecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Person> mDataSet;

    public ItemFragmentRecyclerAdapter(List<Person> dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person,parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Person person = mDataSet.get(position);
        holder.TxtCodPerson.setText(person.getCode());
        holder.TxtNamePerson.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
