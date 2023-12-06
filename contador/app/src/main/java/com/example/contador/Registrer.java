package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrer extends AppCompatActivity {
    EditText usuarioTxt;
    EditText passwordTxt;
    EditText confirmPasword;
    Button registrerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        usuarioTxt = findViewById(R.id.passwordTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        confirmPasword = findViewById(R.id.confirmPasword);
        registrerButton = findViewById(R.id.registrerButton);
        registrerButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick (View v){
                DataBaseHelper myDB = new DataBaseHelper(Registrer.this);
                myDB.addUser(usuarioTxt.getText().toString().trim(), passwordTxt.getText().toString().trim());
            }
        });
    }
    public void irLogin(View v){
        Intent i = new Intent(this, login.class);
        startActivity(i);
        finish();
    }
}