package com.example.contactassignmentwithrecyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactassignmentwithrecyclerview.Adapters.ImageSelectAdapter;

public class Imageselctor extends AppCompatActivity {

    private RecyclerView recyclerImages;
    private int[] imageIds={
            R.drawable.dhoni,
            R.drawable.sachin,
            R.drawable.virat,
            R.drawable.img,
                    R.drawable.img_1,

                    R.drawable.img_2,

                    R.drawable.img_3,
                    R.drawable.img_4,
                    R.drawable.img_5,
                    R.drawable.img,

                    R.drawable.img_5,
                    R.drawable.img_3,

                    R.drawable.sachin,
                    R.drawable.virat,

                    R.drawable.dhoni,
                    R.drawable.img_3,


    };
    private ImageSelectAdapter imageSelectAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageslector_layout);
        init();

    }
    private void init()
    {
        recyclerImages=findViewById(R.id.recyclerImages);
        recyclerImages.setLayoutManager(
                new GridLayoutManager(this,
                        2)
        );

        imageSelectAdapter=new ImageSelectAdapter(imageIds);
        imageSelectAdapter.setOnImageClickListener(
                new MyImageClickListener()
        );
        recyclerImages.setAdapter(imageSelectAdapter);
    }


    class MyImageClickListener implements ImageSelectAdapter.OnImageClickListener{

        @Override
        public void onImageClickListener(int imageId,int position){
        Intent resIntent=new Intent();
        resIntent.putExtra("image_id",imageId);
        setResult(1,resIntent);
        finish();

    }
}
}