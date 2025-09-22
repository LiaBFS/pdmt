package com.example.bleblebleblublubl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TabuadaResultado extends AppCompatActivity {

    TextView textViewTabuada;
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tabuada_resultado);

        textViewTabuada.findViewById(R.id.textViewTabuada);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Double numero = bundle.getDouble("numero");



        Double vezes1 = numero;

        textViewTabuada.setText(Double.toString(vezes1));

        Double vezes2 = numero*2;

        textView5.setText(Double.toString(vezes2));




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}