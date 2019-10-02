package com.example.testquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView questionTV;
    private Button trueButton;
    private Button falseButton;

    private ImageButton backButton;
    private ImageButton nextButton;
    private int currentQuestionIndex;


    private Question[] questionBank = new Question[]{
        new Question(R.string.q1, true),
        new Question(R.string.q2,  true),
            new Question(R.string.q3,  false),
            new Question(R.string.q4,  false),
            new Question(R.string.q5,  true),
            new Question(R.string.q6,  true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     //   Question question = new Question(R.string.NameFirst, answerTrue true);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTV = findViewById(R.id.question_tv);

        backButton = findViewById(R.id.back_button);
        nextButton = findViewById(R.id.next_button);


        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(this);




    }


    @Override
    public void onClick(View view){
        switch(view.getId()){

            case R.id.true_button:

                checkAnswer(true);
                //Toast.makeText(MainActivity.this, "True", Toast.LENGTH_LONG).show();
                break;
            case R.id.false_button:
                checkAnswer(false);
               // Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();
                break;
            case R.id.next_button:
               // Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();

                //currentQuestionIndex;
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                //questionTV.setText(questionBank[currentQuestionIndex].getQuestionResId());
                break;

            case R.id.back_button:
                // Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();

                Log.d("Index", " "+currentQuestionIndex);
                if(currentQuestionIndex == 1){

                    Log.d("QuestionBank", ""+questionBank.length);
                    currentQuestionIndex = questionBank.length-1;
                    updateQuestion();
                }
                else {
                    //currentQuestionIndex;
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                    //questionTV.setText(questionBank[currentQuestionIndex].getQuestionResId());
                }
                break;
        }
    }

    private void checkAnswer(boolean userChoseCorrect){
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();

        int ToastMessageID =0;

        if(userChoseCorrect == answerIsTrue){
            ToastMessageID = R.string.right_answer;
        }else{
            ToastMessageID = R.string.wrong_answer;
        }
        Toast.makeText(MainActivity.this, ToastMessageID, Toast.LENGTH_LONG).show();
    }

    public void updateQuestion(){
        questionTV.setText(questionBank[currentQuestionIndex].getQuestionResId());
    }


/*
    public class Question{

        private int questionResId;
        private boolean  answerTrue;

        public Question(int questionResId, boolean answerTrue) {
            this.questionResId = questionResId;
            this.answerTrue = answerTrue;
        }

        public void setQuestionResId(int questionResId) {
            this.questionResId = questionResId;
        }

        public void setAnswerTrue(boolean answerTrue) {
            this.answerTrue = answerTrue;
        }

        public int getQuestionResId() {
            return questionResId;
        }

        public boolean isAnswerTrue() {
            return answerTrue;
        }
    }
    */

}
