package com.example.aditi.transeasy;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Private_Company_RegisterationActivity extends AppCompatActivity {

    ImageView mImageView;
    private static final int PICK_IMAGE=100;
    String name,address,phone_number;
    EditText etName,etAddress,etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private__company__registeration);
        mImageView = (ImageView)findViewById(R.id.imgView_companyLogo);
        etName = (EditText)findViewById(R.id.PC_name);
        etAddress=(EditText)findViewById(R.id.PC_address);
        etPhone=(EditText)findViewById(R.id.PC_phone);

    }

    public void selectLogo(View view)
    {
        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK)
        {
            Uri photo = data.getData();
            mImageView.setImageURI(photo);
        }

    }

    public void SignUp(View view)
    {
        name= etName.getText().toString().trim();
        address=etAddress.getText().toString().trim();
        phone_number=etPhone.getText().toString().trim();

        if (name.isEmpty()) {
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
    }
}
