package com.example.hp.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends Books {
    WebView mywebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//                String url="https://benedictineabwao.000webhostapp.com/home.php\n" +
//                        "\n";
//
//                mywebview = (WebView) findViewById(R.id.mywebview);
//                mywebview.loadUrl(url);
//
//                WebSettings webSettings = mywebview.getSettings();
//                webSettings.setJavaScriptEnabled(true);
//                mywebview.setWebViewClient(new WebViewClient());
//
//
//            }
//        });


    }
}

