package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.dex.Animal;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Administrador extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText nomAnimal, estConservacion, evoAnterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        nomAnimal= findViewById(R.id.nombreAnimal);
        estConservacion= findViewById(R.id.estConservacion);
        evoAnterior= findViewById(R.id.evolucionAnterior);
         inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu (menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String nombreAnimal = nomAnimal.getText().toString();
        String estadoCoservacion = estConservacion.getText().toString();
        String evolucionAnterior = evoAnterior.getText().toString();
        switch(item.getItemId()){
            case R.id.icon_add:{
                if(nombreAnimal.equals("")||estadoCoservacion.equals("")||evolucionAnterior.equals("")){
                    validacion();
                    break;
                } else {
                    Animal a = new Animal();
                    a.setUid(UUID.randomUUID().toString());
                    a.setNombreAnimal(nombreAnimal);
                    a.setEstConservacion(estadoCoservacion);
                    a.setEvolucionAnterior(evolucionAnterior);
                    databaseReference.child("Animales").child(a.getUid()).setValue(a);
                    limpiarCajas();
                    Toast.makeText(this, "Agregar", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            case R.id.icon_save:{
                Toast.makeText(this, "Guardar", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.icon_delete:{
                Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarCajas() {
        nomAnimal.setText("");
        estConservacion.setText("");
        evoAnterior.setText("");
    }

    private void validacion() {
        String nombreAnimal = nomAnimal.getText().toString();
        String estadoCoservacion = estConservacion.getText().toString();
        String evolucionAnterior = evoAnterior.getText().toString();
        if(nombreAnimal.equals("")||estadoCoservacion.equals("")||evolucionAnterior.equals("")){
            nomAnimal.setError("Required");

        }

    }
}