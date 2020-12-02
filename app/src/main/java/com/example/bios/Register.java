package com.example.bios;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bios.dex.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Register extends MainActivity {
    private FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private EditText nombre;
    private EditText contrasenaConfirmar;
    private EditText rol;
    private Button registro;

    private String name;
    private String password;
    private String confirPassword;
    private String Email;
    private String Rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       nombre = (EditText) findViewById(R.id.nombre);
        correo = (EditText) findViewById(R.id.correo);
        contrasena = (EditText) findViewById(R.id.contrasena);
        contrasenaConfirmar = (EditText) findViewById(R.id.contrasenaConfirmar);
        rol = (EditText) findViewById(R.id.rol);
        registro = (Button) findViewById(R.id.registroBtn);
        inicializarFirebase();
        mAuth = FirebaseAuth.getInstance();


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             name = nombre.getText().toString();
             Email = correo.getText().toString();
             password = contrasena.getText().toString();
             confirPassword = contrasenaConfirmar.getText().toString();
             Rol = rol.getText().toString();

             if(!name.isEmpty() && !password.isEmpty() && !confirPassword.isEmpty() && !Email.isEmpty() && !Rol.isEmpty()){
                if(password.length() >= 6){
                      if(password.equals(confirPassword)){
                          registerUser();
                         } else{
                          Toast.makeText(Register.this, "las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                      }
                } else{
                    Toast.makeText(Register.this, "El password debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
                }

             } else{
                 validacion ();
             }
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(Email ,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  Usuario us = new Usuario(name, Email, password, Rol);
                  us.setNombre(name);
                  us.setCorreo(Email);
                  us.setPassword(password);
                  us.setRol(Rol);
                 Map<String, Object> map = new HashMap<>();
                  map.put("name", name);
                  map.put("Correo", Email);
                  map.put("password", password);
                  map.put("Rol", Rol);
                  String id = mAuth.getCurrentUser().getUid();


                  databaseReference.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task2) {
          if(task2.isSuccessful()){
              Toast.makeText(getApplicationContext(), "Usuario creado",
                      Toast.LENGTH_SHORT).show();
              Intent i = new Intent(getApplicationContext(), MainActivity.class);
              startActivity(i);
          } else{
              Toast.makeText(Register.this, "No se pudo guardar los datos", Toast.LENGTH_SHORT).show();
          }
    }
});
              } else{
                  Toast.makeText(Register.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }


    private void validacion () {
        name = nombre.getText().toString();
        password = contrasena.getText().toString();
        confirPassword = contrasenaConfirmar.getText().toString();
        Email = correo.getText().toString();
        Rol = rol.getText().toString();

        if(name.equals("")){
            nombre.setError("Required");
        }
        else if (Email.equals("")){
            correo.setError("Required");
        }
        else if (password.equals("")){
            contrasena.setError("Required");
        } else if (confirPassword.equals("")){
            contrasenaConfirmar.setError("Required");
        } else if(Rol.equals("")){
            rol.setError("Required");
        }
    }


}

/*    private void initQRCode() {
        String nombreAnimal = "Nombre del Animal: " + nomA.getText().toString();
        String estadoConservacion = "Estado de conservación: " + estC.getText().toString();
        String evolucion = "Evolución anterior: " + evolA.getText().toString();
        String locacion = "Locación: " + loc.getText().toString();
        String longitudAprox = "Longitud Aproximada: " + longiA.getText().toString();
        String pesoAprox = "Peso Aproximado: " + pesoA.getText().toString();
        String anatomia = "Anatomia: " + anat.getText().toString();
        String diformismo = "Anatomia: " + dif.getText().toString();
        String elementBios = "Elemento Bios: " + element.getText().toString();
        String dieta = "Dieta: " + diet.getText().toString();


        StringBuilder textToSend = new StringBuilder();
        textToSend.append(nombreAnimal + " | " + estadoConservacion + " | " + evolucion + " | " + locacion + " | " + longitudAprox + " | " + pesoAprox + " | " + anatomia + " | " + diformismo + " | " + elementBios + " | " + dieta);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(textToSend.toString(), BarcodeFormat.QR_CODE, 600, 600);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
            imageView.setVisibility(View.VISIBLE);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }*/