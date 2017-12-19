package com.example.hp.bookapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener{


    TextView username;
    protected Button logout_btn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //can't figure out what i've named my shit .COULD THAT BE THE PROBLEM ?????
        username = (TextView) findViewById(R.id.username);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        logout_btn=(Button)findViewById(R.id.signout);
        logout_btn.setOnClickListener(this);


        Button books = (Button) findViewById(R.id.books);
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(Home.this, Books.class);
                startActivity(Home);
            }
        });

        Button store = (Button) findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(getApplicationContext(),Maps.class);
                startActivity(Home);
            }
        });
    }

    @Override
    public void onClick(View view) {
        finish();
        progressDialog.setMessage("Logging out...");
        progressDialog.show();
        firebaseAuth.signOut();
        Intent homeActivity=new Intent(Home.this, Login.class);
        startActivity(homeActivity);
        //To finish your current acivity
    }
}
