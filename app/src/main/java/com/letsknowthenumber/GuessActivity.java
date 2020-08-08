package com.letsknowthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {
    private TextView txtRemaining, txtHelp;
    private EditText edtNumber;

    private int randomNumber;
    private int i = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        txtRemaining = findViewById(R.id.txw_remainingright);
        txtHelp = findViewById(R.id.txw_help);
        edtNumber = findViewById(R.id.edt_number);
        txtRemaining.setText("Remaining Right: " + i);
        Random r = new Random();
        randomNumber = r.nextInt(11);
    }


    @SuppressLint("WrongConstant")
    public void result(View v){

        if(edtNumber.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "You should number.",Toast.LENGTH_LONG).show();
        }else{
            final Intent intent = new Intent(GuessActivity.this, ResultActivity.class);
            intent.putExtra("sayi",(int) randomNumber);

            i = i - 1;
            int tahmin = Integer.parseInt(edtNumber.getText().toString());

            if(tahmin == randomNumber){
                Intent i = new Intent(GuessActivity.this, ResultActivity.class);
                i.putExtra("sonuc",true);
                startActivity(i);
                finish();
                return;
            }
            if(tahmin > randomNumber){
                txtHelp.setText("Decrease");
                txtRemaining.setText("Remaining Right: "+ i);
            }
            if(tahmin < randomNumber){
                txtHelp.setText("Increase");
                txtRemaining.setText("Remaining Right : "+ i);
            }
            if(i == 0){
                Intent i = new Intent(GuessActivity.this, ResultActivity.class);
                i.putExtra("sonuc",false);
                startActivity(i);
                startActivity(intent);
                finish();
            }
            edtNumber.setText("");

        }

    }
}
