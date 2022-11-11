package com.example.edicionesgraficas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class Juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        AtomicInteger elec = new AtomicInteger();
        Button bpapel = null;
        Button bpiedra = null;
        Button btijeras = null;
        ImageView papel = findViewById(R.id.imageViewPapel);
        ImageView tijeras = findViewById(R.id.imageViewTijeras);
        ImageView piedra = findViewById(R.id.imageViewPiedra);

        bpiedra.setOnClickListener(v -> elec.set(1));
        btijeras.setOnClickListener(v -> elec.set(3));
        bpapel.setOnClickListener(v -> elec.set(2));

        int belec = (int) (Math.random()*3+1);
        switch (belec){
            case 1:
            piedra.setVisibility(View.VISIBLE);
            tijeras.setVisibility(View.GONE);
            papel.setVisibility(View.GONE);
            case 2:
                piedra.setVisibility(View.GONE);
                tijeras.setVisibility(View.GONE);
                papel.setVisibility(View.VISIBLE);
            case 3:
                piedra.setVisibility(View.GONE);
                tijeras.setVisibility(View.VISIBLE);
                papel.setVisibility(View.GONE);
        }
        if(elec.get() == belec){//piedra
            System.out.println("Empate");
        }
        else{
            // Tú eres PIEDRA
            if (elec.get() == 1 && belec == 2){
                System.out.println("Gana C ontrincante");
                Toast.makeText(getApplicationContext(), "Gana el contrincante", Toast.LENGTH_LONG);

            }
            else{
                if (elec.get() == 1 && belec == 3){
                    Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG);System.out.println("Ganas tú");
                }
            }
            // TU ERES PAPEL
            if (elec.get() == 2 && belec == 1){
                Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG);
            }
            else {
                if(elec.get() == 2 && belec == 3){
                    Toast.makeText(getApplicationContext(), "Gana el contrincante", Toast.LENGTH_LONG);
                }
            }
            // TU ERES TIJERAS
            if(elec.get() == 3 && belec == 1){
                Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG);
            }
            else {
                if(elec.get() == 3 && belec == 2){
                    Toast.makeText(getApplicationContext(), "Has ganado!", Toast.LENGTH_LONG);
                }
            }
        }
    }


}