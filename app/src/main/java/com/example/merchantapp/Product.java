package com.example.merchantapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Product extends AppCompatActivity {
    ImageView back;
    Button addimage;
    Uri image_uri;
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        back = (ImageView) findViewById(R.id.imageView8);
        addimage = (Button) findViewById(R.id.button);
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(Product.this, MainActivity.class);
                startActivity(it1);
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.spinner7);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("    Air Conditioner");
        categories.add("    Glowing cream");
        categories.add("    Shampoo");
        categories.add("    Cooking oil");
        categories.add("    Detergent");
        categories.add("    Home Decor");
        categories.add("    Kitchen");
        categories.add("    Jewellery");
        categories.add("    Toys");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PICK_IMAGE && requestCode == RESULT_OK) {
            image_uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), image_uri);
                addimage.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
        }

    }
}










    }
}