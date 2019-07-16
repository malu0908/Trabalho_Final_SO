package algoritmos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BestFit extends Algoritmos {

    private Particao[] memoria = Memoria.getMemoria().getParticoes();

    @Override
    public boolean alocaProcesso(Processo processo) {

        int melhorParticao = -1;
        int espacoLivre;

        espacoLivre = Integer.MAX_VALUE;

        for (int i = 0; i < memoria.length; i++) {
            if (processo.getSize() <= memoria[i].getEspacoLivre()) {
                if ((memoria[i].getEspacoLivre() - processo.getSize()) < espacoLivre) {
                    espacoLivre = memoria[i].getEspacoLivre() - processo.getSize();
                    melhorParticao = i;
                }
            }
        }
        if (melhorParticao > -1) {
            this.memoria[melhorParticao].adicionarProcesso(processo);
            return true;
        } else {
            memoria[0].removerProcesso(memoria, processo);
            return false;
        }
    }

}
