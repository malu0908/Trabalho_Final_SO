package algoritmos;

import java.util.Scanner;

public class Executa {

    public void exibeMenu() {

        System.out.println("\t\t\t|---------------------------|");
        System.out.println("\t\t\t|     Menu de Opções        |");
        System.out.println("\t\t\t|---------------------------|");
        System.out.println("\t\t\t|                           |");
        System.out.println("\t\t\t|   Escolha o Algoritmo     |");
        System.out.println("\t\t\t|                           |");
        System.out.println("\t\t\t|   [1] - FirstFit          |");
        System.out.println("\t\t\t|   [2] - NextFit           |");
        System.out.println("\t\t\t|   [3] - BestFit           |");
        System.out.println("\t\t\t|   [4] - WorstFit          |");
        System.out.println("\t\t\t|   [5] - Sair              |");
        System.out.println("\t\t\t|---------------------------|");
    }

    public void leTeclado() {
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        Algoritmos alg = null;
        switch (opcao) {
            case 1:
                System.out.println("\t\t\t\tExecutando FirstFit...");
                alg = new FirstFit();
                break;

            case 2:
                System.out.println("\t\t\t\tExecutando NextFit...");
                alg = new NextFit();
                break;

            case 3:
                System.out.println("\t\t\t\tExecutando BestFit...");
                alg = new BestFit();
                break;

            case 4:
                System.out.println("\t\t\t\tExecutando WorstFit...");
                alg = new WorstFit();
                break;

            default:
                System.out.println("\t\t\t\tComando Inválido!");

        }
        alg.fazAlgoritmo();

    }

    public void printaMemoria() {
        System.out.println("\n\n");
        System.out.println("\t\t\tID Processo\tTamanho Processo\tNo. Particao");
        for (int i = 0; i < Memoria.getMemoria().getParticoes().length; i++) {
            for (int j = 0; j < Memoria.getMemoria().getParticoes()[i].getProcessos().size(); j++) {
                System.out.print("\t\t\t" + "   " + (Memoria.getMemoria().getParticoes()[i].getProcessos().get(j).getId()) + 
                        "\t\t\t" + Memoria.getMemoria().getParticoes()[i].getProcessos().get(j).getSize() + "\t\t\t" + i + "\t\t");
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Executa ex = new Executa();
        ex.exibeMenu();
        ex.leTeclado();
        ex.printaMemoria();
    }
}