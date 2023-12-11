package com.example.contador;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

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
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        myDB = new DataBaseHelper(LoginActivity.this);
    }

    public void irRegistro(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
        finish();
    }

    public void login(View view) {
        Cursor cursor = myDB.getUser(usuarioTxt.getText().toString());
        if (cursor.getCount() > 0) {
            cursor.moveToNext();
            if (!cursor.getString(7).equals(Password.getText().toString())) {
                Toast.makeText(this, "Contraseña erronea", Toast.LENGTH_SHORT).show();
                Password.setText("");
            } else {
                user = new User(
                        cursor.getString(1),
//                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getString(6),
                        cursor.getString(7));
                Intent in = new Intent(this, MainActivity.class);
                in.putExtra("USER", user);
                startActivity(in);
                finish();
            }

        } else Toast.makeText(this, "usurio incorrecto", Toast.LENGTH_SHORT).show();
    }
}

