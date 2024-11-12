/*
Faça um programa para ler os valores de dois vetores de inteiros, cada um contendo 10 elementos.
Crie um terceiro vetor em que cada elemento é a soma dos valores contidos nas posições respectivas dos vetores originais.
Por exemplo, vetor1 = [1,2,3] vetor2 = [1,5,6] vetor3 = [2,7,9]. Exiba, ao final, os três vetores na tela. Faça três métodos:
 um método para ler valores dos vetores, outro para somar e outro para escrever os vetores.
 */

import java.util.Scanner;

public class Uni6Exe04 {
    private Uni6Exe04() {
        Scanner teclado = new Scanner(System.in);

        int vetor1[] = new int[10]; // Primeiro vetor com 10 elementos
        int vetor2[] = new int[10]; // Segundo vetor com 10 elementos
        int vetor3[] = new int[10]; // Terceiro vetor para armazenar as somas dos vetores 1 e 2

        lerVetores(vetor1, vetor2, teclado); // Leitura dos valores para os dois vetores
        somarVetores(vetor1, vetor2, vetor3); // Soma dos valores nas posições correspondentes
        escreverVetores(vetor1, vetor2, vetor3); // Exibição dos três vetores

        teclado.close();
    }

    // Método para ler os valores dos dois vetores
    private void lerVetores(int vetor1[], int vetor2[], Scanner teclado) {
        System.out.println("Digite os valores do primeiro vetor:");
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print("vetor1[" + i + "]: ");
            vetor1[i] = teclado.nextInt();
        }

        System.out.println("\nDigite os valores do segundo vetor:");
        for (int i = 0; i < vetor2.length; i++) {
            System.out.print("vetor2[" + i + "]: ");
            vetor2[i] = teclado.nextInt();
        }
    }

    // Método para somar os valores das posições correspondentes dos dois vetores e
    // armazenar no terceiro vetor
    // Esse método realiza a soma dos valores nas posições correspondentes de vetor1
    // e vetor2.
    // O resultado é armazenado no vetor vetor3.
    private void somarVetores(int vetor1[], int vetor2[], int vetor3[]) {
        for (int i = 0; i < vetor1.length; i++) {
            vetor3[i] = vetor1[i] + vetor2[i];
        }
    }

    // Método para exibir os três vetores
    private void escreverVetores(int vetor1[], int vetor2[], int vetor3[]) {
        System.out.println("\nValores do primeiro vetor:");
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("vetor1[" + i + "]: " + vetor1[i]);
        }

        System.out.println("\nValores do segundo vetor:");
        for (int i = 0; i < vetor2.length; i++) {
            System.out.println("vetor2[" + i + "]: " + vetor2[i]);
        }

        System.out.println("\nValores do terceiro vetor (soma dos dois primeiros):");
        for (int i = 0; i < vetor3.length; i++) {
            System.out.println("vetor3[" + i + "]: " + vetor3[i]);
        }
    }

    public static void main(String[] args) {
        new Uni6Exe04();
    }
}

// /n --> quebra pagina