package algoritmos;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Algoritmos {

    public abstract boolean alocaProcesso(Processo processo);

    public void printaEstadoMemoria() {
        System.out.println("\n");
        System.out.println("\t\t\t----------------------------------");
        for (int i = 0; i < Memoria.getMemoria().getParticoes().length; i++) {
            System.out.println("\n\t\t\tPartição " + i + " | Espaço Livre : " + Memoria.getMemoria().getParticoes()[i].getEspacoLivre());
            int j = 0;
            for (Processo processo : Memoria.getMemoria().getParticoes()[i].getProcessos()) {
                System.out.print("\t\t\tP" + Memoria.getMemoria().getParticoes()[i].getProcessos().get(j).getId() + "    ");
                j++;
            }
        }
        System.out.println("\t\t\t----------------------------------");
    }

    public void fazAlgoritmo() {
        printaEstadoMemoria();

        Processo p0 = new Processo(0, 120);
        Memoria.getMemoria().getFila().add(p0);

        Processo p1 = new Processo(1, 50);
        Memoria.getMemoria().getFila().add(p1);

        Processo p2 = new Processo(2, 90);
        Memoria.getMemoria().getFila().add(p2);

        Processo p3 = new Processo(3, 120);
        Memoria.getMemoria().getFila().add(p3);

        Processo p4 = new Processo(4, 10);
        Memoria.getMemoria().getFila().add(p4);

        Processo p5 = new Processo(10, 120);
        Memoria.getMemoria().getFila().add(p5);

        Queue<Processo> fila = Memoria.getMemoria().getFila();
        printaEstadoMemoria();

        while (!fila.isEmpty()) {

            Processo processo = (Processo) Memoria.getMemoria().getFila().poll();

            boolean inserido = alocaProcesso(processo);

            if (!inserido) {
                System.out.println("\n\t\t\tNão foi possível inserir o processo... " + processo.getId());
                Memoria.getMemoria().getFila().add(processo);
            } else {
                System.out.println("\n\t\t\tO processo " + processo.getId() + " foi inserido na memória");

            }

            System.out.println("");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FirstFit.class.getName()).log(Level.SEVERE, null, ex);
            }
            printaEstadoMemoria();
        }
    }

}
