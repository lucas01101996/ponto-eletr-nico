package org.example.model;

import java.util.Objects;

public class Cargo {
    private static  int autoIncrement = 1;

    private int id;
    private String nomeCargo;

    public Cargo(String nomeCargo) {
        this.id = autoIncrement++;
        this.nomeCargo = nomeCargo;
    }

    public Cargo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return id == cargo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
