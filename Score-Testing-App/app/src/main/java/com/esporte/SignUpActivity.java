package com.esporte;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button signup;
    TextView login;
    EditText name,email;
    private ProgressDialog progressDialog;
    String Name,Email, resultant;
    StringBuffer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        signup = (Button) findViewById(R.id.btn_signup);
        login = (TextView) findViewById(R.id.link_login);

        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup:
                signup();
                break;

            case R.id.link_login:
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
    public void signup() {

        if (!validate()) {
            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onSignupSuccess();
                    }
                }, 2000);
    }
    private void onSignupSuccess() {
        progressDialog.dismiss();
        validate();
        Toast.makeText(SignUpActivity.this,""+Name+Email,Toast.LENGTH_SHORT).show();
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(SignUpActivity.this);
        helper.addContact(Name,Email);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public boolean validate() {
        boolean valid = true;

        Name = name.getText().toString();
        Email = email.getText().toString();
        result = new StringBuffer();
        resultant = result.toString();

        if (Name.isEmpty() || Name.length() < 5) {
            name.setError("at least 5 characters");
            valid = false;
        } else {
            name.setError(null);
        }

        if (Email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }

        return valid;
    }
}
