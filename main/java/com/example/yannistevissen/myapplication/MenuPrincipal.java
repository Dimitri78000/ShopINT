package com.example.yannistevissen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    private Button liste;
    private Button ponctuel;
    private Button Itineraire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        liste = (Button) findViewById(R.id.liste);
        ponctuel = (Button) findViewById(R.id.ponctuel);
        Itineraire = (Button) findViewById(R.id.Itineraire);
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent ListeActivity= new Intent(MenuPrincipal.this, MainActivity.class);
                startActivity(ListeActivity);
            }
        });
        ponctuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent PonctuelActivity= new Intent(MenuPrincipal.this, Ponctuel.class);
                startActivity(PonctuelActivity);
            }
        });
        Itineraire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent ItineraireActivity= new Intent(MenuPrincipal.this, Itineraire.class);
                startActivity(ItineraireActivity);
            }
        });


    }
}
