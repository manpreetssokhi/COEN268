package com.example.formula1teams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.view.*;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View ferarri;
    View mercedes;
    View redBull;
    View mcLaren;
    View renault;
    View racingPoint;
    View alfaRomeo;
    View alphaTauri;
    View haas;
    View williams;

    String ferrariLink = "https://en.wikipedia.org/wiki/Scuderia_Ferrari";
    String mercedesLink = "https://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One";
    String redBullLink = "https://en.wikipedia.org/wiki/Red_Bull_Racing";
    String mcLarenLink = "https://en.wikipedia.org/wiki/McLaren_F1";
    String renaultLink = "https://en.wikipedia.org/wiki/Renault_in_Formula_One";
    String racingPointLink = "https://en.wikipedia.org/wiki/Racing_Point_F1_Team";
    String alfaRomeoLink = "https://en.wikipedia.org/wiki/Alfa_Romeo_in_Formula_One";
    String alphaTauriLink = "https://en.wikipedia.org/wiki/Scuderia_AlphaTauri";
    String haasLink = "https://en.wikipedia.org/wiki/Haas_F1_Team";
    String williamsLink = "https://en.wikipedia.org/wiki/Williams_Grand_Prix_Engineering";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ferarri = (LinearLayout)findViewById(R.id.ferrariLL);
        mercedes = (LinearLayout)findViewById(R.id.mercedesLL);
        redBull = (LinearLayout)findViewById(R.id.redBullLL);
        mcLaren = (LinearLayout)findViewById(R.id.mcLarenLL);
        renault = (LinearLayout)findViewById(R.id.renaultLL);
        racingPoint = (LinearLayout)findViewById(R.id.racingPointLL);
        alfaRomeo = (LinearLayout)findViewById(R.id.alfaRomeoLL);
        alphaTauri = (LinearLayout)findViewById(R.id.alphaTauriLL);
        haas = (LinearLayout)findViewById(R.id.haasLL);
        williams = (LinearLayout)findViewById(R.id.williamsLL);

        ferarri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Scuderia Ferrari has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", ferrariLink);
                startActivity(intent);
            }
        });

        mercedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Mercedes has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", mercedesLink);
                startActivity(intent);
            }
        });

        redBull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Red Bull  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", redBullLink);
                startActivity(intent);
            }
        });

        mcLaren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("McLaren  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", mcLarenLink);
                startActivity(intent);
            }
        });

        renault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Renault  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", renaultLink);
                startActivity(intent);
            }
        });

        racingPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Racing Point  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", racingPointLink);
                startActivity(intent);
            }
        });

        alfaRomeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Alfa Romeo  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", alfaRomeoLink);
                startActivity(intent);
            }
        });

        alphaTauri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Alpha Tauri  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", alphaTauriLink);
                startActivity(intent);
            }
        });

        haas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Haas  has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", haasLink);
                startActivity(intent);
            }
        });

        williams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Williams has been clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("urlWikipedia", williamsLink);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}