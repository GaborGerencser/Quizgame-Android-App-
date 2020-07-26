package hu.bme.aut.quizgame.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import hu.bme.aut.quizgame.R;
import hu.bme.aut.quizgame.Scores.ScoreItem;

public class NewScoreItemDialogFragment extends DialogFragment {

    public static final String TAG = "NewScoreItemDialogFragment";
    private EditText nameEditText;
    public String strtext;

    public interface NewScoreItemDialogListener {
        void onScoreItemCreated(ScoreItem newItem);
    }

    private NewScoreItemDialogListener listener;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        strtext = getArguments().getString("score");
        if (activity instanceof NewScoreItemDialogListener) {
            listener = (NewScoreItemDialogListener) activity;
        } else {
            throw new RuntimeException("Activity must implement the NewScoreItemDialogListener interface!");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.new_score_item)
                .setView(getContentView())
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       if (isValid()) {
                            listener.onScoreItemCreated(getScoreItem());
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .create();
    }


    private View getContentView() {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_new_score_item, null);
        nameEditText = contentView.findViewById(R.id.ScoreItemNameEditText);
        return contentView;
    }


    private boolean isValid() {
        return nameEditText.getText().length() > 0;
    }

    private ScoreItem getScoreItem() {
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.name = nameEditText.getText().toString();
        scoreItem.prize=strtext;
        return scoreItem;
    }


}
