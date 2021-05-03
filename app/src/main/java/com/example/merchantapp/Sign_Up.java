package com.example.merchantapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up extends AppCompatActivity {
 EditText company_name,phone_number,number,contact_name,email,area;
    public static String bearerToken;
    Button button, Area;


    private SharedPreferences sharedPreferences;
    public static final String preference_name = "userSession";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        Area = findViewById(R.id.Area);
        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1= new Intent(Sign_Up.this,Area.class);
                startActivity(it1);
            }
        });
        initWidget();
        validations();
        actionListeners();
    }

    private boolean validations() {

        String CompanyName = company_name.getText().toString();
        String phoneNumber = phone_number.getText().toString();
        String Number = number.getText().toString();
        String Name = contact_name.getText().toString();
        String Email = email.getText().toString();
        String Area = area.getText().toString();

        String CompanyValidation1 = "^[a-zA-Z]*$";
        String PhoneNumberValidation2 = "^[0-9]{1,11}$";
        String NumberValidation3 = "^[0-9]{1,11}$";
        String NameValidation4 = "^[a-zA-Z]*$";
        String  EmailValidation5 = "[a-z]*@[a-z]*.[a-z]*$";

        Pattern pattern1 = Pattern.compile(CompanyValidation1);
        Pattern pattern2 = Pattern.compile(PhoneNumberValidation2);
        Pattern pattern3 = Pattern.compile(NumberValidation3);
        Pattern pattern4 = Pattern.compile(NameValidation4);
        Pattern pattern5 = Pattern.compile(EmailValidation5);

        Matcher matcher1 = pattern1.matcher(CompanyName);
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        Matcher matcher3 = pattern3.matcher(Number);
        Matcher matcher4 = pattern4.matcher(Name);
        Matcher matcher5 = pattern5.matcher(Email);

        if(CompanyName.equals(null)||phoneNumber.equals(null)||Number.equals(null)||Name.equals(null)||Email.equals(null)||Area.equals(null)) {
            company_name.setError("Kindly fill in this field");
            return false;
        }
        else if( CompanyName.equals(null) && phoneNumber.length() != 0) {
            company_name.setError("Kindly fill in this field");
            return false;
        }
        else if( phoneNumber.equals(null) && Number.length() != 0) {
            phone_number.setError("Kindly fill in this field");
            return false;
        }
        else if( Number.equals(null) && phoneNumber.length() != 0) {
            number.setError("Kindly fill in this field");
            return false;
        }
        else if( Name.equals(null) && Number.length() != 0) {
            company_name.setError("Kindly fill in this field");
            return false;
        }
        else if( Email.equals(null) && Name.length() != 0) {
            email.setError("Kindly fill in this field");
            return false;
        }
        else if(Area.equals(null) && Email.length() != 0) {
            area.setError("Kindly fill in this field");
            return false;
        }
        else if(CompanyName.length() == 0 && phoneNumber.length() == 0)
        {
            company_name.setError("Kindly fill in this field");
            phone_number.setError("Kindly fill in this field");
            return false;
        }
        else if(CompanyName.length() == 0 && phoneNumber.length() == 0 && Number.length() == 0)
        {
            company_name.setError("Kindly fill in this field");
            phone_number.setError("Kindly fill in this field");
            number.setError("Kindly fill in this field");
            return false;
        }
        else if(Area.length() == 0 && phoneNumber.length() == 0 && Email.length() == 0)
        {
            area.setError("Kindly fill in this field");
            phone_number.setError("Kindly fill in this field");
            email.setError("Kindly fill in this field");
            return false;
        }
        else if(!matcher1.matches())
        {
            company_name.setError("Invalid input");
                    return false;
        }
        else if(!matcher2.matches())
        {
            phone_number.setError("Invalid Phone Number");
            return false;
        }
        else if(!matcher3.matches())
        {
            number.setError("Invalid Phone Number");
            return false;
        }
        else if(!matcher4.matches())
        {
          contact_name.setError("Invalid Name");
            return false;
        }
        else if(!matcher5.matches())
        {
            email.setError("Invalid Email");
            return false;
        }

        return true;
    }


    private void actionListeners() {
            company_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    validations();
                }
            });

            phone_number.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    validations();
                }
            });

        number.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                validations();
            }
        });
        contact_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                validations();
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                validations();
            }
        });
        area.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                validations();
            }
        });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String companyName = company_name.getText().toString();
                    String phoneNumber = phone_number.getText().toString();
                    String Number = number.getText().toString();
                    String Name = contact_name.getText().toString();
                    String Email = email.getText().toString();
                    String Area = area.getText().toString();
                   // authentication(companyName,phoneNumber,Number,Name,Email,Area);
                }
            });
        }


    private void initWidget() {
    button= findViewById(R.id.save);
        company_name =findViewById(R.id.company_name);
        phone_number =findViewById(R.id.phone_number);
        number =findViewById(R.id.Number);
        contact_name =findViewById(R.id.name);
        email =findViewById(R.id.email);
        area =findViewById(R.id.areaa);
    }
}