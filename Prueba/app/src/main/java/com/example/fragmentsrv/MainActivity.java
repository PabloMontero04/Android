package com.example.fragmentsrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    FragmentTransaction transaction;
    Fragment Inicio, Rojo, Verde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inicio = new FragmentInicio();
        Rojo = new FragmentRojo();
        Verde = new FragmentVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, Inicio).commit();



    }

    protected void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();

        int id = view.getId();

    if (id == R.id.Rojo) {
        transaction.replace(R.id.contenedorFragments, Rojo);
        transaction.addToBackStack(null);}
        transaction.commit();
    if (id == R.id.Verde) {
        transaction.replace(R.id.contenedorFragments, Verde);
         transaction.addToBackStack(null);}
        transaction.commit();


    }


}