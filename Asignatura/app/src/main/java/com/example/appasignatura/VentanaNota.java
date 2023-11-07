package com.example.appasignatura;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class VentanaNota extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventananota);


        // Obtener la media de las notas pasada como extra
        double mediaNotas = getIntent().getDoubleExtra("MEDIA_NOTAS", 0.0);

        // Mostrar la media en un TextView
        TextView textViewMedia = findViewById(R.id.Media);
        textViewMedia.setText("Media de las notas: " + mediaNotas);

        // Configurar OnClickListener para el botón de volver
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
