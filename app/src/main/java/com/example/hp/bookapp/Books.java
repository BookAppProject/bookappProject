package com.example.hp.bookapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.net.URL;
import java.util.List;

public class Books extends ListActivity {
    WebView mywebview;
    private String newsURL;
    String[] itemname = {
            "To kill a mockingbird",
            "The Alchemist",
            "What the dog saw",
            "Wine",
            "What to expect before you are expecting",
            "Think and grow rich",
            "The art of war",
            "Archie Comic books"

    };
    Integer[] imgid = {
            R.drawable.bird,
            R.drawable.mist,
            R.drawable.what,
            R.drawable.wine,
            R.drawable.what,
            R.drawable.rich,
            R.drawable.war,
            R.drawable.archie,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];


                // Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("https://benedictineabwao.000webhostapp.com/home.php\n" +
//                        "\n\n"));
//                startActivity(i);


                ////Intent intent=new Intent(getApplicationContext(),web.class);
                //startActivity( intent );


            }
        });
    }
}

