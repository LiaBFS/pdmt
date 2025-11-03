package com.example.bleblebleblublubl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("meu_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER primary key autoincrement,"+
                " titulo VARCHAR, texto TEXT)");

        ContentValues values = new ContentValues();
        values.put("titulo", "Nota exemplo");
        values.put("texto", "Este é o texto da nota de exemplo");
        db.insert("notas", null, values);

        b.findViewById(R.id.button);
        b.setOnClickListener(v ->{
            EditText editText = findViewById(R.id.editTextText);
            String texto = editText.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo", "Nota do Usuario");
            cv.put("texto", texto);

            db.insert("notas", null, cv);
            /**Toast.makeText("Nota salva", Toast.LENGTH_SHORT).show();**/
        });

    }
}