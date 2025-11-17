package com.example.bleblebleblublubl;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button b;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("meu_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER primary key autoincrement," +
                " titulo VARCHAR, texto TEXT)");

        carregarListagem();
        b=findViewById(R.id.button);
        b.setOnClickListener(v -> {
            EditText editText = findViewById(R.id.editTextText);
            String texto = editText.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo", texto);
            cv.put("texto", texto);

            db.insert("notas", null, cv);
            /**Toast.makeText("Nota salva", Toast.LENGTH_SHORT).show();**/

            carregarListagem();
        });

        lv.setOnItemClickListener(((parent, view, position, id) -> {
            String titulo = (String) parent.getItemAtPosition(position);


            Intent intent = new Intent(MainActivity.this, ExibeItem.class);
            startActivity(intent);
        }));

    }
        public void carregarListagem (){
            ArrayList<String> titulos = new ArrayList<String>();
            Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
            cursor.moveToFirst();

            while (!cursor.isAfterLast()){

                //ta certo, só não foi feito tratamento de erro
                String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                titulos.add(titulo);
                cursor.moveToNext();
            }
            ArrayAdapter<String> tituloAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, titulos);
            lv.setAdapter(tituloAdapter);

        }
}