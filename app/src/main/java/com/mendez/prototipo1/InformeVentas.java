package com.mendez.prototipo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.mendez.prototipo1.controller.nuevoAdapter;
import com.mendez.prototipo1.modelo.nuevo;

public class InformeVentas extends AppCompatActivity {
    private RecyclerView recyclerView;
    nuevoAdapter adapter; // Create Object of the Adapter class
    DatabaseReference mbase; // Create object of the
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_ventas);
        recyclerView = findViewById(R.id.recycler);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<nuevo> options = new FirebaseRecyclerOptions.Builder<nuevo>()
                .setQuery(mbase, nuevo.class).build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new nuevoAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}