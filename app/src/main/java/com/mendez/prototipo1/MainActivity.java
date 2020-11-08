package com.mendez.prototipo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String contrAdmin;
    private EditText password;
    private TextView empleado;
    private Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.editTextNumber);
        empleado = findViewById(R.id.empleadoid);
        btn1 = findViewById(R.id.usuarioid);
        empleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ProtoEmpleado.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contra = "123456";
                String pass = password.getText().toString();

                if (pass.equals(contra)){
                    Intent intent =new Intent(MainActivity.this, ProtoAdmin.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Error, no ingreso la contraseña correcta",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}