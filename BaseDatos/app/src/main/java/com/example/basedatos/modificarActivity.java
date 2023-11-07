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

public class modificarActivity extends AppCompatActivity {

    EditText modificarIdEditText, nombreEditText, descripcionEditText;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar);

        dbHelper = new DbHelper(this);

        modificarIdEditText = findViewById(R.id.ModificarID);
        nombreEditText = findViewById(R.id.Nombre);
        descripcionEditText = findViewById(R.id.Descripcion);

        Button modificarButton = findViewById(R.id.Modificar);
        modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores de los EditText
                String modificarId = modificarIdEditText.getText().toString();
                String nombre = nombreEditText.getText().toString();
                String descripcion = descripcionEditText.getText().toString();

                // Validar que los campos no estén vacíos
                if (modificarId.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                    Toast.makeText(modificarActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Obtener una instancia de SQLiteDatabase
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    // Crear un objeto ContentValues para actualizar datos
                    ContentValues values = new ContentValues();
                    values.put("Nombre", nombre);
                    values.put("Descripcion", descripcion);

                    // Definir la cláusula WHERE para la actualización
                    String selection = "id = ?";
                    String[] selectionArgs = { modificarId };

                    // Realizar la actualización de los datos
                    int rowsUpdated = db.update("Productos", values, selection, selectionArgs);

                    // Verificar si la actualización fue exitosa
                    if (rowsUpdated > 0) {
                        // Muestra un mensaje de éxito
                        Toast.makeText(modificarActivity.this, "Producto modificado correctamente", Toast.LENGTH_SHORT).show();

                        // Limpia los campos después de modificar el producto
                        modificarIdEditText.setText("");
                        nombreEditText.setText("");
                        descripcionEditText.setText("");
                    } else {
                        Toast.makeText(modificarActivity.this, "Error al modificar el producto", Toast.LENGTH_SHORT).show();
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

