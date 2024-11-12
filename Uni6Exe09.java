
/*
Um cinema pretende fazer uma pesquisa para avaliar o grau de satisfação de seus clientes. Trinta deles foram ouvidos e para cada um perguntou-se o sexo (1=feminino 2=masculino), uma nota para o cinema (zero até dez, valor inteiro) e a idade.

Baseado nisto faça um programa que informe:

qual a nota média recebida pelo cinema;
qual a nota média atribuída pelos homens;
qual a nota atribuída pela mulher mais jovem;
quantas das mulheres com mais de 50 anos deram nota superior a média recebida pelo cinema.
Utilize os conceitos aprendidos sobre vetores (ou mesmo o uso de matriz) e métodos para a resolução deste exercício.

 
 */
import java.util.Scanner;

public class Uni6Exe09 {
    private Uni6Exe09() {
        Scanner teclado = new Scanner(System.in);

        final int NUM_CLIENTES = 30;

        // Vetores para armazenar sexo (1= feminino, 2= masculino), nota e idade
        int sexo[] = new int[NUM_CLIENTES];
        int nota[] = new int[NUM_CLIENTES];
        int idade[] = new int[NUM_CLIENTES];

        // Ler os dados dos 30 clientes
        lerDados(sexo, nota, idade, teclado);

        // Calcular as métricas solicitadas
        double mediaCinema = calcularMedia(nota);
        double mediaHomens = calcularMediaHomens(sexo, nota);
        int notaMulherMaisJovem = notaMulherMaisJovem(sexo, nota, idade);
        int mulheresAcima50MaiorQueMedia = mulheresAcima50MaiorQueMedia(sexo, idade, nota, mediaCinema);

        // Exibir os resultados
        System.out.println("Nota média recebida pelo cinema: " + mediaCinema);
        System.out.println("Nota média atribuída pelos homens: " + mediaHomens);
        System.out.println("Nota atribuída pela mulher mais jovem: " + notaMulherMaisJovem);
        System.out.println(
                "Quantas mulheres com mais de 50 anos deram nota superior à média: " + mulheresAcima50MaiorQueMedia);

        teclado.close();
    }

    // Método para ler os dados dos 30 clientes
    private void lerDados(int sexo[], int nota[], int idade[], Scanner teclado) {
        for (int i = 0; i < sexo.length; i++) {
            System.out.print("Cliente " + (i + 1) + ":\n");
            System.out.print("Sexo (1= feminino, 2= masculino): ");
            sexo[i] = teclado.nextInt();
            System.out.print("Nota para o cinema (0 a 10): ");
            nota[i] = teclado.nextInt();
            System.out.print("Idade: ");
            idade[i] = teclado.nextInt();
            System.out.println();
        }
    }

    // Método para calcular a média de todas as notas dos clientes
    private double calcularMedia(int[] nota) {
        int soma = 0;
        for (int i = 0; i < nota.length; i++) {
            soma += nota[i];
        }
        return (double) soma / nota.length;
    }

    // Método para calcular a média das notas dadas pelos homens
    private double calcularMediaHomens(int[] sexo, int[] nota) {
        int soma = 0;
        int quantidadeHomens = 0;
        for (int i = 0; i < sexo.length; i++) {
            if (sexo[i] == 2) { // 2 significa masculino
                soma += nota[i];
                quantidadeHomens++;
            }
        }
        return quantidadeHomens > 0 ? (double) soma / quantidadeHomens : 0;
    }

    // Método para encontrar a nota da mulher mais jovem
    private int notaMulherMaisJovem(int[] sexo, int[] nota, int[] idade) {
        int notaMulherJovem = -1;
        int idadeMaisJovem = Integer.MAX_VALUE;
        for (int i = 0; i < sexo.length; i++) {
            if (sexo[i] == 1 && idade[i] < idadeMaisJovem) { // 1 significa feminino
                idadeMaisJovem = idade[i];
                notaMulherJovem = nota[i];
            }
        }
        return notaMulherJovem;
    }

    // Método para contar quantas mulheres com mais de 50 anos deram nota superior à
    // média
    private int mulheresAcima50MaiorQueMedia(int[] sexo, int[] idade, int[] nota, double mediaCinema) {
        int contador = 0;
        for (int i = 0; i < sexo.length; i++) {
            if (sexo[i] == 1 && idade[i] > 50 && nota[i] > mediaCinema) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        new Uni6Exe09();
    }
}