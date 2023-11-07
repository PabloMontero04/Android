package com.example.basedatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class anadirActivity extends AppCompatActivity {

    EditText nombreEditText, descripcionEditText;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir);
        dbHelper = new DbHelper(this);
        nombreEditText = findViewById(R.id.Nombre);
        descripcionEditText = findViewById(R.id.Descripcion);

        Button enviarButton = findViewById(R.id.Enviar);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores de los EditText
                String nombre = nombreEditText.getText().toString();
                String descripcion = descripcionEditText.getText().toString();

                // Validar que los campos no estén vacíos
                if (nombre.isEmpty() || descripcion.isEmpty()) {
                    Toast.makeText(anadirActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    /*
                    METODO MEDIANTE QUERY
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    String insertQuery = "INSERT INTO Productos (id, Nombre, Descripcion) VALUES (?, ?, ?)";
                    db.execSQL(insertQuery, new String[]{id, nombre, descripcion});
                    db.close();
                    */

                    // Obtener una instancia de SQLiteDatabase
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    // Crear un objeto ContentValues para insertar datos
                    ContentValues values = new ContentValues();
                    values.put("Nombre", nombre);
                    values.put("Descripcion", descripcion);

                    // Insertar los datos en la base de datos
                    long newRowId = db.insert("Productos", null, values);

                    // Verificar si la inserción fue exitosa
                    if (newRowId != -1) {
                        // Muestra un mensaje de éxito
                        Toast.makeText(anadirActivity.this, "Producto agregado correctamente", Toast.LENGTH_SHORT).show();
                        //limpia los campos
                        nombreEditText.setText("");
                        descripcionEditText.setText("");
                    } else {
                        Toast.makeText(anadirActivity.this, "Error al agregar el producto", Toast.LENGTH_SHORT).show();
                    }

                    // Cierra la base de datos
                    db.close();
                }
            }
        });

        Button volverButton = findViewById(R.id.Volver);
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

