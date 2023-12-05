package org.example.model;

import java.util.Objects;

public class Departamento {

    private static  int autoIncrement = 1;

    private int id;

    private String nomeDepartamento;

    public Departamento() {
    }

    public Departamento(String nomeDepartamento) {
        this.id = autoIncrement++;
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
