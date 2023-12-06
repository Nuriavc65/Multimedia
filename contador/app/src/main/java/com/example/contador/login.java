package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.intellij.lang.annotations.JdkConstants;

import javax.security.auth.login.LoginException;

public class login extends AppCompatActivity {

    EditText usuarioTxt;
    EditText Password;
    Button registrerButton;
    Button loginButtom;
    DataBaseHelper myDB;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioTxt = findViewById(R.id.usuarioTxt);
        Password = findViewById(R.id.Password);
        loginButtom = findViewById(R.id.loginButtom);
        registrerButton = findViewById(R.id.registrerButton);
        registrerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this ,Registrer.class);
                startActivity(i);
            }
        });
        myDB = new DataBaseHelper(login.this);
    }
    public void irRegirstro (View view){
        Cursor cursor = myDB.getUser(usuarioTxt.getText().toString());
        if(cursor.getCount() > 0){
            cursor.moveToNext();
            if(!cursor.getString(1).equals(Password.getText().toString())){
                Toast.makeText(this, "Contraseña erronea" , Toast.LENGTH_SHORT).show();
                Password.setText("");
            }else{
                user = new User(
                        cursor.getString(0),
                        cursor.getString(1));
                Intent in = new Intent(this, MainActivity.class);
                in.putExtra("USER", user);
                startActivity(in);
                finish();
            }

        }else
            Toast.makeText(this,"usurio incorrecto" ,Toast.LENGTH_SHORT).show();
    }
}

