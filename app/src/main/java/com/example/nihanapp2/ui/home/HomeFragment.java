package com.example.nihanapp2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.nihanapp2.R;
import com.example.nihanapp2.ui.dementia.DementiaFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);


        // Open Dementia fragment (pressed "Dementia" card view)
        CardView cardView = root.findViewById(R.id.cardView_dementia);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Pressed on dementia...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_dementia);
            }
        });

        // Open Dental fragment (pressed "Dementia" card view)
        CardView cardView2 = root.findViewById(R.id.cardView_dental);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Pressed on dementia...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_slideshow);
            }
        });

        // Open Home Health fragment (pressed "Dementia" card view)
        CardView cardView3 = root.findViewById(R.id.cardView_homehealth);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Pressed on dementia...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Navigation.findNavController(root).navigate(R.id.action_nav_home_to_nav_tools);
            }
        });

        /*
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
         */
        return root;
    }
}