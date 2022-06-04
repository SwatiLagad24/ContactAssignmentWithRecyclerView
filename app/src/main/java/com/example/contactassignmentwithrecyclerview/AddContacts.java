package com.example.contactassignmentwithrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddContacts extends AppCompatActivity {

    private ImageView imgContact;
    private EditText edtName,edtPhonNumber,edtEmailId;
    private Button btnSave;
    private int contactImageId=R.drawable.ic_baseline_image_search_24;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_layout);
        init();
        Listeners();


    }
    private void init()
    {
        imgContact=findViewById(R.id.imgSelect);
        edtName=findViewById(R.id.edtName);
        edtPhonNumber=findViewById(R.id.edtPhone);
        edtEmailId=findViewById(R.id.edtEmail);
        btnSave=findViewById(R.id.btnSave);

    }
    private void Listeners()
    {


        imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddContacts.this,Imageselctor.class);
                startActivityForResult(intent,1);
            }
        });



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Contact getContact=new Contact(
                    contactImageId,
                    edtName.getText().toString(),
                    edtEmailId.getText().toString(),
                    edtPhonNumber.getText().toString()

            );
            Intent resultIntent=new Intent();

            resultIntent.putExtra("contact",getContact);

            setResult(1,resultIntent);
            finish();
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            contactImageId = data.getIntExtra("image_id", -1);
            imgContact.setImageResource(contactImageId);
        }
    }
}
