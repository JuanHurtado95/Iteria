
package com.pruebatecnica.entity;


public class Cliente {
    
    int id;
    String primer_nombre;
    String segundo_nombre;
    String primer_apellido;
    String segundo_apellido;
    String num_contact; 

    public Cliente(){
    }
    
    public Cliente(String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String num_contact) {
        
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.num_contact = num_contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getNum_contact() {
        return num_contact;
    }

    public void setNum_contact(String num_contact) {
        this.num_contact = num_contact;
    }
    
    
    
}

