import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MAX_ALUNOS;

        System.out.println("Deseja cadastrar quantos alunos? ");
        MAX_ALUNOS = scanner.nextInt();
        scanner.nextLine();

        String[][] alunos = new String[MAX_ALUNOS][2]; 
        int numAlunos = 0;

        int opcao;
        do {
            // Menu de opções
            System.out.println("\n--- Sistema de Cadastro de Alunos ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Buscar aluno por nome");
            System.out.println("3. Buscar aluno por matrícula");
            System.out.println("4. Listar todos os alunos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (numAlunos < MAX_ALUNOS) {
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a matrícula do aluno: ");
                        String matricula = scanner.nextLine();

                        alunos[numAlunos][0] = nome;
                        alunos[numAlunos][1] = matricula;
                        numAlunos++;

                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Número máximo de alunos atingido!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do aluno para busca: ");
                    String nomeBusca = scanner.nextLine();
                    boolean encontradoPorNome = false;

                    for (int i = 0; i < numAlunos; i++) {
                        if (alunos[i][0].equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Aluno encontrado: Nome: " + alunos[i][0] + ", Matrícula: " + alunos[i][1]);
                            encontradoPorNome = true;
                            break;
                        }
                    }

                    if (!encontradoPorNome) {
                        System.out.println("Aluno não encontrado com esse nome.");
                    }
                    break;

                case 3:
                    System.out.print("Digite a matrícula do aluno para busca: ");
                    String matriculaBusca = scanner.nextLine();
                    boolean encontradoPorMatricula = false;

                    for (int i = 0; i < numAlunos; i++) {
                        if (alunos[i][1].equals(matriculaBusca)) {
                            System.out.println("Aluno encontrado: Nome: " + alunos[i][0] + ", Matrícula: " + alunos[i][1]);
                            encontradoPorMatricula = true;
                            break;
                        }
                    }

                    if (!encontradoPorMatricula) {
                        System.out.println("Aluno não encontrado com essa matrícula.");
                    }
                    break;

                case 4:
                    if (numAlunos > 0) {
                        System.out.println("\n--- Lista de Todos os Alunos ---");
                        System.out.printf("%-20s %-15s\n", "Nome", "Matrícula");
                        System.out.println("----------------------------------");
                        for (int i = 0; i < numAlunos; i++) {
                            System.out.printf("%-20s %-15s\n", alunos[i][0], alunos[i][1]);
                        }
                    } else {
                        System.out.println("Nenhum aluno cadastrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
