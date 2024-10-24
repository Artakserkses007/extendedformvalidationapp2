package com.example.extendedformvalidationapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.extendedformvalidationapp.R;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText surname;
    private EditText email;
    private EditText phone;
    private EditText pass;
    private EditText passcheck;
    private Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        email = findViewById(R.id.editTextEmail);
        phone = findViewById(R.id.editPhone);
        pass = findViewById(R.id.editPass);
        passcheck = findViewById(R.id.editPassCheck);
        submit = findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String Name = name.getText().toString().trim();
                String Surname = surname.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Phone = phone.getText().toString().trim();
                String Pass = pass.getText().toString().trim();
                String check = passcheck.getText().toString().trim();

                if(Name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wpisać imię",Toast.LENGTH_SHORT).show();
                }
                if(Surname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wpisać nazwisko",Toast.LENGTH_SHORT).show();
                }
                else if(Email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wpisać email",Toast.LENGTH_SHORT).show();
                }
                else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    Toast.makeText(MainActivity.this, "Niepoprawny adres email",Toast.LENGTH_SHORT).show();
                }
                else if(Phone.isEmpty()|| Phone.length() < 9) {
                    Toast.makeText(MainActivity.this, "Niepoprawny numer telefonu", Toast.LENGTH_SHORT).show();
                }

                else if(Pass.isEmpty()|| Pass.length() < 6) {
                    Toast.makeText(MainActivity.this, "Proszę wpisać hasło które ma min. 6 znaków", Toast.LENGTH_SHORT).show();
                }
                else if(check.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę potwierzdzić hasło", Toast.LENGTH_SHORT).show();
                }
                else if(!Pass.equals(check)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są takie same", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}