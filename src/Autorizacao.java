import java.util.Scanner;
import java.time.LocalTime;

public class Autorizacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxUsuarios = 5;
        String[][] usuarios = new String[maxUsuarios][2];

        usuarios[0][0] = "João";
        usuarios[0][1] = "12345";

        usuarios[1][0] = "Maria";
        usuarios[1][1] = "67890";

        usuarios[2][0] = "Carlos";
        usuarios[2][1] = "54321";

        usuarios[3][0] = "Ana";
        usuarios[3][1] = "98765";

        usuarios[4][0] = "Fernanda";
        usuarios[4][1] = "11223";

        int opcao;
        do {
            System.out.println("\n--- Sistema de Autorização ---");
            System.out.println("1. Validar matrícula");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a matrícula para validar: ");
                    String matriculaTag = scanner.nextLine();

                    if (validarAutorizacao(matriculaTag, usuarios)) {
                        System.out.println("Acesso autorizado!");
                        verificarAtraso();
                    } else {
                        System.out.println("Acesso negado! Matrícula não autorizada.");
                    }
                    break;

                case 2:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);

        scanner.close();
    }

    public static boolean validarAutorizacao(String matriculaTag, String[][] usuarios) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][1].equals(matriculaTag)) {
                return true;
            }
        }
        return false;
    }
    public static void verificarAtraso() {
        LocalTime limite = LocalTime.of(8, 15);
        LocalTime horarioAtual = LocalTime.now();
        if (horarioAtual.isAfter(limite)) {
            System.out.println("Você está atrasado! O horário limite era 08:15.");
        } else {
            System.out.println("Você não está atrasado.");
        }
    }
}
