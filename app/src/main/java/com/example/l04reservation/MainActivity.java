package com.example.l04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {


EditText Phone;
EditText Name;
EditText NoOfPpl;
RadioButton Smoking;
RadioButton Nonsmoking;
DatePicker dp;
TimePicker tp;
Button confirm;
Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editTextName);
        Phone = findViewById(R.id.editTextPhone);
        NoOfPpl = findViewById(R.id.editTextNoofPpl);
        Smoking = findViewById(R.id.rdbSmoking);
        Nonsmoking = findViewById(R.id.rdbNonsmoking);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        confirm = findViewById(R.id.buttonConfirm);
        reset = findViewById(R.id.buttonReset);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name1 = Name.getText().toString();
                String Phone1 = Phone.getText().toString();
                String NoOfPpl1 = NoOfPpl.getText().toString();
                int hr = tp.getHour();
                int min = tp.getMinute();
                int dom = dp.getDayOfMonth();
                int mon = dp.getMonth();
                int yr = dp.getYear();
                String dispmsg = "";


                if(!Name1.isEmpty() && !Phone1.isEmpty() && !NoOfPpl1.isEmpty() && Smoking.isChecked() || Nonsmoking.isChecked()){
                    dispmsg += "Name: " + Name1 + "\n" + "Phone: " + Phone1 + "\n" + "NoOfPpl: " + NoOfPpl1 + "\n" + "Your reservation has been confirmed";
                    Toast.makeText(MainActivity.this,dispmsg, Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Please field out all fields before reservation", Toast.LENGTH_SHORT).show();
                }


            }
        });





        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (hourOfDay < 8) {
                    tp.setHour(8);
                        }

                else if(hourOfDay > 20) {
                   tp.setHour(20);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Name.setText("");
                Phone.setText("");
                NoOfPpl.setText("");
                Smoking.setChecked(false);
                Nonsmoking.setChecked(false);
                tp.setHour(0);
                tp.setMinute(0);
                dp.updateDate(2020,0,1);


            }
        });

    }

    }
//}