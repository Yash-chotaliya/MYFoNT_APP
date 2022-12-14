package com.example.myfont;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FontAdapter.ViewHolder holder, int position) {
        Typeface[] arr = {Typeface.createFromAsset(context.getAssets(), "Fonts/3dlet.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/3Dumb.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/ahundredmiles.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/akchyar_unicode_bold.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/ampikunanti.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Ananda_1_Md.TTF"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/arachnid.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Archipelago.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Astalamet.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Autobahn.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/BalaCynwyd.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/BallTack.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Barbatrick.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Baubau.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Bauchaomaicha.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Billionaire.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Blockbuster.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Castle.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Caddy.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Cenobyte.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Chunkfive.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Courgette.ttf"),
                Typeface.createFromAsset(context.getAssets(), "Fonts/Datacut.ttf")};
        holder.font.setTypeface(arr[position]);
        holder.font.setText(s);

        holder.copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = holder.font.getText().toString();
                ClipboardManager clipboardManager = (ClipboardManager) holder.itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData data = ClipData.newPlainText("data",s1);
                clipboardManager.setPrimaryClip(data);

                Toast.makeText(context, "copied text", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 23;
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
