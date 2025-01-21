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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //declaring variables

    Button SignUpBtn, Login_BackBtn;
    TextInputLayout reg_first_name, reg_last_name, reg_email_address, reg_Username, reg_Phone_Number,
            reg_Password;

    //firebase variables

    FirebaseDatabase database;
    DatabaseReference dbReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // code to hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sign_up);

        //hooking all value ids in activity_sign_up.xml

        reg_first_name = findViewById(R.id.first_name_signup);
        reg_last_name = findViewById(R.id.last_name_signup);
        reg_Username = findViewById(R.id.username_signup);
        reg_email_address = findViewById(R.id.email_signup);
        reg_Phone_Number = findViewById(R.id.phone_number_signup);
        reg_Password = findViewById(R.id.password_signup);
        SignUpBtn = findViewById(R.id.btn_signup);
        Login_BackBtn = findViewById(R.id.btn_loginscreen);


        //form validation





    }


    //sign up form validation

    private Boolean validateFirstname (){
        String value = reg_first_name.getEditText().getText().toString();

        if (value.isEmpty()){

            reg_first_name.setError("First Name Cannot be Empty");

            return false;
        }
        else {
            reg_first_name.setError(null);
            reg_first_name.setErrorEnabled(false);

            return true;
        }



    }
    private Boolean validateLastname (){
        String value = reg_last_name.getEditText().getText().toString();

        if (value.isEmpty()){

            reg_last_name.setError("Last Name Cannot be Empty");

            return false;
        }
        else {
            reg_first_name.setError(null);

            reg_last_name.setErrorEnabled(false);

            return true;
        }



    }
    private Boolean validateUsername (){

        String value = reg_Username.getEditText().getText().toString();
        String noWhite = "\\A\\w{4,20}/z";

        if (value.isEmpty()){

            reg_Username.setError("Username Cannot be Empty");

            return false;
        }

        //setting the maximum number of characters for the username
        else if (value.length()>=15) {

            reg_Username.setError("Username too Long");
            return false;

        }
      /*  else if (!value.matches(noWhite)){

            reg_Username.setError("White Spaces are not allowed");
            return false;
        }*/


        else {
            reg_Username.setError(null);
            reg_Username.setErrorEnabled(false);

            return true;
        }



    }
    private Boolean validateEmail(){

        String value = reg_email_address.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (value.isEmpty()){
            reg_email_address.setError("Please Enter Your Email");

            return false;
        }
        else if (!value.matches(emailPattern)){
            reg_email_address.setError("You Have Entered an Invalid Email");

            return false;
        }
        else {
            reg_email_address.setError(null);
            reg_email_address.setErrorEnabled(false);

            return true;
        }
    }
    private Boolean validatePhoneNumber(){

        String value = reg_Phone_Number.getEditText().getText().toString();

        if (value.isEmpty()){
            reg_Phone_Number.setError("Please Enter Your Phone Number");
            return false;
        }
        else {
            reg_Phone_Number.setError(null);
            reg_Phone_Number.setErrorEnabled(false);

            return true;
        }
    }
    private Boolean validatePassword(){

        String value = reg_Password.getEditText().getText().toString();

        String passwordPattern = "^" +
                // "(?=.*[0-9])" at least one digit
                // "(?=.*[a-z])" at least one lower case letter
                // "(?=.*[A-Z])" at least one lower case letter

                "(?=.*[a-z A-Z])"  +   /*at least one lower case letter*/
                "(?=.*[@#$%^&+=])" +   /*at least one special character*/
                //  "(?=/S + $)" +         /*no white spaces*/
                ".{6,}" +                /*password should have at least 6 characters*/
                "$";
        if (value.isEmpty()){
            reg_Password.setError("Password Field cannot be Empty");
            return false;
        }
        else if (!value.matches(passwordPattern)){
            reg_Password.setError("Your Password is too Weak.");
            return false;
        }
        else {
            reg_Password.setError(null);
            reg_Password.setErrorEnabled(false);
            return true;
        }
    }



    // when user clicks on Sign Up Button method, pass/store the data in google firebase

    public void registerUser(View view) {



        if (!validateFirstname() | !validateLastname() | !validateUsername() |
                !validateEmail() | !validatePhoneNumber() | !validatePassword()){

            // if the values are incorrect, display the error message and return the user to tbe form

            return;
        }


        //calling firebase database instance

        database = FirebaseDatabase.getInstance();



        //defining data reference for the firebase reference

        //System_Users is the name of database table in Firebase

        dbReference = database.getReference("System_Users");



        //to store data, first get all values from the text fields


        String firstname =reg_first_name.getEditText().getText().toString();
        String lastname =reg_last_name.getEditText().getText().toString();
        String username=reg_Username.getEditText().getText().toString();
        String phonenumber =reg_Phone_Number.getEditText().getText().toString();
        String password =reg_Password.getEditText().getText().toString();
        String email =reg_email_address.getEditText().getText().toString();


        // before storing the data.....verify the phone number
        Intent intent = new Intent(getApplicationContext(),VerifyPhoneNumber.class);

        startActivity(intent);



        //to Store Data, create a java helper class; in this case Our helper class is called Kinga Helper Class
        //the helper class is for storing data for the app users.

        //call the user helper class


      /*  UserHelperClass userHelperClass = new UserHelperClass(firstname, lastname, username, email, phonenumber, password);

        dbReference.child(phonenumber).setValue(userHelperClass);

        Toast.makeText(this, "Your Account has been Created Successfully", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),Login.class);

        startActivity(intent);

        finish();*/





    }
}




