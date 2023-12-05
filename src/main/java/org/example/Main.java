package org.example;


import org.example.model.Cargo;
import org.example.model.Departamento;
import org.example.model.Funcionario;
import org.example.model.RegistroPonto;
import org.example.service.FuncionarioService;
import org.example.service.RegistroPontoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        FuncionarioService funcionarioService = new FuncionarioService();
        RegistroPontoService registroPontoService = new RegistroPontoService();
        List<Funcionario> funcionarioList = new ArrayList<>();
        List<RegistroPonto> registroPontoList = new ArrayList<>();
        String nomeFuncionario = null;
        Funcionario funcionario = new Funcionario();

        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Remover Funcionário por Nome");
            System.out.println("3. Imprimir Lista de Funcionários");
            System.out.println("4. Atualizar Funcionário");
            System.out.println("5. Buscar Funcionário por nome");
            System.out.println("6. Registrar Ponto");
            System.out.println("7. Consultar Ponto Diário por Funcionário");
            System.out.println("8. Listar Horas Trabalhadas por Funcionário");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
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
                    scanner.nextLine();
                    System.out.println("Informe o nome do funcionário a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    Funcionario funcionarioAtualizado = new Funcionario();
                    funcionarioService.atualizarFuncionario(nomeAtualizar, funcionarioAtualizado, funcionarioList);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Informe o nome do funcionário:");
                    nomeFuncionario = scanner.nextLine();
                    funcionarioService.obterFuncionarioPorNome(nomeFuncionario, funcionarioList);
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Informe o nome do funcionário:");
                    nomeFuncionario = scanner.nextLine();
                    funcionario= registroPontoService.obterFuncionarioPorNome(nomeFuncionario, funcionarioList);
                    Date dataEntrada = new Date();
                    if (funcionario!=null){
                        registroPontoService.registrarPonto(funcionario, dataEntrada, registroPontoList);
                    }else {
                        System.out.println("Não existe esse funcionário");
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("Informe o nome do funcionário:");
                    nomeFuncionario = scanner.nextLine();
                    Funcionario funcionario12 = registroPontoService.obterFuncionarioPorNome(nomeFuncionario, funcionarioList);
                    registroPontoService.consultarPontoPorFuncionario(funcionario12,  registroPontoList);
                    break;

                case 8:
                    scanner.nextLine();
                    System.out.println("Informe o nome do funcionário:");
                    nomeFuncionario = scanner.nextLine();
                    funcionario = registroPontoService.obterFuncionarioPorNome(nomeFuncionario, funcionarioList);
                    RegistroPonto registroPonto = registroPontoService.obterRegistro(nomeFuncionario,registroPontoList);
                    if (funcionario!=null && registroPonto!=null && registroPonto.getDataHoraSaida()!=null){
                        registroPontoService.listarHorasTrabalhadasPorFuncionario(funcionario, registroPonto);
                    }else {
                        System.out.println("Não existe registro para esse funcionário");
                    }
                    break;
                case 9:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }


}
