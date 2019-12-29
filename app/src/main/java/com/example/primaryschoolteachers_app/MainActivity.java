package com.example.primaryschoolteachers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class MainActivity extends AppCompatActivity {

    Pinview pvBoys1,pvGirls1 , pvBoys2 , pvGirls2 , pvBoys3 , pvGirls3 , pvBoys4 , pvGirls4 , pvBoys5 , pvGirls5 ;
    int totalBoys , totalGirls ;
    int boys1;
    Button btnDeatail ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pvBoys1 = findViewById(R.id.pvBoys1);
        pvBoys2 = findViewById(R.id.pvBoys2);
        pvBoys3 = findViewById(R.id.pvBoys3);
        pvBoys4 = findViewById(R.id.pvBoys4);
        pvBoys5 = findViewById(R.id.pvBoys5);
        pvGirls1 = findViewById(R.id.pvGirls1);
        pvGirls2 = findViewById(R.id.pvGirls2);
        pvGirls3 = findViewById(R.id.pvGirls3);
        pvGirls4 = findViewById(R.id.pvGirls4);
        pvGirls5 = findViewById(R.id.pvGirls5);
        btnDeatail = findViewById(R.id.details);
        //String gg = pvBoys1.getValue().toString();

       /* pvBoys1.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {

            }
        });*/


       // Get Value And Convert to Integer

        //boys1 = Integer.parseInt(pvBoys1.getValue());


//        int Boys2 = Integer.parseInt(pvBoys2.getValue());

//        int Boys3 = Integer.parseInt(pvBoys3.getValue());
//        int Boys4 = Integer.parseInt(pvBoys4.getValue());
//        int Boys5 = Integer.parseInt(pvBoys5.getValue());
//
//        int Girls1 = Integer.parseInt(pvGirls1.getValue());
//        int Girls2 = Integer.parseInt(pvGirls2.getValue());
//        int Girls3 = Integer.parseInt(pvGirls3.getValue());
//        int Girls4 = Integer.parseInt(pvGirls4.getValue());
//        int Girls5 = Integer.parseInt(pvGirls5.getValue());
//
//        totalBoys = (Boys1 + Boys2 + Boys3 + Boys4 + Boys5);
//        totalGirls = (Girls1 + Girls2 + Girls3 + Girls4 + Girls5);

        // Pop up total boys when button click

        btnDeatail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boys1 = Integer.parseInt(pvBoys1.getValue());
                Toast.makeText(MainActivity.this,String.valueOf(boys1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
