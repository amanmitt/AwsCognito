package com.example.cognito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken;

public class Login extends AppCompatActivity {

    Button btnLogin;
    Button btnLogout;
    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        btnLogin = findViewById(R.id.btnLogin);
      //  btnLogout = findViewById(R.id.btnLogout);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);


            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!etUsername.getText().toString().equals("") && !etPassword.getText().toString().equals("")) {
                        Cognito authentication = new Cognito(getApplicationContext());
                        authentication.userLogin(etUsername.getText().toString(), etPassword.getText().toString());
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Please fill in the details",Toast.LENGTH_SHORT).show();
                    }
                }
            });


//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cognito authentication = new Cognito(getApplicationContext());
//                authentication.logout(etUsername.getText().toString());
//            }
//        });


    }
}