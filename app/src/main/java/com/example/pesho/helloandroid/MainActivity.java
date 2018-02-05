package com.example.pesho.helloandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Uri WEBSITE_ADDRESS = Uri.parse("https://www.udacity.com/");
    private static Uri WEBSITE_ADDRESS_CHELANGE = Uri.parse("https://www.udacity.com/grow-with-google");
    private static Uri ADDRESS_URI = Uri.parse("https://www.google.bg/maps/place/2465+Latham+St,+Mountain+View,+CA+94040,+USA" +
            "/@37.3992651,-122.1083039,18z/data=!4m5!3m4!1s0x808fb098443680fd:0xc806a7a80752e40c!8m2!3d37.3999001!4d-122.1084005");
    private static Uri TELEPHONE_URI = Uri.parse("tel:06505555555");
    private static String TELEPHONE = "6505555555";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.udacity_line);
        text.setText(R.string.courses_provider);

        TextView addressText = findViewById(R.id.address);
        addressText.setText("address: 2465 Latham Str. Mountain View,\n CA 94043");

        TextView telephoneText = findViewById(R.id.telephone);
        telephoneText.setText("tel: " + TELEPHONE);

        final TextView websiteText = findViewById(R.id.website);
        websiteText.setText(R.string.website);
        websiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, WEBSITE_ADDRESS);
                startActivity(websiteIntent);
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, WEBSITE_ADDRESS_CHELANGE);
                startActivity(websiteIntent);
            }
        });
        addressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsIntent = new Intent(Intent.ACTION_VIEW, ADDRESS_URI);
                startActivity(mapsIntent);
            }
        });


        telephoneText.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent telephoneIntent = new Intent(Intent.ACTION_CALL);
                telephoneIntent.setData(TELEPHONE_URI);

                startActivity(telephoneIntent);
            }
        });


    }

}
