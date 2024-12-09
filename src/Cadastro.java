import java.io.*;
import java.util.Scanner;

public class Cadastro {

    private static int proximoIdAluno = 1;
    private static int proximoIdFuncionario = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String caminhoAlunos = "src/alunos.txt";
        String caminhoFuncionarios = "src/funcionarios.txt";

        carregarUltimosIds(caminhoAlunos, caminhoFuncionarios);

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
                        String idAluno = String.valueOf(proximoIdAluno++);
                        System.out.print("Digite o nome do aluno: ");
                        String nomeAluno = scanner.nextLine();
                        System.out.print("Digite a matrícula do aluno: ");
                        String matriculaAluno = scanner.nextLine();
                        salvarAluno(idAluno, matriculaAluno, nomeAluno, caminhoAlunos);
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else if (tipoCadastro == 2) {
                        String idFunc = String.valueOf(proximoIdFuncionario++);
                        System.out.print("Digite o nome do funcionário: ");
                        String nomeFunc = scanner.nextLine();
                        System.out.print("Digite a matrícula (NIT) do funcionário: ");
                        String nitFunc = scanner.nextLine();
                        System.out.print("Digite o cargo do funcionário: ");
                        String cargoFunc = scanner.nextLine();
                        salvarFuncionario(idFunc, nitFunc, cargoFunc, nomeFunc, caminhoFuncionarios);
                        System.out.println("Funcionário cadastrado com sucesso!");
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
                        System.out.print("Digite o ID ou a matrícula do aluno: ");
                        String buscaAluno = scanner.nextLine();
                        buscarAluno(buscaAluno, caminhoAlunos);
                    } else if (tipoBusca == 2) {
                        System.out.print("Digite o ID ou a matrícula do funcionário: ");
                        String buscaFuncionario = scanner.nextLine();
                        buscarFuncionario(buscaFuncionario, caminhoFuncionarios);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\nListar:");
                    System.out.println("1. Alunos");
                    System.out.println("2. Funcionários");
                    System.out.print("Escolha uma opção: ");
                    int tipoLista = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoLista == 1) {
                        listarAlunos(caminhoAlunos);
                    } else if (tipoLista == 2) {
                        listarFuncionarios(caminhoFuncionarios);
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

    private static void carregarUltimosIds(String caminhoAlunos, String caminhoFuncionarios) {
        proximoIdAluno = carregarUltimoId(caminhoAlunos);
        proximoIdFuncionario = carregarUltimoId(caminhoFuncionarios);
    }

    private static int carregarUltimoId(String caminho) {
        int ultimoId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length > 0) {
                    int idAtual = Integer.parseInt(dados[0]);
                    if (idAtual > ultimoId) {
                        ultimoId = idAtual;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado: " + caminho);
        }
        return ultimoId + 1;
    }

    private static void salvarAluno(String id, String matricula, String nome, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(id + ";" + matricula + ";" + nome);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    private static void salvarFuncionario(String id, String nit, String cargo, String nome, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(id + ";" + nit + ";" + cargo + ";" + nome);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    private static void buscarAluno(String busca, String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean encontrado = false;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados[0].equals(busca) || dados[1].equals(busca)) {
                    System.out.println("Aluno encontrado:");
                    System.out.println("ID: " + dados[0]);
                    System.out.println("Matrícula: " + dados[1]);
                    System.out.println("Nome: " + dados[2]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Aluno não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
    }

    private static void buscarFuncionario(String busca, String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean encontrado = false;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados[0].equals(busca) || dados[1].equals(busca)) {
                    System.out.println("Funcionário encontrado:");
                    System.out.println("ID: " + dados[0]);
                    System.out.println("Matrícula (NIT): " + dados[1]);
                    System.out.println("Cargo: " + dados[2]);
                    System.out.println("Nome: " + dados[3]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Funcionário não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
    }

    private static void listarAlunos(String caminho) {
        System.out.println("\n--- Lista de Alunos ---");
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    System.out.println("ID: " + dados[0] + " | Matrícula: " + dados[1] + " | Nome: " + dados[2]);
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
    }

    private static void listarFuncionarios(String caminho) {
        System.out.println("\n--- Lista de Funcionários ---");
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                System.out.println("ID: " + dados[0] + " | Matrícula (NIT): " + dados[1] + " | Cargo: " + dados[2] + " | Nome: " + dados[3]);
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }
}
