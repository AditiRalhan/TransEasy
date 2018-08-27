package com.example.aditi.transeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view)
    {
        Intent i = new Intent(LoginActivity.this,Private_CompanyActivity.class);
        startActivity(i);
    }

    public void register(View view)
    {
        Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }
}
