package com.example.aditi.transeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void back_to_login(View view)
    {
        Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(i);
    }

    public void save(View view)
    {
        Intent i = new Intent(RegisterActivity.this,Private_Company_RegisterationActivity.class);
        startActivity(i);
    }
}
