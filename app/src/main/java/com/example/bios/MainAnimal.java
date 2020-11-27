package com.example.bios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bios.dex.Animal;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

//main administrador?

public class MainAnimal extends AppCompatActivity {

    EditText nomA, estC, evolA, loc, longiA, pesoA, anat, dif, element, diet;
    ListView listV_animales;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animal);

        nomA = findViewById(R.id.txt_nombreAnimal);
        estC = findViewById(R.id.txt_estadoConservacion);
        evolA = findViewById(R.id.txt_evolucionAnterior);
        loc = findViewById(R.id.txt_locacion);
        longiA = findViewById(R.id.txt_pesoAproximado);
        pesoA = findViewById(R.id.txt_pesoAproximado);
        anat = findViewById(R.id.txt_anatomia);
        dif = findViewById(R.id.txt_diformismo);
        element = findViewById(R.id.txt_elementoBios);
        diet = findViewById(R.id.txt_dieta);

        listV_animales = findViewById(R.id.lv_datosAnimales);
        inicializarFirebase();//siempre de primero

        //continua despues de aqui
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String nombreAnimal = nomA.getText().toString();
        String estadoConservacion = estC.getText().toString();
        String evolucion = evolA.getText().toString();
        String locacion = loc.getText().toString();
        String longitudAprox = longiA.getText().toString();
        String pesoAprox = pesoA.getText().toString();
        String anatomia = anat.getText().toString();
        String diformismo = dif.getText().toString();
        String elementBios = element.getText().toString();
        String dieta = diet.getText().toString();

        switch (item.getItemId()){
            case R.id.icon_add:{
                Toast.makeText(this,"Agregar", Toast.LENGTH_LONG).show();
                if (nombreAnimal.equals("")||estadoConservacion.equals("")||evolucion.equals("")||locacion.equals("")||longitudAprox.equals("")||pesoAprox.equals("")||anatomia.equals("")||diformismo.equals("")||elementBios.equals("")||dieta.equals("")){
                    validacion();
                }
                else {
                    //Instancia
                    Animal animal = new Animal(nombreAnimal,estadoConservacion,evolucion,locacion,longitudAprox,pesoAprox,anatomia,diformismo,elementBios,dieta);
                    animal.setNombreAnimal(nombreAnimal);
                    animal.setEstConservacion(estadoConservacion);
                    animal.setEvolucionAnterior(evolucion);
                    animal.setLocacion(locacion);
                    animal.setLongitudAprox(longitudAprox);
                    animal.setPesoAprox(pesoAprox);
                    animal.setAnatomia(anatomia);
                    animal.setDiformismo(diformismo);
                    animal.setElementoBios(elementBios);
                    animal.setDieta(dieta);
                    //nombre como identificador en base de datos
                    databaseReference.child("Animal").child(animal.getNombreAnimal()).setValue(animal);     //se crea en firebase un nodo llamado animal, dentro de ese nodo, se va a tener como principal el nombreAnimal, algo el id
                    Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_save:{
                Toast.makeText(this,"Guardar", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.icon_delete:{
                Toast.makeText(this,"Eliminar", Toast.LENGTH_LONG).show();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarCajas() {

        nomA.setText("");
        estC.setText("");
        evolA.setText("");
        loc.setText("");
        longiA.setText("");
        pesoA.setText("");
        anat.setText("");
        dif.setText("");
        element.setText("");
        diet.setText("");
    }

    private void validacion() {

        String nombreAnimal = nomA.getText().toString();
        String estadoConservacion = estC.getText().toString();
        String evolucion = evolA.getText().toString();
        String locacion = loc.getText().toString();
        String longitudAprox = longiA.getText().toString();
        String pesoAprox = pesoA.getText().toString();
        String anatomia = anat.getText().toString();
        String diformismo = dif.getText().toString();
        String elementBios = element.getText().toString();
        String dieta = diet.getText().toString();
        if (nombreAnimal.equals("")){
            nomA.setError("Required");
        }
        else if (estadoConservacion.equals("")){
            estC.setError("Required");
        }
        else if (evolucion.equals("")){
            evolA.setError("Required");
        }
        else if (locacion.equals("")){
            loc.setError("Required");
        }
        else if (longitudAprox.equals("")){
            longiA.setError("Required");
        }
        else if (pesoAprox.equals("")){
            pesoA.setError("Required");
        }
        else if (anatomia.equals("")){
            anat.setError("Required");
        }
        else if (diformismo.equals("")){
            dif.setError("Required");
        }
        else if (elementBios.equals("")){
            element.setError("Required");
        }
        else if (dieta.equals("")){
            diet.setError("Required");
        }

    }

}