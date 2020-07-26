package hu.bme.aut.quizgame.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import hu.bme.aut.quizgame.R;
import hu.bme.aut.quizgame.Scores.ScoreItem;

class ScoreViewHolder extends RecyclerView.ViewHolder {

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