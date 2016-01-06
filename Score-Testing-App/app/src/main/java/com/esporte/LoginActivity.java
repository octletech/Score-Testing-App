package com.esporte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email;
    TextView signup;
    Button login;
    String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.input_email);
        signup = (TextView) findViewById(R.id.link_signup);
        login = (Button)findViewById(R.id.btn_login);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.link_signup:
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_login:
                /*Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(loginIntent);*/
                loginUser();
        }
    }

    private void loginUser() {
        if (!validate()) {
            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
            return;
        }
        onSignupSuccess();
    }
    private void onSignupSuccess() {
        validate();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public boolean validate() {
        boolean valid = true;

        Email = email.getText().toString();

        if (Email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches() ) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }


        return valid;
    }
}
