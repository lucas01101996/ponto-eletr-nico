package org.example.model;

import java.util.Date;
import java.util.Objects;

public class RegistroPonto {

    private int id;
    private Funcionario funcionario;
    private Date dataHoraSaida;
    private Date dataHoraEntrada;


    public RegistroPonto(int id, Funcionario funcionario, Date dataHoraSaida, Date dataHoraEntrada) {
        this.id = id;
        this.funcionario = funcionario;
        this.dataHoraSaida = dataHoraSaida;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroPonto that = (RegistroPonto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
