package com.example.nihanapp2.ui.dementia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.nihanapp2.DementiaPDFActivity;
import com.example.nihanapp2.R;
import com.google.android.material.snackbar.Snackbar;

public class DementiaFragment extends Fragment {

    private DementiaViewModel dementiaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dementiaViewModel =
                ViewModelProviders.of(this).get(DementiaViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dementia, container, false);
        final TextView textView = root.findViewById(R.id.text_dementia);
        dementiaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Open PDF activity (pressed PDF card view)
        CardView cardViewPDF = root.findViewById(R.id.dementia_pdf);
        cardViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Opening PDF...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                Intent intent = new Intent(view.getContext(), DementiaPDFActivity.class);
//                view.getContext().startActivity(intent);
                Navigation.findNavController(root).navigate(R.id.action_nav_dementia_to_dementiaPDFFragment);
            }
        });


        return root;
    }

}