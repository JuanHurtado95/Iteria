
package com.pruebatecnica.entity;


public class Producto {
    
    int id;
    String nom_prod;
    String des_prod;
    String valor_prod;
    
    public Producto(){        
    }

    public Producto(String nom_prod, String des_prod, String valor_prod) {
        this.nom_prod = nom_prod;
        this.des_prod = des_prod;
        this.valor_prod = valor_prod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getDes_prod() {
        return des_prod;
    }

    public void setDes_prod(String des_prod) {
        this.des_prod = des_prod;
    }

    public String getValor_prod() {
        return valor_prod;
    }

    public void setValor_prod(String valor_prod) {
        this.valor_prod = valor_prod;
    }
    
    
    
}
