package com.example.nihanapp2.ui.dental;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.nihanapp2.R;

public class DentalFragment extends Fragment {

    private DentalViewModel dentalViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dentalViewModel =
                ViewModelProviders.of(this).get(DentalViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dental, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        dentalViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Open Denture Care fragment (pressed "Denture care" card view)
        CardView cardViewDentureCare = root.findViewById(R.id.cardView_dental_dentureCare);
        cardViewDentureCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Pressed on dementia...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Navigation.findNavController(root).navigate(R.id.action_nav_dental_to_dentureFragment);
            }
        });

        return root;
    }
}