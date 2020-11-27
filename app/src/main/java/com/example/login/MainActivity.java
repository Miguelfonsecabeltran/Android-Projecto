package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText contrasena;
    private EditText nombre;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("admin", "admin");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
        nombre = findViewById(R.id.nombre);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        String[] rol = {"Investigador","Administrador"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rol);
        spinner1.setAdapter(adapter);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


    public void registrarSesionBT(View view){
        Intent registrar = new Intent(this, Register.class);
        startActivity(registrar);
    }



    public void iniciarSesion(View view){
        String seleccion = spinner1.getSelectedItem().toString();
        mAuth.signInWithEmailAndPassword(correo.getText().toString().trim(), contrasena.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            if(seleccion.equals("Investigador")) {Toast.makeText(getApplicationContext(), "Authentication Correct",
                                    Toast.LENGTH_SHORT).show();
                                Intent i = new Intent( getApplicationContext(), Home.class);
                                startActivity(i); }else if(seleccion.equals("Administrador")){Toast.makeText(getApplicationContext(), "Authentication Correct",
                                    Toast.LENGTH_SHORT).show();
                                Intent i = new Intent( getApplicationContext(), MainAnimal.class);
                                startActivity(i);}









                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });

    }
}




