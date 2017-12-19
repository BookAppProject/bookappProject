package com.example.hp.bookapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.hp.bookapp.R.layout.activity_login;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "content_login";

    //PROBLEM HERE POSSIBLY
    public Button mBtLogin;
    public Button mBtSignup;
    private EditText txt_password;
    private EditText txt_email;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //different from yours....WHY ....

        setContentView(activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button btnlogin = (Button) findViewById(R.id.btnCreateAccount);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), signup.class);
                startActivity(login);
            }
        });

        Button btnsign = (Button) findViewById(R.id.login);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(Login.this, Home.class);
                startActivity(login);
            }
        });

        firebaseAuth = firebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            Intent mainActivity = new Intent(Login.this, Home.class);
            startActivity(mainActivity);
        }

        progressDialog = new ProgressDialog(this);

        txt_password = (EditText) findViewById(R.id.password);
        txt_email = (EditText) findViewById(R.id.email);
        mBtLogin = (Button) findViewById(R.id.login);

        //WRONG NAME MAYBE???
        mBtSignup = (Button) findViewById(R.id.btnCreateAccount);


        mBtLogin.setOnClickListener((View.OnClickListener) this);
        mBtSignup.setOnClickListener((View.OnClickListener) this);

    }

    //WTTTTFFFFFFFFFF pls help?
    @Override
    public void onClick(View v) {
        if (v == mBtLogin) {
            authenticateUser();
        }
        if (v == mBtSignup) {
            Intent signUp = new Intent(Login.this, signup.class);
            startActivity(signUp);
        }
    }

    private void authenticateUser() {
        String email = txt_email.getText().toString().trim();
        String password = txt_password.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logging On");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)

                //PROBLEM ARROW THINGY
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Log in Successful... ", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent mainActivity = new Intent(getApplicationContext(), Home.class);
                            startActivity(mainActivity);
                        } else {
                            Toast.makeText(getApplicationContext(), "Log in unsuccessful , please try again  ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}


