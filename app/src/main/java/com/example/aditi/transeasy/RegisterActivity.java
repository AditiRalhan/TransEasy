package com.example.aditi.transeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity  {
    String email,password,re_password,user_type;
   EditText editTextEmail,editTextPassword,editTextRePassword;
   Spinner sp1;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail=(EditText)findViewById(R.id.R_email);
        editTextPassword=(EditText)findViewById(R.id.R_password);
        editTextRePassword=(EditText)findViewById(R.id.R_repassword);
        sp1= (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.user,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
    }
    public void back_to_login(View view)
    {
        Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(i);
    }

    public void save(View view)
    {

        text=sp1.getSelectedItem().toString();
        email = editTextEmail.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        re_password = editTextRePassword.getText().toString().trim();
        if (email.isEmpty())
        {
            editTextEmail.setError("Email Required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Enter a valid Email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            editTextPassword.setError("Password Required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6)
        {
            editTextPassword.setError("Enter Atleast 6 characters");
            editTextPassword.requestFocus();
            return;
        }

        if (re_password.isEmpty())
        {
            editTextRePassword.setError("Password Required");
            editTextRePassword.requestFocus();
            return;
        }

        if (re_password.length() < 6)
        {
            editTextRePassword.setError("Enter Atleast 6 characters");
            editTextRePassword.requestFocus();
            return;
        }

        if(!password.equals(re_password))
        {
            editTextRePassword.setError("Password doesn't Match");
            editTextRePassword.requestFocus();
            return;
        }



     if(text.equals("Port Officer"))
        {
            Intent i = new Intent(RegisterActivity.this,Port_Officer_RegisterActivity.class);
            i.putExtra("email",email);
            i.putExtra("password",password);
            i.putExtra("user_type",text);
            startActivity(i);
        }
        else if(text.equals("Private Company"))
        {
            Intent i = new Intent(RegisterActivity.this,Private_Company_RegisterationActivity.class);
            i.putExtra("email",email);
            i.putExtra("password",password);
            i.putExtra("user_type",text);
            startActivity(i);
        }
        else if(text.equals("Railway Officer"))
        {
            Intent i = new Intent(RegisterActivity.this,RailOfficer_RegisterActivity.class);
            i.putExtra("email",email);
            i.putExtra("password",password);
            i.putExtra("user_type",text);
            startActivity(i);
        }
        else if(text.equals("Customer"))
        {
            Intent i = new Intent(RegisterActivity.this,Consumer_RegisterActivity.class);
            i.putExtra("email",email);
            i.putExtra("password",password);
            i.putExtra("user_type",text);
            startActivity(i);
        }

    }

}
