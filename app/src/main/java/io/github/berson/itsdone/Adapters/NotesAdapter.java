package io.github.berson.itsdone.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import io.github.berson.itsdone.Models.Notes.Nota;
import io.github.berson.itsdone.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private ArrayList<Nota> notes;
    private Context mContext;

    public NotesAdapter(Context mContext, ArrayList<Nota> notes) {
        this.mContext = mContext;
        this.notes = notes;
        Log.e("notes", notes.toString());
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textTv.setText(notes.get(position).getText());
        holder.titleTv.setText(notes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, textTv;
        CardView lm;

        public ViewHolder(View itemView) {
            super(itemView);
            lm = itemView.findViewById(R.id.cardNote);
            titleTv = itemView.findViewById(R.id.titleTv);
            textTv = itemView.findViewById(R.id.textTv);
        }
    }

}
