/*
Dado um vetor de números inteiros, com capacidade limitada a 50 elementos, faça um programa que construa um menu com as seguintes opções:

“1 – Incluir valor”: nesta opção inclua o valor no fim do vetor, se houver espaço. Informe o usuário se o valor foi incluído no vetor ou não;
“2 – Pesquisar valor”: nesta opção leia um valor e informe se o mesmo está no vetor;
“3 – Alterar valor”: nesta opção informe um número a ser alterado e um novo número a ser colocado no lugar (só para a primeira ocorrência deste número). Caso o número a ser alterado exista no vetor, substitua-o pelo novo número. Caso contrário, informe “número não encontrado”;
“4 – Excluir valor”: nesta opção leia um valor e, caso ele esteja no vetor, exclua-o. Informe o usuário se o valor foi excluído do vetor ou não. A posição que foi excluída o valor deve ser preenchida pelo valor seguinte, sucessivamente até o final dos valores do vetor;
“5 – Mostrar valores”: nesta opção mostre todos os valores armazenados no vetor;
“6 – Ordenar valores”: ordene todos os valores do vetor em ordem crescente;
“7 – Inverter valores”: desafio (ver abaixo);
“8 – Sair do sistema”: nesta opção deve ser finalizada a execução do programa.
Faça um método para cada uma das opções do menu. O menu deve-se repetir até que o usuário escolha a opção 8.
Para a opção "6 - Ordenar valores" se pode usar o "método bolha" explicado neste vídeo. Existem também outros vídeos que mostram a lógica de ordenação usando o "método bolha", no caso é só procurar por "Bubble Sort". Um deles é Bubble Sort | GeeksforGeeks. Um outro um pouco mais "divertido" procura mostrar a lógica usando uma coreografia de dança: Bubble sort with Hungarian, folk dance. E, por fim, tem uma forma interativa e visual com explicação em: https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/.

Desafio: adapte o código acima para ter mais uma opção no menu para também poder inverter os elementos dentro de um vetor. Assim o último elemento passa a ser o primeiro, o penúltimo passa ser o segundo, e assim sucessivamente para todos os elementos da lista. Mas lembre, não se deve considerar o vetor inteiro, mas somente os elementos que já foram adicionados no vetor. Como base use o código descrito em vetorInverter.java. 
 */

import java.util.Scanner;

public class Uni6Exe10 {
    private Uni6Exe10() {
        Scanner teclado = new Scanner(System.in);
        int vet[] = new int[50]; // Vetor com capacidade para 50 elementos
        int posFinal = 0; // Variável que controla a posição final do vetor

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir valor");
            System.out.println("2 - Pesquisar valor");
            System.out.println("3 - Alterar valor");
            System.out.println("4 - Excluir valor");
            System.out.println("5 - Mostrar valores");
            System.out.println("6 - Ordenar valores");
            System.out.println("7 - Inverter valores");
            System.out.println("8 - Sair do sistema");
            System.out.print("Opção: ");
            opcao = teclado.nextInt();

            // Menu
            switch (opcao) {
                case 1: // 1 Incluir valor
                    posFinal = vetIncluir_1(vet, teclado, posFinal);
                    break;
                case 2: // 2 Pesquisar valor
                    if (vetPesquisa_2(vet, teclado, posFinal))
                        System.out.println("Valor encontrado!");
                    else
                        System.out.println("Valor não encontrado!");
                    break;
                case 3: // 3 Alterar valor
                    vetAlterar_3(vet, teclado, posFinal);
                    break;
                case 4: // 4 Excluir valor
                    vetExcluir_4(vet, teclado, posFinal);
                    posFinal--; // Decrementa a posição final após exclusão
                    break;
                case 5: // 5 Mostrar valores
                    vetMostrar_5(vet, posFinal);
                    break;
                case 6: // 6 Ordenar valores
                    vetOrdenar_6(vet, posFinal);
                    break;
                case 7: // 7 Inverter valores
                    vetInverter_7(vet, posFinal);
                    break;
                case 8: // 8 Sair do sistema
                    System.out.println("Saindo do sistema!");
                    break;
                default:
                    System.out.println("Opção ERRADA!");
                    break;
            }
        } while (opcao != 8); // Fim

        teclado.close();
    }

    //Este método inclui um valor no final do vetor, desde que haja espaço:

    // Verifica se a posição posFinal está dentro do limite do vetor (50).
    // Solicita ao usuário o valor a ser incluído e o armazena na posição vet[posFinal].
    // Incrementa posFinal e informa que o valor foi incluído. Caso o vetor já esteja cheio, exibe uma mensagem informando isso.

    private int vetIncluir_1(int vet[], Scanner teclado, int posFinal) {
        if (posFinal < vet.length) {
            System.out.print("Informe o valor a ser incluído: ");
            int valor = teclado.nextInt();
            vet[posFinal] = valor;
            posFinal++;
            System.out.println("Valor incluído com sucesso!");
        } else {
            System.out.println("Vetor cheio!");
        }
        return posFinal;
    }

    // Este método pesquisa um valor no vetor:

    // Solicita o valor a ser pesquisado.
    // Percorre o vetor até a posição posFinal. Se encontrar o valor, retorna true; caso contrário, retorna false.

    private boolean vetPesquisa_2(int vet[], Scanner teclado, int posFinal) {
        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = teclado.nextInt();
        for (int i = 0; i < posFinal; i++) {
            if (vet[i] == valor) {
                return true; // Valor encontrado
            }
        }
        return false; // Valor não encontrado
    }

    // Este método altera um valor específico:

    // Solicita o valor antigo (a ser substituído) e percorre o vetor até a posição posFinal.
    // Se encontrar a primeira ocorrência do valor, solicita o novo valor e substitui o valor antigo.
    // Caso o valor antigo não seja encontrado, informa que o número não foi encontrado.

    private void vetAlterar_3(int vet[], Scanner teclado, int posFinal) {
        System.out.print("Informe o valor a ser alterado: ");
        int valorAntigo = teclado.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < posFinal; i++) {
            if (vet[i] == valorAntigo) {
                System.out.print("Informe o novo valor: ");
                int novoValor = teclado.nextInt();
                vet[i] = novoValor;
                encontrado = true;
                System.out.println("Valor alterado com sucesso!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Número não encontrado!");
        }
    }

    // Este método exclui um valor do vetor:

    // Solicita o valor a ser excluído e percorre o vetor até posFinal.
    // Se o valor for encontrado, os elementos à direita são deslocados uma posição para a esquerda, sobrepondo o valor excluído. A última posição é zerada e posFinal é decrementado.
    // Informa se o valor foi excluído com sucesso ou não encontrado.


    private void vetExcluir_4(int vet[], Scanner teclado, int posFinal) {
        System.out.print("Informe o valor a ser excluído: ");
        int valorExcluir = teclado.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < posFinal; i++) {
            if (vet[i] == valorExcluir) {
                for (int j = i; j < posFinal - 1; j++) {
                    vet[j] = vet[j + 1]; // Move os valores para preencher a lacuna
                }
                vet[posFinal - 1] = 0; // Zera o último valor
                encontrado = true;
                System.out.println("Valor excluído com sucesso!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Valor não encontrado!");
        }
    }

    // Exibe todos os valores armazenados no vetor:

    // Verifica se posFinal é zero. Se for, significa que o vetor está vazio.
    // Caso contrário, exibe os valores do vetor até a posição posFinal.

    private void vetMostrar_5(int vet[], int posFinal) {
        if (posFinal == 0) {
            System.out.println("Vetor vazio!");
        } else {
            System.out.println("Valores no vetor:");
            for (int i = 0; i < posFinal; i++) {
                System.out.println("vetor[" + i + "]: " + vet[i]);
            }
        }
    }

    // Este método ordena o vetor usando o algoritmo de Bubble Sort:

    // Compara pares de elementos adjacentes e troca-os se estiverem fora de ordem (para ordenação crescente).
    // O processo é repetido até que todos os elementos estejam ordenados.
    // É um algoritmo básico de ordenação e garante que todos os elementos fiquem em ordem crescente ao final.

    private void vetOrdenar_6(int vet[], int posFinal) {
        for (int i = 0; i < posFinal - 1; i++) {
            for (int j = 0; j < posFinal - i - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    // Troca de valores usando o método bolha
                    int temp = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = temp;
                }
            }
        }
        System.out.println("Valores ordenados com sucesso!");
    }

    // Este método inverte a ordem dos valores no vetor:

    // Usa dois ponteiros (inicio e fim) para percorrer o vetor de ambos os lados e trocar os elementos das extremidades até o centro.
    // Cada troca é realizada entre vet[inicio] e vet[fim].
    // O processo continua até que todos os elementos sejam invertidos.

    private void vetInverter_7(int vet[], int posFinal) {
        int inicio = 0;
        int fim = posFinal - 1;
        while (inicio < fim) {
            int temp = vet[inicio];
            vet[inicio] = vet[fim];
            vet[fim] = temp;
            inicio++;
            fim--;
        }
        System.out.println("Valores invertidos com sucesso!");
    }

    public static void main(String[] args) {
        new Uni6Exe10();
    }
}

