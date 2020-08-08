package com.letsknowthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResult;
    private Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txt_result);

        result = getIntent().getBooleanExtra("sonuc",false);

        if(result){
            txtResult.setText("Congratulations");
        }else{
            Integer value = getIntent().getExtras().getInt("sayi");
            txtResult.setText("You Lose! Number: " + value);
        }
    }

    public void playagain(View v){
        startActivity(new Intent(ResultActivity.this, GuessActivity.class));
        finish();
    }
}
