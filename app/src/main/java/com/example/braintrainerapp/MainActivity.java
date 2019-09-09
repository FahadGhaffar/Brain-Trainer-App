package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    ArrayList<Integer> answer;
    Button playAgainbutton;
    int locationforanswer;
    TextView answertextView;
    TextView correcttextView;
    TextView timetextView;
    RelativeLayout relativeLayout;
    int score=0;
    int numberofQuestions=0;
    Button answerbutton0;
    Button answerbutton1;
    Button answerbutton2;
    Button answerbutton3 ;
    TextView questiontextView;


    public void playAgain(final View view){
        score=0;
        numberofQuestions=0;
        correcttextView.setText("0/0");
        answertextView.setText("");
        timetextView.setText("30s");


        playAgainbutton.setVisibility(View.INVISIBLE);
        answerbutton0.setClickable(true);
        answerbutton1.setClickable(true);
        answerbutton2.setClickable(true);
        answerbutton3.setClickable(true);
        generatedQuestion();
        new CountDownTimer(30100,1000){


            @Override
            public void onTick(long l) {
                timetextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                timetextView.setText("0s");
                answertextView.setText("Time Finish "+Integer.toString(score)+"/"+Integer.toString(numberofQuestions));
                playAgainbutton.setVisibility(View.VISIBLE);
                answerbutton0.setClickable(false);
                answerbutton1.setClickable(false);
                answerbutton2.setClickable(false);
                answerbutton3.setClickable(false);



            }
        }.start();

    }
    public void generatedQuestion(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        questiontextView.setText(String.valueOf(a) + "+"+ String.valueOf(b));
        int incorrectAnswer;

        locationforanswer=rand.nextInt(4);
        answer.clear();
        for (int i=0 ; i<4; i++ ){

            if (i==locationforanswer){

                answer.add(a+b);

            }else{
                incorrectAnswer=rand.nextInt(41);

                while (incorrectAnswer==a+b) incorrectAnswer=rand.nextInt(41);

                answer.add(incorrectAnswer);



            }



        }

        answerbutton0.setText(String.valueOf(answer.get(0)));
        answerbutton1.setText(String.valueOf(answer.get(1)));
        answerbutton2.setText(String.valueOf(answer.get(2)));
        answerbutton3.setText(String.valueOf(answer.get(3)));

    }
    public void chooseAnswer(View view){
      if (view.getTag().toString().equals(Integer.toString(locationforanswer))){

          score ++;

          answertextView.setText("correct");




      }else {

        answertextView.setText("Incorrect");
      }
        numberofQuestions ++;

      correcttextView.setText(Integer.toString(score)+"/"+Integer.toString(numberofQuestions));
        generatedQuestion();

    }
    public void Start(View view){

          goButton.setVisibility(view.INVISIBLE);
        relativeLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainbutton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=(Button) findViewById(R.id.gobutton);
        questiontextView=(TextView) findViewById(R.id.questiontextView);
        answertextView=(TextView) findViewById(R.id.answertextView);
        correcttextView=(TextView) findViewById(R.id.correcttextView);
        answer= new ArrayList<Integer>();
         answerbutton0=(Button) findViewById(R.id.answerbutton0);
         answerbutton1=(Button) findViewById(R.id.answerbutton1);
        answerbutton2=(Button) findViewById(R.id.answerbutton2);
        answerbutton3=(Button) findViewById(R.id.answerbutton3);
        timetextView=(TextView) findViewById(R.id.timetextView);
        playAgainbutton =(Button) findViewById(R.id.playAgainbutton);
        playAgainbutton.setVisibility(View.INVISIBLE);
        relativeLayout=(RelativeLayout)  findViewById(R.id.relativeLayout);





    }
}
