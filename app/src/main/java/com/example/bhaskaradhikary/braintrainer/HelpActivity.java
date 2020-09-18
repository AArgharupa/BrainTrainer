package com.example.bhaskaradhikary.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}