package hu.bme.aut.quizgame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.quizgame.R;
import hu.bme.aut.quizgame.Scores.ScoreItem;

public class ScoreAdapter  extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    private final List<ScoreItem> items;

    private ScoreItemClickListener listener;

    public ScoreAdapter(ScoreItemClickListener listener) {
        this.listener = listener;
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_score_list, parent, false);
        return new ScoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreAdapter.ScoreViewHolder holder, int position) {
        ScoreItem item = items.get(position);
        holder.nameTextView.setText(item.name);
        holder.prizeTextView.setText(item.prize);
        holder.iconImageView.setImageResource(getImageResource());
        holder.item = item;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface ScoreItemClickListener{
        void onItemChanged(ScoreItem item);
    }

    class ShoppingViewHolder extends RecyclerView.ViewHolder {

        ShoppingViewHolder(View itemView) {
            super(itemView);
        }
    }


    private @DrawableRes
    int getImageResource() {
        @DrawableRes int ret;
        ret = R.drawable.profile;
        return ret;
    }

    public void addItem(ScoreItem item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void update(List<ScoreItem> scoreItems) {
        items.clear();
        items.addAll(scoreItems);
        notifyDataSetChanged();
    }


    public class ScoreViewHolder extends RecyclerView.ViewHolder {

            ImageView iconImageView;
            TextView nameTextView;
            TextView prizeTextView;

            ScoreItem item;

            ScoreViewHolder(View itemView) {
                super(itemView);
                iconImageView = itemView.findViewById(R.id.ScoreItemIconImageView);
                nameTextView = itemView.findViewById(R.id.ScoreItemNameTextView);
                prizeTextView = itemView.findViewById(R.id.ScoreItemPrizeTextView);


            }
        }
    }

