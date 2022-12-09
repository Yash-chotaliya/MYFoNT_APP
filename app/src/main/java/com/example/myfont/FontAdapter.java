package com.example.myfont;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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
        holder.copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = holder.font.getText().toString();
                ClipboardManager clipboardManager = (ClipboardManager) holder.itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData data = ClipData.newPlainText("data",s);
                clipboardManager.setPrimaryClip(data);

                Toast.makeText(context, "copied text", Toast.LENGTH_SHORT).show();
            }
        });
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
