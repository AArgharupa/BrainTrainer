package com.example.bhaskaradhikary.braintrainer;


import android.content.Intent;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int location;
    TextView result;
    int score = 0;
    int numberOfQuestions = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;
    ConstraintLayout gameLayout2;
    Button helpButton;
    TextView help;

    public void help (View view){
        Intent intent = new Intent(getApplicationContext(),HelpActivity.class);
        startActivity(intent);
    }

    public  void  playAgain (View view){
        gameLayout2.setVisibility(View.VISIBLE);
        result.setText("");
        score=0;
        numberOfQuestions = 0;
        timerTextView.setText("30");
        scoreTextView.setText(Integer.toString(score)+ "/" + Integer.toString(numberOfQuestions));
        newQuestion();
        playAgainButton.setVisibility(View.INVISIBLE);
        new CountDownTimer(31000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
                gameLayout2.setVisibility(View.INVISIBLE);
            }
        }.start();

    }
    public  void  chooseAnswer (View view){
        Log.i("Tag" ,view.getTag().toString());
        result.setVisibility(View.VISIBLE);
        if ( Integer.toString(location).equals(view.getTag())){
           result.setText("Correct!");
           score ++;
        }else {

           result.setText("Wrong!");
           result.setTextColor(0xffff0000);

        }
        numberOfQuestions ++;
        scoreTextView.setText(Integer.toString(score)+ "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }

    Button goButton;
    ArrayList<Integer> answer = new ArrayList<Integer>();

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        helpButton.setVisibility(View.INVISIBLE);
        help.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        gameLayout2.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timerTextView));
    }
public void newQuestion () {
    Random rand = new Random();
    int a = rand.nextInt(51);
    int b = rand.nextInt(51);
    sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));
    location = rand.nextInt(4);

    answer.clear();
    for (int i = 0; i < 4; i++) {
        if (i == location) {
            answer.add(a + b);

        } else {
            int wrong = rand.nextInt(105);

            while (wrong == a + b) {
                wrong = rand.nextInt(105);
            }
            answer.add(wrong);
        }
    }
    button0.setText(Integer.toString(answer.get(0)));
    button1.setText(Integer.toString(answer.get(1)));
    button2.setText(Integer.toString(answer.get(2)));
    button3.setText(Integer.toString(answer.get(3)));
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        gameLayout = findViewById(R.id.gameLayOut);
        gameLayout2 = findViewById(R.id.gameLayout2);
        goButton = findViewById(R.id.Gobutton);
        helpButton = findViewById(R.id.helpButton);
        help = findViewById(R.id.helpTextView);
        goButton.setVisibility(View.VISIBLE);
        help.setVisibility(View.VISIBLE);
       helpButton.setVisibility(View.VISIBLE);
        result = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playTheGameButton);
        gameLayout.setVisibility(View.INVISIBLE);
        gameLayout2.setVisibility(View.INVISIBLE);
    }

}

