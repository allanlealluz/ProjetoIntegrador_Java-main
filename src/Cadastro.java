import java.util.Scanner;

public class Cadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos alunos deseja cadastrar? ");
        int maxAlunos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Quantos funcionários deseja cadastrar? ");
        int maxFun = scanner.nextInt();
        scanner.nextLine();

        String[][] alunos = new String[maxAlunos][2];
        String[][] funcionarios = new String[maxFun][3];

        int numAlunos = 0;
        int numFuncionarios = 0;

        int opcao;
        do {
            System.out.println("\n--- Sistema de Cadastro ---");
            System.out.println("1. Cadastrar (Aluno ou Funcionário)");
            System.out.println("2. Buscar (Aluno ou Funcionário)");
            System.out.println("3. Listar (Aluno ou Funcionário)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastrar:");
                    System.out.println("1. Aluno");
                    System.out.println("2. Funcionário");
                    System.out.print("Escolha uma opção: ");
                    int tipoCadastro = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoCadastro == 1) {
                        if (numAlunos < maxAlunos) {
                            System.out.print("Digite o nome do aluno: ");
                            String nomeAluno = scanner.nextLine();
                            System.out.print("Digite a matrícula do aluno: ");
                            String matriculaAluno = scanner.nextLine();

                            alunos[numAlunos][0] = nomeAluno;
                            alunos[numAlunos][1] = matriculaAluno;
                            numAlunos++;

                            System.out.println("Aluno cadastrado com sucesso!");
                        } else {
                            
                            System.out.println("Número máximo de alunos atingido! ");
                        }
                    } else if (tipoCadastro == 2) {
                        if (numFuncionarios < maxFun) {
                            System.out.print("Digite o nome do funcionário: ");
                            String nomeFunc = scanner.nextLine();
                            System.out.print("Digite a matrícula do funcionário: ");
                            String matriculaFunc = scanner.nextLine();
                            System.out.print("Digite o cargo do funcionário: ");
                            String cargoFunc = scanner.nextLine();

                            funcionarios[numFuncionarios][0] = nomeFunc;
                            funcionarios[numFuncionarios][1] = matriculaFunc;
                            funcionarios[numFuncionarios][2] = cargoFunc;
                            numFuncionarios++;

                            System.out.println("Funcionário cadastrado com sucesso!");
                        } else {
                            System.out.println("Número máximo de funcionários atingido!");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("\nBuscar:");
                    System.out.println("1. Aluno");
                    System.out.println("2. Funcionário");
                    System.out.print("Escolha uma opção: ");
                    int tipoBusca = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoBusca == 1) {
                        System.out.println("1. Buscar por nome");
                        System.out.println("2. Buscar por matrícula");
                        System.out.print("Escolha uma opção: ");
                        int tipoBuscaAluno = scanner.nextInt();
                        scanner.nextLine();

                        if (tipoBuscaAluno == 1) {
                            System.out.print("Digite o nome do aluno para busca: ");
                            String nomeBuscaAluno = scanner.nextLine();
                            boolean encontradoPorNomeAluno = false;

                            for (int i = 0; i < numAlunos; i++) {
                                if (alunos[i][0].equalsIgnoreCase(nomeBuscaAluno)) {
                                    System.out.println("Aluno encontrado: Nome: " + alunos[i][0] + ", Matrícula: " + alunos[i][1]);
                                    encontradoPorNomeAluno = true;
                                    break;
                                }
                            }

                            if (!encontradoPorNomeAluno) {
                                System.out.println("Aluno não encontrado com esse nome.");
                            }
                        } else if (tipoBuscaAluno == 2) {
                            System.out.print("Digite a matrícula do aluno para busca: ");
                            String matriculaBuscaAluno = scanner.nextLine();
                            boolean encontradoPorMatriculaAluno = false;

                            for (int i = 0; i < numAlunos; i++) {
                                if (alunos[i][1].equals(matriculaBuscaAluno)) {
                                    System.out.println("Aluno encontrado: Nome: " + alunos[i][0] + ", Matrícula: " + alunos[i][1]);
                                    encontradoPorMatriculaAluno = true;
                                    break;
                                }
                            }

                            if (!encontradoPorMatriculaAluno) {
                                System.out.println("Aluno não encontrado com essa matrícula.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    } else if (tipoBusca == 2) {
                        System.out.println("1. Buscar por nome");
                        System.out.println("2. Buscar por matrícula");
                        System.out.print("Escolha uma opção: ");
                        int tipoBuscaFuncionario = scanner.nextInt();
                        scanner.nextLine();

                        if (tipoBuscaFuncionario == 1) {
                            System.out.print("Digite o nome do funcionário para busca: ");
                            String nomeBuscaFunc = scanner.nextLine();
                            boolean encontradoPorNomeFunc = false;

                            for (int i = 0; i < numFuncionarios; i++) {
                                if (funcionarios[i][0].equalsIgnoreCase(nomeBuscaFunc)) {
                                    System.out.println("Funcionário encontrado: Nome: " + funcionarios[i][0] + ", Matrícula: " + funcionarios[i][1] + ", Cargo: " + funcionarios[i][2]);
                                    encontradoPorNomeFunc = true;
                                    break;
                                }
                            }

                            if (!encontradoPorNomeFunc) {
                                System.out.println("Funcionário não encontrado com esse nome.");
                            }
                        } else if (tipoBuscaFuncionario == 2) {
                            System.out.print("Digite a matrícula do funcionário para busca: ");
                            String matriculaBuscaFunc = scanner.nextLine();
                            boolean encontradoPorMatriculaFunc = false;

                            for (int i = 0; i < numFuncionarios; i++) {
                                if (funcionarios[i][1].equals(matriculaBuscaFunc)) {
                                    System.out.println("Funcionário encontrado: Nome: " + funcionarios[i][0] + ", Matrícula: " + funcionarios[i][1] + ", Cargo: " + funcionarios[i][2]);
                                    encontradoPorMatriculaFunc = true;
                                    break;
                                }
                            }

                            if (!encontradoPorMatriculaFunc) {
                                System.out.println("Funcionário não encontrado com essa matrícula.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\nListar:");
                    System.out.println("1. Alunos");
                    System.out.println("2. Funcionários");
                    System.out.print("Escolha uma opção: ");
                    int tipoListagem = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoListagem == 1) {
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
                    } else if (tipoListagem == 2) {
                        if (numFuncionarios > 0) {
                            System.out.println("\n--- Lista de Todos os Funcionários ---");
                            System.out.printf("%-20s %-15s %-20s\n", "Nome", "Matrícula", "Cargo");
                            System.out.println("--------------------------------------------");
                            for (int i = 0; i < numFuncionarios; i++) {
                                System.out.printf("%-20s %-15s %-20s\n", funcionarios[i][0], funcionarios[i][1], funcionarios[i][2]);
                            }
                        } else {
                            System.out.println("Nenhum funcionário cadastrado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
