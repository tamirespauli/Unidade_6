/*
 - Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base neste valor, crie um vetor do tipo inteiro. 
Em seguida, solicite ao usuário para digitar um número inteiro várias vezes, até preencher o vetor. Esse número deverá ser armazenado
no vetor caso ainda não exista, e se o valor já existir deve ser pedido um novo valor. Isto é, se o usuário informar o número 2 e já 
existir o número 2 em alguma posição do vetor, o número não deve ser adicionado. Após ter adicionado todos os números dentro do vetor,
 o mesmo deve ser ordenado. Para isso reordene os elementos internos do vetor de modo que este fique em ordem crescente, conforme no exemplo:

Vetor origem: [0][4][2][6][3]
Vetor ordenado: [0][2][3][4][6]

Crie um método para inserir os valores no vetor, outro para ordenar o vetor e outro para informar o vetor resultante.
Para "método ordenar" se pode usar o "método bolha" explicado neste vídeo
 */

import java.util.Scanner;

public class Uni6Exe07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura do valor N, que limita o tamanho do vetor
        System.out.print("Digite o valor de N (máximo 20): ");
        int N = sc.nextInt();

        // Garantir que o valor de N não ultrapasse 20
        if (N > 20) {
            System.out.println("O valor máximo permitido para N é 20.");
            return;
        }

        // Criando o vetor com N posições
        int[] vetor = new int[N];

        // Inserir os valores no vetor
        inserirValores(vetor, sc);

        // Ordenar o vetor usando o método bolha
        ordenarVetor(vetor);

        // Exibir o vetor ordenado
        exibirVetor(vetor);

        sc.close();
    }

    // Método para inserir valores no vetor
    public static void inserirValores(int[] vetor, Scanner sc) {
        int i = 0;
        while (i < vetor.length) {
            System.out.print("Digite um número inteiro para a posição " + i + ": ");
            int num = sc.nextInt();

            // Verificar se o número já existe no vetor
            if (jaExisteNoVetor(vetor, num)) {
                System.out.println("Número já existe no vetor. Tente novamente.");
            } else {
                // Se o número não existir, adiciona ao vetor
                vetor[i] = num;
                i++;
            }
        }
    }

    // Método para verificar se o número já existe no vetor
    public static boolean jaExisteNoVetor(int[] vetor, int num) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == num) {
                return true; // O número já existe
            }
        }
        return false; // O número não existe
    }

    // Método para ordenar o vetor utilizando o método bolha
    public static void ordenarVetor(int[] vetor) {
        int n = vetor.length;
        // Implementação do método bolha
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Trocar se o valor encontrado for maior que o próximo
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    // Método para exibir o vetor
    public static void exibirVetor(int[] vetor) {
        System.out.print("Vetor ordenado: [");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) {
                System.out.print("][");
            }
        }
        System.out.println("]");
    }
}