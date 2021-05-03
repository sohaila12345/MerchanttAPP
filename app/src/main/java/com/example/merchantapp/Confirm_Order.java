package com.example.merchantapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import java.util.Calendar;

public class Confirm_Order extends AppCompatActivity {
    private static final String TAG= "ConfirmOrder";
    private EditText datepikcker;
    private EditText timepicker;
    CardView cardView;
    private DatePickerDialog.OnDateSetListener datePickerDialog;
    private TimePickerDialog.OnTimeSetListener timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__order);
        datepikcker = findViewById(R.id.datepikcker);
        timepicker=findViewById(R.id.timepicker);
        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar caLender = Calendar.getInstance();
                int hour=caLender.get(Calendar.HOUR);
                int min=caLender.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog=new TimePickerDialog(Confirm_Order.this,android.R.style.Theme_DeviceDefault_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int min) {
                        Calendar calendar1= Calendar.getInstance();
                        calendar1.set(Calendar.HOUR,hour);
                        calendar1.set(Calendar.MINUTE,min);
                        CharSequence charSequence= DateFormat.format("hh : mm a",calendar1);
                        timepicker.setText(charSequence);


                       /* String showtime=hour + ":" + min;
                        timepicker.setText(showtime);*/

                    }
                },hour,min,true);
                timePickerDialog.show();


            }

        });







        datepikcker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                {
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog dialog = new DatePickerDialog(
                            Confirm_Order.this,
                            android.R.style.Theme_DeviceDefault_Dialog_MinWidth, datePickerDialog, year, month, day
                    );
                    //  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                }

            }
        });

        datePickerDialog=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar calendar1= Calendar.getInstance();
                calendar1.set(Calendar.YEAR,year);
                calendar1.set(Calendar.MONTH,month);
                calendar1.set(Calendar.DAY_OF_MONTH,day);
                CharSequence charSequence= DateFormat.format("EEEE dd MMM yyy",calendar1);
                datepikcker.setText(charSequence);


              /*  month= month + 1;
                Log.d(TAG,"onDateSet: mm/dd/yyy" + month + "/" + day + "/" + year);
                String date= month + "/" + day + "/" + year;
                datepikcker.setText(date); */


            }
        };
    }
}