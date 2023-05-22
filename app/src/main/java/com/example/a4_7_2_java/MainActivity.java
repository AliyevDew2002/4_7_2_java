package com.example.a4_7_2_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a4_7_2_java.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextInputLayout textInputEmail,textInputPassword,textInputUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityMainBinding.inflate(getLayoutInflater());
       View view=binding.getRoot();
       setContentView(view);

         textInputEmail=binding.textInputEmail;
         textInputPassword=binding.textInputPassword;
         textInputUsername=binding.textInputUsername;

    }


    void initViews(){

    }





    private boolean validateEmail(){
        String emailInput=textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputEmail.setError("Bu Oyna Bo'sh!");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateUsername(){
        String usernameInput=textInputUsername.getEditText().getText().toString().trim();
        if (usernameInput.isEmpty()){
            textInputUsername.setError("Bu oyna bo'sh!");
            return false;
        }else if(usernameInput.length() <= 15){
            textInputUsername.setError("Minimal 15ta harf bo'lishi kerak!");
            return false;
        }else{
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String paswordInput=textInputPassword.getEditText().getText().toString().trim();
        if (paswordInput.isEmpty()){
            textInputPassword.setError("Bu Oyna Bo'sh!");
            return false;
        }else{
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v){
        if (!validateEmail() | !validatePassword() | !validateUsername()){
            return;
        }

        String input="Email: "+textInputEmail.getEditText().getText().toString();
        input+="\n";
        input+="Username: "+textInputUsername.getEditText().getText().toString();
        input+="\n";
        input+="Password: "+textInputPassword.getEditText().getText().toString();
        input+="\n";

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

}