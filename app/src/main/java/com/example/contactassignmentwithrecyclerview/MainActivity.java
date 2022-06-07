package com.example.contactassignmentwithrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.contactassignmentwithrecyclerview.Adapters.ContactAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerContact;
    private ArrayList<Contact> contactArrayList;
    private ContactAdapter contactAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private  void init()
    {
        recyclerContact=findViewById(R.id.recyclerContact);
        recyclerContact.setLayoutManager(
                new LinearLayoutManager(
                        this,LinearLayoutManager.VERTICAL,false
                )
        );

        contactArrayList=new ArrayList<Contact>();
        contactAdapter=new ContactAdapter(contactArrayList);
        recyclerContact.setAdapter(contactAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId=item.getItemId();
        switch(itemId)
        {
            case R.id.menu_add:Intent intent=new Intent(MainActivity.this,AddContacts.class);
            startActivityForResult(intent,1);

        }
        return super.onOptionsItemSelected(item);
    }

      @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data != null) {
            Contact newContact = (Contact) data.getSerializableExtra("contact");
            contactArrayList.add(newContact);
            Log.e("tag","error");
         //ContactAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}