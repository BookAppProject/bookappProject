package com.example.hp.bookapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by HP on 11/17/2017.
 */

public class CustomListAdapter extends ArrayAdapter implements View.OnClickListener {
    private final Activity context;

    String[] itemname = {
            "To kill a mockingbird",
            "The Alchamist",
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
            R.drawable.dog,
            R.drawable.wine,
            R.drawable.what,
            R.drawable.rich,
            R.drawable.war,
            R.drawable.archie,

    };

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.activity_list, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_list, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);


        if (imgid.length > 0) {
            imageView.setImageResource(imgid[position]);
        }

        txtTitle.setText(itemname[position]);
        extratxt.setText("Description: " + itemname[position]);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MoreDet.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                String url = itemname[position];
//                intent.putExtra("url", url);
                context.startActivity(intent);
            }
        });

        return rowView;

    };

    @Override
    public void onClick(View view) {

    }
}