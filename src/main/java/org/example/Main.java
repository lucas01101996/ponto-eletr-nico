package org.example;


import org.example.model.Cargo;
import org.example.model.Departamento;
import org.example.model.Funcionario;
import org.example.service.FuncionarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();
        List<Funcionario> funcionarioList = new ArrayList<>();

        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Remover Funcionário por Nome");
            System.out.println("3. Imprimir Lista de Funcionários");
            System.out.println("4. Atualizar Funcionário");
            System.out.println("5. Buscar Funcionário por nome");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Funcionario funcionario = new Funcionario();
                    funcionarioService.cadastrarFuncionario(funcionario, funcionarioList);
                    break;
                case 2:
                    scanner.nextLine(); // Limpa o buffer antes de ler a próxima linha
                    System.out.println("Informe o nome do funcionário a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    funcionarioService.removerFuncionarioPorNome(nomeRemover, funcionarioList);
                    break;
                case 3:
                    funcionarioService.imprimirListaFuncionario(funcionarioList);
                    break;
                case 4:
                    scanner.nextLine(); // Limpa o buffer antes de ler a próxima linha
                    System.out.println("Informe o nome do funcionário a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    Funcionario funcionarioAtualizado = new Funcionario();

                    funcionarioService.atualizarFuncionario(nomeAtualizar, funcionarioAtualizado, funcionarioList);
                case 5:
                    scanner.nextLine();
                    System.out.println("Informe o nome do funcionário:");
                    String nomeFuncionario = scanner.nextLine();
                    funcionarioService.obterFuncionarioPorNome(nomeFuncionario, funcionarioList);
                case 6:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }


}
