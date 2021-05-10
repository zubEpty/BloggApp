package com.example.blogg;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name;
    TextView prof;
    TextView desc;
    String name_txt;
    String profession;
    String desc_text;
    String image_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.cover);
        name = findViewById(R.id.name_txt);
        prof = findViewById(R.id.prof);
        desc = findViewById(R.id.descrip);
        name_txt = getIntent().getStringExtra("name");
        profession = getIntent().getStringExtra("profession");
        image_content = getIntent().getStringExtra("avatar");
        desc_text = getIntent().getStringExtra("description");
        Glide.with(this).load(image_content).into(imageView);
        name.setText(name_txt);
         prof.setText(profession);
         desc.setText(desc_text);
        //imageView.setImageResource(Integer.parseInt(image_content));
    }
}
