package org.example.model;

import java.util.Objects;

public class Funcionario {
    private static  int autoIncrement = 1;

    private int id;
    private String name;
    private Cargo cargo;
    private Departamento departamento;

    public Funcionario(String name) {
        this.id = autoIncrement++;
        this.name = name;
    }

    public Funcionario(int id, String name, Cargo cargo, Departamento departamento) {
        this.id = autoIncrement++;
        this.name = name;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Funcionario() {
        this.departamento = new Departamento();
        this.cargo = new Cargo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
