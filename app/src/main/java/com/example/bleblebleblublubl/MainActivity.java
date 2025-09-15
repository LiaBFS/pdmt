package com.example.bleblebleblublubl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button button7;

    EditText edPeso, edAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button7 = findViewById(R.id.button7);
        edPeso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);

        button7.setOnClickListener(v->{
            Intent intent = new Intent(this, IMC_Resultado.class);


            Bundle bundle = new Bundle();
            Double peso = Double.parseDouble(edPeso.getText().toString());
            Double altura = Double.parseDouble(edAltura.getText().toString());

            bundle.putDouble("peso",peso);
            bundle.putDouble("altura", altura);

            intent.putExtras(bundle);
            startActivity(intent);

        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}