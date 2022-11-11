package com.example.edicionesgraficas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.OnSwipe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Swipe Position";
    private float x1, x2, y1, y2;
    private static int MIN_DIST = 150;
    private GestureDetector gestureDetector;



    View gridLayout;
    View relativeLayout;
    View constraintActivity;
    View mainActivity;
    View tableLayout;
    OnSwipe onSwipe;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        switch (event.getAction()){
            // empieza el gesto
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            // acaba el gesto
            case MotionEvent.ACTION_UP:
                x2 = event.getX();

                // cogemos el valor del swipe
                float valueX = x2 - x1;

                if(Math.abs(valueX) > MIN_DIST){
                    // detecta izquierda a derecha
                    if(x2>x1){
                        Intent intent = new Intent(this, GridLayout.class);
                        startActivity(intent);
                    }
                    // detecta derecha a izquierda
                    else {

                    }
                }
        }
        return super.onTouchEvent(event);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bgl = findViewById(R.id.btnGL);
        Button brl = findViewById(R.id.btnRL);
        Button btl = findViewById(R.id.btnTL);
        Button bca = findViewById(R.id.btnCA);
        Button bJuego = findViewById(R.id.btnJuego);

        Class claseRL = RelativeLayout.class;
        Class claseGL = GridLayout.class;
        Class claseTL = TableLayout.class;
        Class claseCA = ConstraintActivity.class;
        Class claseJuego = Juego.class;



        //Hago un on click listener al cual llamo un método que realiza la acción
        //al método le paso la clase a la cual quiero que se vaya
        bgl.setOnClickListener(v -> metofo(claseGL));
        brl.setOnClickListener(v -> metofo(claseRL));
        btl.setOnClickListener(v -> metofo(claseTL));
        bca.setOnClickListener(v -> metofo(claseCA));
        bJuego.setOnClickListener(v -> metofo(claseJuego));

        /*relativeLayout = findViewById(R.id.RL);
        gridLayout = findViewById(R.id.GL);
        constraintActivity = findViewById(R.id.CA);
        mainActivity = findViewById(R.id.AM);
        tableLayout = findViewById(R.id.TL);
        this.gestureDetector = new GestureDetector((Context) MainActivity.this, (GestureDetector.OnGestureListener) this);*/

    }
    public void metofo(Class clase){
        Intent intent = new Intent(this, clase); startActivity(intent);
    }
}