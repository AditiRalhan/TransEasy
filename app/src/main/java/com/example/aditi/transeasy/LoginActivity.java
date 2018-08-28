package com.example.aditi.transeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity
{
    String email,password;
    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
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


        OkHttpClient client = new OkHttpClient();

        String url = "https://transeasy.herokuapp.com/api/login";

        final JSONObject json_obj = new JSONObject();
        try{
            json_obj.put("email",email);
            json_obj.put("password",password);
        } catch (JSONException e){
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(JSON,json_obj.toString());

        Request request = new Request.Builder().header("Content-Type", "application/json").url(url).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            Intent i = new Intent(LoginActivity.this,Private_CompanyActivity.class);
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    final String myResponse = response.body().string();

                    try {
                        JSONObject jsonObject = new JSONObject(myResponse);
                            JSONObject object = jsonObject.getJSONObject("user");

                        String r = jsonObject.getString("result");

                        if(r.equals("true")) {
                            String u = jsonObject.getString("user_type");

                            if (u.equals("1")) {
                                Intent i = new Intent(LoginActivity.this, Private_CompanyActivity.class);
                                String l = object.getString("logo");
                                String na = object.getString("company_name");
                                i.putExtra("logo",l);
                                i.putExtra("name",na);
                                startActivity(i);
                            }
                            else if (u.equals("2"))
                            {
                                Intent i = new Intent(LoginActivity.this, ConsumerActivity.class);
                                String l = object.getString("customer_img");
                                String na = object.getString("name");
                                i.putExtra("logo",l);
                                i.putExtra("name",na);
                                startActivity(i);
                            }
                            else if (u.equals("3"))
                            {
                                Intent i = new Intent(LoginActivity.this, PortOfficerActivity.class);
                                String l = object.getString("officer_img");
                                String na = object.getString("name");
                                i.putExtra("logo",l);
                                i.putExtra("name",na);
                                startActivity(i);
                            }
                            else if (u.equals("4"))
                            {

                                Intent i = new Intent(LoginActivity.this, RailOfficerActivity.class);
                                String l = object.getString("img");
                                String na = object.getString("name");
                                i.putExtra("logo",l);
                                i.putExtra("name",na);
                                startActivity(i);
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }

                   // Toast.makeText(LoginActivity.this,"hello",Toast.LENGTH_SHORT).show();
                }
                else{
                    final String myResponse = "Invalid Credentials";
                 //   Toast.makeText(LoginActivity.this,"foff",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void register(View view)
    {
        Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }
}
