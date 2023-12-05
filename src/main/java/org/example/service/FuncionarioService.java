package org.example.service;

import org.example.model.Cargo;
import org.example.model.Departamento;
import org.example.model.Funcionario;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FuncionarioService {

    private static final Scanner scanner = new Scanner(System.in);



    public void cadastrarFuncionario(Funcionario funcionario, List<Funcionario> funcionarios){
        System.out.println("Informe o nome do funcionário");
        String nome = scanner.nextLine();
        funcionario.setName(nome);
        System.out.println("Informe o cargo do funcionário");
        String nomeCargo = scanner.nextLine();
        Cargo cargo = new Cargo(nomeCargo);
        funcionario.setCargo(cargo);
        System.out.println("Informe o departamento do funcionário");
        String nomeDepartamento = scanner.nextLine();
        Departamento departamento = new Departamento(nomeDepartamento);
        funcionario.setDepartamento(departamento);


        funcionarios.add(funcionario);
    }

    public void obterFuncionarioPorNome(String nomeFuncionario, List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (f.getName().equals(nomeFuncionario)) {
                System.out.println("Nome: " + f.getName());
                System.out.println("Departamento: " + f.getDepartamento().getNomeDepartamento());
                System.out.println("Cargo: " + f.getCargo().getNomeCargo());

            }
        }
        System.out.println("Funcionário com o nome '" + nomeFuncionario + "' não encontrado");
    }

    public void atualizarFuncionario(String nomeAntigo, Funcionario funcionarioAtualizado, List<Funcionario> funcionarios) {
        System.out.println("----- Atualizar Funcionário -----");
        System.out.print("Informe o nome do funcionário a ser atualizado: ");

        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario func = iterator.next();
            if (func.getName().equals(nomeAntigo)) {
                // Atualiza as informações do funcionário
                func.setName(funcionarioAtualizado.getName());
                func.setCargo(funcionarioAtualizado.getCargo());
                func.setDepartamento(funcionarioAtualizado.getDepartamento());

                System.out.println("Funcionário " + nomeAntigo + " atualizado com sucesso");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void removerFuncionarioPorNome(String nome, List<Funcionario> funcionarios) {
        System.out.println("----- Remover Funcionário por Nome -----");
        System.out.print("Informe o nome do funcionário a ser removido: ");

        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario func = iterator.next();
            if (func.getName().equals(nome)) {
                iterator.remove();
                System.out.println("Funcionário " + func.getName() + " removido com sucesso");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }


    public void imprimirListaFuncionario(List<Funcionario> funcionarioList){
        System.out.println("\n-------------Lista de Funcionários:---------------------");
        if (!funcionarioList.isEmpty()){
            for (Funcionario f : funcionarioList) {
                System.out.println("Nome: " + f.getName());
                System.out.println("Departamento: " + f.getDepartamento().getNomeDepartamento());
                System.out.println("Cargo: " + f.getCargo().getNomeCargo());
                System.out.println("-----------------------------------------------------");
            }
        }else{
            System.out.println("Não existem funcionários no sistema");
        }

    }

}
