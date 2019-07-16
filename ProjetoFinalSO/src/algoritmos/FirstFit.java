package algoritmos;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstFit extends Algoritmos {

    private Particao memoria[] = Memoria.getMemoria().getParticoes();

    @Override
    public boolean alocaProcesso(Processo processo) {

        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i].getEspacoLivre() >= processo.getSize()) {
                memoria[i].adicionarProcesso(processo);
                return true;
            }
        }
        memoria[0].removerProcesso(memoria, processo);
        return false;
    }

}
