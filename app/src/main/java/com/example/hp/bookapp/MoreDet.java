package com.example.hp.bookapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MoreDet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_det);

        String url ="https://benedictineabwao.000webhostapp.com/home.php\n" +
                "\n";
        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.loadUrl(url);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebview.setWebViewClient(new WebViewClient());

    }
}
