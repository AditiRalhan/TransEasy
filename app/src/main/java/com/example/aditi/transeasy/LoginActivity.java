package com.example.aditi.transeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{
    String email,password;
    EditText etemail,etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etemail=(EditText)findViewById(R.id.L_email);
        etpassword=(EditText)findViewById(R.id.L_Password);
    }
    public void login(View view)
    {
        email = etemail.getText().toString().trim();
        password = etpassword.getText().toString().trim();
        if (email.isEmpty()) {
            etemail.setError("Email Required");
            etemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etemail.setError("Enter a valid Email");
            etemail.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            etpassword.setError("Password Required");
            etpassword.requestFocus();
            return;
        }

        if (password.length() < 6)
        {
            etpassword.setError("Enter Atleast 6 characters");
            etpassword.requestFocus();
            return;
        }
        Intent i = new Intent(LoginActivity.this,Private_CompanyActivity.class);
        startActivity(i);
    }

    public void register(View view)
    {
        Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }
}
