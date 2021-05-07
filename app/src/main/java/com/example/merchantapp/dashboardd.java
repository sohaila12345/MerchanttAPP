package com.example.merchantapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

import java.util.ArrayList;
import java.util.List;

public class dashboardd extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView cardView;
    Menu menu;
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    RelativeLayout relativeLayout;
    ActionBarDrawerToggle toggle;
    ImageView conatct_us, whatsapp, phone;
    TextView textView;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardd);
        PieChartView pieChartView = findViewById(R.id.chart);
        cardView1 = findViewById(R.id.incoming_orders);
        cardView2= findViewById(R.id.active_orders);
        cardView3 = findViewById(R.id.delivered_orders);
        relativeLayout = findViewById(R.id.container);
        conatct_us = findViewById(R.id.contact_us);
        whatsapp = findViewById(R.id.whatsapp);
        phone = findViewById(R.id.phone);

        conatct_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if (whatsapp.getVisibility()==View.VISIBLE)
{

    whatsapp.setVisibility(View.INVISIBLE);
    phone.setVisibility(View.INVISIBLE);
}else{
                whatsapp.setVisibility(View.VISIBLE);
                phone.setVisibility(View.VISIBLE);
                phone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:03035777702"));
                        startActivity(intent);
                    }
                });
                whatsapp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String headerReceiver = "";// Replace with your message.
                            String bodyMessageFormal = "";// Replace with your message.
                            String whatsappContain = headerReceiver + bodyMessageFormal;
                            String trimToNumner = "+923035777702"; //10 digit number
                            Intent intent = new Intent ( Intent.ACTION_VIEW );
                            intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
                            startActivity ( intent );
                        } catch (Exception e) {
                            e.printStackTrace ();
                        }
                    }
                });

            }}

        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment,new Delivered_Orders(),null);
                fragmentTransaction.commit();

            }

        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment,new Active_Orders(),null);
                fragmentTransaction.commit();
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment,new pending_orders(),null);
                fragmentTransaction.commit();
            }
        });

        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(4, Color.rgb(255,94,0)));
        pieData.add(new SliceValue(10, Color.rgb(255,230,0)));
        pieData.add(new SliceValue(26, Color.rgb(52,209,91)));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("40").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartData.setHasCenterCircle(true);
        pieChartView.setPieChartData(pieChartData);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_bar);
        toolbar=findViewById(R.id.actionbar);
        cardView=findViewById(R.id.cardview1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1= new Intent(dashboardd.this,MainActivity.class);
                startActivity(it1);
            }
        });
       navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }



    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Setting()).addToBackStack(null).commit();
                break;
            case R.id.profile:
                Intent it1 = new Intent(dashboardd.this, Sign_Up.class);
                startActivity(it1);
                break;
            case R.id.nav_Dashboard:
                Intent intent = new Intent(dashboardd.this, dashboardd.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
