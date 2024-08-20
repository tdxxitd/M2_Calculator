package com.example.thirdhomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer variableA, variableB;
    private Boolean IsOperationClick;
    private String operator = "";
    private Button showResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResult = findViewById(R.id.btn_first);
        textView = findViewById(R.id.text_view);

        showResult.setOnClickListener(new View.OnClickListener() {
            String data = textView.getText().toString();
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                intent.putExtra("key1", data);
                startActivity(intent);
            }
        });
    }



    public void OnNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if(text.equals("AC")){
            textView.setText("0");
            variableA = 0;
            variableB = 0;
        } else if (textView.getText().toString().equals("0") || IsOperationClick){
            textView.setText(text);
        }else {
            textView.append(text);
        }
        IsOperationClick = false;
    }



    public void onOperatorClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        operator = ((TextView) view).getText().toString();
        variableA = Integer.valueOf(textView.getText().toString());
        IsOperationClick = true;
    }


    public void onEqualClick(View view) {
        variableB = Integer.valueOf(textView.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = variableA + variableB;
                break;
            case "-":
                result = variableA - variableB;
                break;
            case "X":
                result = variableA * variableB;
                break;
            case "/":
                if (variableB != 0) {
                    result = variableA / variableB;
                } else {
                    textView.setText("It is cannot to be");
                    return;
                }
                break;
        }
        textView.setText(String.valueOf(result));
        showResult.setVisibility(View.VISIBLE);
    }
}