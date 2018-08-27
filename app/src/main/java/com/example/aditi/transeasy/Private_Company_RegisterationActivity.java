package com.example.aditi.transeasy;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Private_Company_RegisterationActivity extends AppCompatActivity {

    ImageView mImageView;
    private static final int PICK_IMAGE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private__company__registeration);
        mImageView = (ImageView)findViewById(R.id.imgView_companyLogo);
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
}
