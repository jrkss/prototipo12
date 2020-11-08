package com.mendez.prototipo1.modelo;

public class nuevo {
    String fecha;
    String clave;
    String nombre;
    String domicilio;
    String colonia;
    String telefono;
    String concepto;
    String monto;

    public nuevo() {
    }

    public nuevo(String fecha, String clave, String nombre, String domicilio, String colonia, String telefono, String concepto, String monto) {
        this.fecha = fecha;
        this.clave = clave;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.telefono = telefono;
        this.concepto = concepto;
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
