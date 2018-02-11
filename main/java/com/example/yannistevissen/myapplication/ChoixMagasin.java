package com.example.yannistevissen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ChoixMagasin extends AppCompatActivity {
    private ImageView logo;
    private TextView choix;
    private Spinner mspinner;
    private Button Next;
    private String[] Magasins = {
             "Carrefour Evry2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_magasin);
        logo = (ImageView) findViewById(R.id.logo);
        choix = (TextView) findViewById(R.id.choix);
        mspinner = (Spinner) findViewById(R.id.spinner);
        Next = (Button) findViewById(R.id.next);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Magasins);
        mspinner.setAdapter(adapter);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                Intent ListeActivity= new Intent(ChoixMagasin.this, MenuPrincipal.class);
                startActivity(ListeActivity);
            }
        });




    }
}
