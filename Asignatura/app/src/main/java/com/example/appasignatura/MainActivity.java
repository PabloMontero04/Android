package com.example.appasignatura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtLengua, edtMatematicas, edtIngles;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLengua = findViewById(R.id.Lengua);
        edtMatematicas = findViewById(R.id.Matematicas);
        edtIngles = findViewById(R.id.Ingles);
        btnEnviar = findViewById(R.id.Enviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los EditText
                double notaLengua = Double.parseDouble(edtLengua.getText().toString());
                double notaMatematicas = Double.parseDouble(edtMatematicas.getText().toString());
                double notaIngles = Double.parseDouble(edtIngles.getText().toString());

                // Calcular la media
                double media = (notaLengua + notaMatematicas + notaIngles) / 3;

                // Mostrar un Toast
                Toast.makeText(MainActivity.this, "Estas son tus notas", Toast.LENGTH_LONG).show();

                // Abrir la nueva actividad y pasar la media como extra
                Intent intent = new Intent(MainActivity.this, VentanaNota.class);
                intent.putExtra("MEDIA_NOTAS", media);
                startActivity(intent);
            }
        });
    }

}