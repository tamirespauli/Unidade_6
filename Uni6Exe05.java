/*
 * Com o objetivo de determinar o índice de afinidade entre um rapaz e uma moça cada um respondeu um questionário com 5 perguntas, como por exemplo:

Gosta de música sertaneja?
Gosta de futebol?
Gosta de seriados?
Gosta de redes sociais?
Gosta da Oktoberfest?
A resposta a cada pergunta pode ser: SIM, NÃO ou IND (indiferente). O índice de afinidade é medido da seguinte maneira:

se ambos deram a mesma resposta soma-se 3 pontos ao índice;
se um respondeu IND e o outro SIM ou NÃO soma-se 1;
se um respondeu SIM e o outro NÃO subtrai-se 2 ao índice.
Crie um vetor para armazenar as respostas do rapaz e outro para armazenar as respostas da moça. Crie um método que possa ler tanto as respostas do rapaz como da moça, e outro para calcular e retornar a afinidade. Por fim, escreva a afinidade considerando os seguintes intervalos:

Afinidade	Mensagem
15	“Casem!
10 a 14	“Vocês têm muita coisa em comum!”
5 a 9	“Talvez não dê certo :(”
0 a 4	“Vale um encontro.”
-1 a -9	“Melhor não perder tempo”
-10	“Vocês se odeiam!”

 */

import java.util.Scanner;

public class Uni6Exe05 {
    private Uni6Exe05() {
        Scanner teclado = new Scanner(System.in);

        // Vetores para armazenar as respostas do rapaz e da moça
        String[] respostasRapaz = new String[5];
        String[] respostasMoca = new String[5];

        // Leitura das respostas
        lerRespostas(respostasRapaz, respostasMoca, teclado);

        // Cálculo da afinidade
        int afinidade = calcularAfinidade(respostasRapaz, respostasMoca);

        // Exibição da mensagem de afinidade
        exibirMensagemAfinidade(afinidade);

        teclado.close();
    }

    // Método para ler as respostas do rapaz e da moça
    // Esse método lê as respostas de cada pergunta tanto para o rapaz quanto para a
    // moça. A resposta pode ser "SIM", "NÃO" ou "IND" (indiferente).
    // As respostas são armazenadas nos vetores respostasRapaz e respostasMoca.

    private void lerRespostas(String[] respostasRapaz, String[] respostasMoca, Scanner teclado) {
        System.out.println("Respostas do rapaz:");
        for (int i = 0; i < respostasRapaz.length; i++) {
            System.out.print("Pergunta " + (i + 1) + " (SIM, NÃO ou IND): ");
            respostasRapaz[i] = teclado.next().toUpperCase();
        }

        System.out.println("\nRespostas da moça:");
        for (int i = 0; i < respostasMoca.length; i++) {
            System.out.print("Pergunta " + (i + 1) + " (SIM, NÃO ou IND): ");
            respostasMoca[i] = teclado.next().toUpperCase();
        }
    }

    // Método para calcular a afinidade com base nas respostas
    // Se ambos deram a mesma resposta (SIM, NÃO ou IND), adiciona-se 3 pontos.
    // Se um deu "SIM" e o outro "NÃO", subtraem-se 2 pontos.
    // Se um deu "IND" e o outro "SIM" ou "NÃO", adiciona-se 1 ponto.
    private int calcularAfinidade(String[] respostasRapaz, String[] respostasMoca) {
        int afinidade = 0;

        for (int i = 0; i < respostasRapaz.length; i++) {
            if (respostasRapaz[i].equals(respostasMoca[i])) {
                if (respostasRapaz[i].equals("SIM") || respostasRapaz[i].equals("NÃO")) {
                    afinidade += 3; // Mesma resposta (SIM ou NÃO)
                } else if (respostasRapaz[i].equals("IND")) {
                    afinidade += 3; // Resposta IND para ambos
                }
            } else if ((respostasRapaz[i].equals("SIM") && respostasMoca[i].equals("NÃO")) ||
                    (respostasRapaz[i].equals("NÃO") && respostasMoca[i].equals("SIM"))) {
                afinidade -= 2; // Respostas opostas (SIM e NÃO)
            } else {
                // Resposta IND do rapaz e SIM ou NÃO da moça, ou vice-versa
                afinidade += 1;
            }
        }

        return afinidade;
    }

    // Método para exibir a mensagem de acordo com a afinidade calculada

    private void exibirMensagemAfinidade(int afinidade) {
        if (afinidade == 15) {
            System.out.println("Casem!");
        } else if (afinidade >= 10 && afinidade <= 14) {
            System.out.println("Vocês têm muita coisa em comum!");
        } else if (afinidade >= 5 && afinidade <= 9) {
            System.out.println("Talvez não dê certo :(");
        } else if (afinidade >= 0 && afinidade <= 4) {
            System.out.println("Vale um encontro.");
        } else if (afinidade >= -9 && afinidade <= -1) {
            System.out.println("Melhor não perder tempo");
        } else {
            System.out.println("Vocês se odeiam!");
        }
    }

    public static void main(String[] args) {
        new Uni6Exe05();
    }
}
