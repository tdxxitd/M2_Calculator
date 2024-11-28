package com.example.thirdhomework;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity extends AppCompatActivity {

    private Spinner spinner;
    private boolean isLiked = false;
    private ImageButton imageButton;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int data = intent.getIntExtra("key1", 0);
        textView = findViewById(R.id.explore_text);
        textView.setText(String.valueOf(data));


        spinner = findViewById(R.id.dropdown);
        imageButton = findViewById(R.id.heart_btn);
        button = findViewById(R.id.btn_next);

        button.setOnClickListener(v -> finishAffinity());

        imageButton.setOnClickListener(v -> {
            if (isLiked) {
                imageButton.setImageResource(R.drawable.heart_liked);
            } else {
                imageButton.setImageResource(R.drawable.heart);
            }
            isLiked = !isLiked;
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
    }
}
