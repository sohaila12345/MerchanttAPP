package com.example.merchantapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Setting extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting, container, false);
        Button update= view.findViewById(R.id.update_address);
        Button add_user= view.findViewById(R.id.add_user);
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_user =new Intent(getActivity(),New_User.class);
                startActivity(new_user);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent update_address =new Intent(getActivity(),Update_Adress.class);
                startActivity(update_address);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });

        return view;

    }
}