package com.example.merchantapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Delivered_Orders extends Fragment
{

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Delivered Orders");
        View view=inflater.inflate(R.layout.delivered_orders,container,false);
        CardView cardView = view.findViewById(R.id.delivered_orders);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new Delivered_OrderView());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
        return view;

    }






}
