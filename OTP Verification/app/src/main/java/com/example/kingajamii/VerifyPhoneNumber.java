package com.example.kingajamii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class VerifyPhoneNumber extends AppCompatActivity {
    //declaring variables
    Button verify_btn;
    EditText verification_code;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // code to hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_verify_phone_number);

        //calling variables from activity_verify_phone_number

        verification_code = findViewById(R.id.verification_code_entered_by_user);
        verify_btn= findViewById(R.id.verify_btn);
        progressBar= findViewById(R.id.progress_bar);






    }
}
