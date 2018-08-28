package com.example.aditi.transeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Company_PreviousBookingsActivity extends AppCompatActivity {

    ArrayList personNames = new ArrayList<>(Arrays.asList("Person1","Person2","Person3","Person4","Person5","Person6"));
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__previous_bookings);
    }
}
