package com.mendez.prototipo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ProtoGasto extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText datebutton;
    private EditText editclave;
    private EditText editnombre;
    private EditText editmonto;
    private Button btnsave;

    private DatabaseReference mDatabase;

    private String fecha, clave, nombre, monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proto_gasto);
        datebutton = findViewById(R.id.etPlannedDate);
        editclave = findViewById(R.id.claveid);
        editnombre = findViewById(R.id.nombreid);

        editmonto = findViewById(R.id.totalid);
        btnsave = findViewById(R.id.btnsave);
        /////////////////////////////////////////////////////
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast));
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        //////////////////////////////////////////////////
        mDatabase = FirebaseDatabase.getInstance().getReference();

        datebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecha=datebutton.getText().toString();
                clave=editclave.getText().toString();
                nombre=editnombre.getText().toString();

                monto=editmonto.getText().toString();
                if (!fecha.isEmpty() && !clave.isEmpty() && !nombre.isEmpty() && !monto.isEmpty()){
                    saveData();
                    toast.show();
                }
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth +"/"+ month +"/"+ year;
        datebutton.setText(date);
    }


    private void saveData() {
        Map<String, Object> map = new HashMap<>();
        map.put("fecha", fecha);
        map.put("clave", clave);
        map.put("nombre", nombre);
        map.put("monto", monto);
        mDatabase.child("ProtoGasto").push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Intent i = new Intent(getApplicationContext(), ProtoGasto.class);
                    startActivity(i);
                    finish();

                }
            }
        });
    }
}