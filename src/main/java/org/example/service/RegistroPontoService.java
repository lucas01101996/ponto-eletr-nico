package org.example.service;

import org.example.model.Funcionario;
import org.example.model.RegistroPonto;

import java.util.Date;
import java.util.List;

public class RegistroPontoService {
    private List<RegistroPonto> registros;

    public void registrarPonto(Funcionario funcionario, Date dataHora, List<RegistroPonto> registros) {
        RegistroPonto registroPonto = obterRegistro(funcionario.getName(), registros);
        if (registroPonto!=null){
            registroPonto.setDataHoraSaida(dataHora);
        }else {
            registroPonto = new RegistroPonto(funcionario, dataHora,null);
        }
        registros.add(registroPonto);
        System.out.println("Ponto registrado para o funcionário " + registroPonto.getFuncionario().getName());
        System.out.println("Data/Hora de Entrada: " + registroPonto.getDataHoraEntrada());
        if (registroPonto.getDataHoraSaida()!=null){
            System.out.println("Data/Hora de Saída: " + registroPonto.getDataHoraSaida());
        }
        System.out.println("-------------------------");
    }

    public RegistroPonto obterRegistro(String nome, List<RegistroPonto> registros){
        for (RegistroPonto r: registros) {
            if (r.getFuncionario().getName().equals(nome)) {
                return r;
            }
        }
        return null;
    }


    public Funcionario obterFuncionarioPorNome(String nomeFuncionario, List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (f.getName().equals(nomeFuncionario)) {
                return f;
            }else {
                System.out.println("Funcionário com o nome '" + nomeFuncionario + "' não encontrado");
            }
        }
        return null;
    }

    public void consultarPontoPorFuncionario(Funcionario funcionario, List<RegistroPonto> registros ) {
        System.out.println("----- Consultar Ponto Diário -----");
        for (RegistroPonto registro : registros) {
            if (registro.getFuncionario().equals(funcionario)) {
                System.out.println("ID do Registro: " + registro.getId());
                System.out.println("Data/Hora de Entrada: " + registro.getDataHoraEntrada());
                if (registro.getDataHoraSaida()!=null){
                    System.out.println("Data/Hora de Saída: " + registro.getDataHoraSaida());
                }
                System.out.println("-------------------------");
            }
        }
    }

    public void listarHorasTrabalhadasPorFuncionario(Funcionario funcionario, RegistroPonto  registroPonto) {
        System.out.println("----- Listar Horas Trabalhadas -----");
        int totalHorasTrabalhadas = 0;

        if (registroPonto.getFuncionario().equals(funcionario)) {
            long diferencaEmMillis = registroPonto.getDataHoraSaida().getTime() - registroPonto.getDataHoraEntrada().getTime();
            int horasTrabalhadas = (int) (diferencaEmMillis / (60 * 60 * 1000));
            totalHorasTrabalhadas += horasTrabalhadas;
        }
        System.out.println("Total de horas trabalhadas por " + funcionario.getName() + ": " + totalHorasTrabalhadas + " horas");
    }
}
