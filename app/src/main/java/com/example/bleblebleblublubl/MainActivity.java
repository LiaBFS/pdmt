package com.example.bleblebleblublubl;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {

    Button button; //aponta inicialmente para null
    EditText editTextMin, editTextMax;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.button);
        editTextMin =findViewById(R.id.edMin);
        editTextMax =findViewById(R.id.edMax);
        tvResultado = findViewById(R.id.tvResultado);


        button.setOnClickListener(v -> {
            Random random = new Random();
            int min,max;
            min= Integer.parseInt(editTextMin.getText().toString());
            max= Integer.parseInt(editTextMax.getText().toString());
            int delta = max-min;


            int sortiado = random.nextInt(delta)+min;
            tvResultado.setText(Integer.toString(sortiado));



        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo_vida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo_vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo_vida", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ciclo_vida", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo_vida", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ciclo_vida", "onDestroy");
    }

}