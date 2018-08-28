package com.example.aditi.transeasy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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

public class Port_Officer_RegisterActivity extends AppCompatActivity {

     ImageView mImageView;
     public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
     private static final int PICK_IMAGE = 100;
     Uri img;
     String  email,password,user_type,name,address,phone_number;
     EditText etName,etAddress,etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port__officer__register);
        mImageView = (ImageView) findViewById(R.id.imgView_portOfficer);
        etName = (EditText)findViewById(R.id.Pofficer_name);
        etAddress=(EditText)findViewById(R.id.Pofficer_address);
        etPhone=(EditText)findViewById(R.id.Pofficer_phoneNumber);
        Bundle extras=getIntent().getExtras();
        email=extras.getString("email");
        password=extras.getString("password");
        user_type=extras.getString("user_type");
    }

    public void selectImage(View view)
    {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK)
        {
            img = data.getData();
            mImageView.setImageURI(img);
        }
    }

    public void signup(View view)
    {
        name= etName.getText().toString().trim();
        address=etAddress.getText().toString().trim();
        phone_number=etPhone.getText().toString().trim();


        if (name.isEmpty())
        {
            etName.setError("Name Required");
            etName.requestFocus();
            return;
        }
         if(address.isEmpty())
         {
             etAddress.setError("Address Required");
             etAddress.requestFocus();
             return;
         }

        if (phone_number.isEmpty())
        {
            etPhone.setError("Phone Number Required");
            etPhone.requestFocus();
            return;
        }
        if (phone_number.length() != 10)
        {
            etPhone.setError("Enter a valid number");
            etPhone.requestFocus();
            return;
        }

        OkHttpClient client = new OkHttpClient();

        String url = "https://transeasy.herokuapp.com/api/register/port_officer";

        JSONObject json_obj = new JSONObject();
        try{
            json_obj.put("name",name);
            json_obj.put("email",email);
            json_obj.put("phone_no",phone_number);
            json_obj.put("password",password);
            json_obj.put("officer_img",img.toString());
            json_obj.put("port_location",address);

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

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    // Success Sign Up
                    final String myResponse = response.body().string();
                    if(myResponse.equals("{\"result\":\"true\",\"status\":\"1 row inserted\"}"))
                    {
                        Intent i = new Intent(Port_Officer_RegisterActivity.this,PortOfficerActivity.class);
                        startActivity(i);
                    }
                }
                else
                {
                    // Failure Sign up
                }
            }
        });





    }
}