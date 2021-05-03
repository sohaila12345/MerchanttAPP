package com.example.merchantapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Dialog mydialog;
      Button addproduct;
      ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addproduct = (Button)findViewById(R.id.button6);
        back= (ImageView)findViewById(R.id.imageView8);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(MainActivity.this,dashboardd.class);
                startActivity(it);
            }
        });

        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(MainActivity.this,Product.class);
                startActivity(it);
            }
        });





        mydialog =new Dialog(this);

        Spinner spinner = (Spinner) findViewById(R.id.spinner6);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("All Products");
        categories.add("Publish");
        categories.add("Un Publish");
        categories.add("Out of Stock");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }




    public void ShowPopup(View v){
        ImageView cancel;
        Button button;
        mydialog.setContentView(R.layout.activity_pop_up_window);
        cancel = (ImageView) mydialog.findViewById(R.id.imageView10);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog.dismiss();
            }
        });

        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mydialog.show();
    }
}