package com.example.bankaks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class Option3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText etaemail, etaphone, etaname;
    Button btbut;

    AwesomeValidation awesomeValidation;

    String[] MM = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String Mm;
    Button GOTO;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        etaemail = findViewById(R.id.eta_email);
        etaphone = findViewById(R.id.eta_phone);
        etaname = findViewById(R.id.eta_name);
        btbut = findViewById(R.id.bt_but);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.eta_email,Patterns.EMAIL_ADDRESS,R.string.notvalid_emai);
        awesomeValidation.addValidation(this,R.id.eta_phone,"[5-9]{1}[0-9]{9}$",R.string.notvalid_phone);
        awesomeValidation.addValidation(this,R.id.eta_name, RegexTemplate.NOT_EMPTY,R.string.notvalid_name);

        btbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate())
                    Toast.makeText(Option3.this, "Successfully Processed", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(Option3.this, "PLEASE FILL IN ALL THE REQUIRED DETAILS TO PROCESS", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(Option3.this, android.R.layout.simple_spinner_item, MM);

        spin.setAdapter(aa);

        //Adding setOnItemSelectedListener method on spinner.
//        month.setOnItemSelectedListener(new OnItemSelectedListener() {

 //           @Override
 //           public void onItemSelected(AdapterView<?> parent, View view,
   //                                    int position, long id) {

  //              SpinnerValue = (String) month.getSelectedItem();
            }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    //           @Override
 //           public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
    //    });

  //  }

//}