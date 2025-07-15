package services;

import models.Cliente;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class SistemaEsmalteria {
    private final Scanner sc;
    private final List<Cliente> agendamentos;

    public SistemaEsmalteria() {
        sc = new Scanner(System.in);
        agendamentos = new ArrayList<>();
    }

        public void menuSisters() {
            int opcao;

            do {
                System.out.println("\n==== MENU ESMALTERIA ====\n");
                System.out.println("1. Agendar Cliente");
                System.out.println("2. Cancelar Agendamento ");
                System.out.println("3. Ver Agendamentos");
                System.out.println("4. Sair ");
                System.out.println("\nEscolha uma opção: ");
                
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case (1):
                        agendarCliente();
                            break;
                    case (2):
                        cancelarAgendamento();
                            break;
                    case (3):
                        listarAgendamentos();
                            break;
                    case (4):
                        encerrarPrograma();
                        break;
                    default:
                        System.out.println("Opção inválida!!");
                            return;
                }
            } while (opcao != 4);
        }

        private void agendarCliente() {
            System.out.println("\n---Menu de  Agendamento---");
            System.out.println("Nome da(o) Cliente: ");
            String nome = sc.nextLine();
            System.out.println("Data do agendamento: ");
            String data = sc.nextLine();
            System.out.println("Hora do agendamento: ");
            String hora = sc.nextLine();

            agendamentos.add(new Cliente(nome, data, hora));
            System.out.println("\nAgendamento realizado com sucesso.");

        }

        private void cancelarAgendamento() {
            System.out.println("Informe o nome da cliente que deseja remover: ");
            String nome = sc.nextLine();

            boolean removida = agendamentos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));

            if (removida) {
                System.out.println("Agendamento cancelado com sucesso.");
            }else {
                System.out.println("Cliente não encontrada(o)");
            }
        }

        private void listarAgendamentos() {

            System.out.println("\nLista de Agendamentos:");
            if (agendamentos.isEmpty()) {
                System.out.println("Nenhum agendamento encontrado.");

            } else {

                agendamentos.sort((c1, c2) -> c1.getData().compareToIgnoreCase(c2.getData()));

                for (Cliente cliente : agendamentos) {
                    System.out.println(cliente);

                }
            }
        }

        private void encerrarPrograma() {

            System.out.println("Saindo...");
            sc.close();
    }
}
