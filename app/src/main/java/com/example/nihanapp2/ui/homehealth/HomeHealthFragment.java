package com.example.nihanapp2.ui.homehealth;

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

public class HomeHealthFragment extends Fragment {

    private HomeHealthViewModel homeHealthViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeHealthViewModel =
                ViewModelProviders.of(this).get(HomeHealthViewModel.class);
        View root = inflater.inflate(R.layout.fragment_homehealth, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        homeHealthViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Open Nutrition fragment (pressed "Nutrition" card view)
        CardView cardViewNutrition = root.findViewById(R.id.cardView_homehealth_nutrition);
        cardViewNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Pressed on dementia...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Navigation.findNavController(root).navigate(R.id.action_nav_homehealth_to_nutritionFragment);
            }
        });


        // Open Exercise fragment (pressed "Exercise" card view)
        CardView cardViewExercise = root.findViewById(R.id.cardView_homehealth_exercise);
        cardViewExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Pressed on dementia...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Navigation.findNavController(root).navigate(R.id.action_nav_homehealth_to_exerciseFragment);
            }
        });


        return root;
    }
}