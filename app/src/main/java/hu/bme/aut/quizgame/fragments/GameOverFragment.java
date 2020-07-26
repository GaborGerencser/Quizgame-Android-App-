package hu.bme.aut.quizgame.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import hu.bme.aut.quizgame.GameplayActivity;
import hu.bme.aut.quizgame.MainActivity;
import hu.bme.aut.quizgame.R;
import hu.bme.aut.quizgame.ScoreboardActivity;

public class GameOverFragment extends DialogFragment {

    public static final String TAG = "GameOverDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.new_score_item)
                .setView(getContentView())
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent= new Intent(getContext(),ScoreboardActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent= new Intent(getContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .create();
    }

    private View getContentView() {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_game_over, null);
        return contentView;
    }


}
