package com.mendez.prototipo1.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mendez.prototipo1.R;
import com.mendez.prototipo1.modelo.nuevo;

public class nuevoAdapter extends FirebaseRecyclerAdapter<nuevo, com.mendez.prototipo1.controller.nuevoAdapter.nuevosViewholder> {

    public nuevoAdapter(
            @NonNull FirebaseRecyclerOptions<nuevo> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void onBindViewHolder(@NonNull nuevosViewholder holder,
                     int position, @NonNull nuevo model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.fecha.setText(model.getFecha());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.clave.setText(model.getClave());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.nombre.setText(model.getNombre());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.domicilio.setText(model.getDomicilio());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.colonia.setText(model.getColonia());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.telefono.setText(model.getTelefono());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.concepto.setText(model.getConcepto());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.monto.setText(model.getMonto());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")

    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public nuevosViewholder onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nuevo, parent, false);
        return new com.mendez.prototipo1.controller.nuevoAdapter.nuevosViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class nuevosViewholder extends RecyclerView.ViewHolder {
        TextView fecha, clave, nombre, domicilio, colonia, telefono, concepto, monto;
        public nuevosViewholder(@NonNull View itemView)
        {
            super(itemView);

            fecha = itemView.findViewById(R.id.fechaid);
            clave = itemView.findViewById(R.id.claveid);
            nombre = itemView.findViewById(R.id.nombreid);
            domicilio = itemView.findViewById(R.id.domicilioid);
            colonia = itemView.findViewById(R.id.coloniaid);
            telefono = itemView.findViewById(R.id.telefonoid);
            concepto = itemView.findViewById(R.id.conceptoid);
            monto = itemView.findViewById(R.id.montoid);

        }
    }
}