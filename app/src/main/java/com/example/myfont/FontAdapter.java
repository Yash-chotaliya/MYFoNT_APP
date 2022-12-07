package com.example.myfont;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FontAdapter extends RecyclerView.Adapter<FontAdapter.ViewHolder> {

    Context context;
    String s;

    public FontAdapter(Context context, String s) {
        this.context = context;
        this.s = s;
    }

    @NonNull
    @Override
    public FontAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fontlay,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FontAdapter.ViewHolder holder, int position) {
        holder.font.setText(s);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView copybtn;
        TextView font;
        public ViewHolder(@NonNull View view) {
            super(view);
            copybtn = view.findViewById(R.id.copybtn);
            font = view.findViewById(R.id.font);
        }
    }
}
