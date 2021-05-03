package com.example.merchantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class pending_orders extends Fragment {
    CardView cardView;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pending,container,false);
        Button btnorder= view.findViewById(R.id.Confirm_order);
        cardView = view.findViewById(R.id.order1);
        btnorder.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent=new Intent(getActivity(),Confirm_Order.class);
                                                    startActivity(intent);
                                                }
                                            });


         cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.fragment,new View_Order());
                 fragmentTransaction.addToBackStack(null).commit();

             }
         });


        return view;

    }

}
