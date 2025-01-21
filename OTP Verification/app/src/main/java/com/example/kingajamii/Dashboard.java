package com.example.kingajamii;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Dashboard extends AppCompatActivity {

    //declaring variables for animation or simply creating hooks

    Button callSignUp, loginBtn;
    ImageView image;
    TextInputLayout username, password;
    TextView kinga, tagline;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // code to hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);

        //calling sign_up.xml fields by their id

        callSignUp = findViewById(R.id.Button_new_user_register);

        image = findViewById(R.id.logo_name_signup);
        kinga = findViewById(R.id.kinga_text_signup);
        tagline = findViewById(R.id.signup_text_signup);
        username = findViewById(R.id.username_signup);
        password = findViewById(R.id.password_signup);
        loginBtn = findViewById(R.id.btn_signup);




            callSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intents = new Intent(Dashboard.this, SignUp.class);

                    startActivity(intents);



                  //  Pair[] pairs = new Pair[7];
                 //   pairs[0] = new Pair<View, String>(image, "logo_image");
                   // pairs[1] = new Pair<View, String>(kinga, "kinga_text");
                 //   pairs[2] = new Pair<View, String>(tagline, "kinga_text");
                  //  pairs[3] = new Pair<View, String>(username, "username_text");
                   // pairs[4] = new Pair<View, String>(password, "password_text");
                    //pairs[5] = new Pair<View, String>(loginBtn, "new_user_text");
                    //pairs[6] = new Pair<View, String>(callSignUp, "login_text");


                //    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                 //       ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Dashboard.this, pairs);

              //          startActivity(intents,options.toBundle());
                  //  }




                }
            });







    }

    // login form validation

  /*  private Boolean validateUsername(){
        String value = username.getEditText().getText().toString();

        if (value.isEmpty()){

            username.setError("First Name Cannot be Empty");

            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);

            return true;
        }

    }

    private Boolean validatePhoneNumber(){

        String value = password.getEditText().getText().toString();



        if (value.isEmpty()){
            password.setError("Please Enter Your Phone Number");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);

            return true;
        }
    }


    public void LoginUser(View view) {

        if ( !validateUsername() | !validatePhoneNumber() ){

            // if the values are incorrect, display the error message and return the user to tbe form

            return;
        }
    }*/


}
