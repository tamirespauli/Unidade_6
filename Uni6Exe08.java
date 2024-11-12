/*
 Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base neste valor, crie um vetor do tipo real. 
 Faça o usuário informar valores para as posições deste vetor e coloque-as nas posições na sequência informada pelo usuário.
  Imprima uma tabela contendo cada valor diferente e o número de vezes que o valor aparece no vetor (veja exemplo a seguir). 
 */

import java.util.Scanner;

public class Uni6Exe08 {
    private Uni6Exe08() {
        Scanner teclado = new Scanner(System.in);

        // Limitar o tamanho do vetor a 20
        System.out.print("Informe o valor N (máximo 20): ");
        int N = teclado.nextInt();

        // Verificar se N é válido (entre 1 e 20)
        while (N < 1 || N > 20) {
            System.out.print("Valor inválido! Informe um valor entre 1 e 20: ");
            N = teclado.nextInt();
        }

        // Criar o vetor com N posições
        double[] vetor = new double[N];

        // Ler os valores para o vetor
        lerValores(vetor, teclado);

        // Exibir a tabela de contagem de valores
        exibirTabela(vetor);

        teclado.close();
    }

    // Método para ler os valores do vetor
    private void lerValores(double[] vetor, Scanner teclado) {
        System.out.println("Informe os valores para o vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Valor para posição " + i + ": ");
            vetor[i] = teclado.nextDouble();
        }
    }

    // Método para exibir a tabela de contagem de valores
    private void exibirTabela(double[] vetor) {
        boolean[] contados = new boolean[vetor.length]; // Para marcar se o valor já foi contado
        System.out.println("\nTabela de contagem de valores:");
        System.out.println("Valor\tContagem");

        // Contar e exibir os valores distintos
        for (int i = 0; i < vetor.length; i++) {
            if (!contados[i]) { // Se o valor ainda não foi contado
                int contagem = 0;
                // Contar quantas vezes o valor aparece no vetor
                for (int j = 0; j < vetor.length; j++) {
                    if (vetor[i] == vetor[j]) {
                        contagem++;
                    }
                }
                // Marcar o valor como contado
                contados[i] = true;

                // Exibir o valor e a contagem
                System.out.println(vetor[i] + "\t" + contagem);

                // Marcar todos os outros índices que tem o mesmo valor
                for (int k = i + 1; k < vetor.length; k++) {
                    if (vetor[i] == vetor[k]) {
                        contados[k] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Uni6Exe08();
    }
}