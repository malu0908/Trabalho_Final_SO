package algoritmos;

public class WorstFit extends Algoritmos {

    private Particao memoria[] = Memoria.getMemoria().getParticoes();

    @Override
    public boolean alocaProcesso(Processo processo) {
        int piorParticao = -1;
        int espacoLivre;

        espacoLivre = -Integer.MAX_VALUE;

        for (int i = 0; i < memoria.length; i++) {
            if (processo.getSize() <= memoria[i].getEspacoLivre()) {
                if ((memoria[i].getEspacoLivre() - processo.getSize()) > espacoLivre) {
                    espacoLivre = memoria[i].getEspacoLivre() - processo.getSize();
                    piorParticao = i;
                }
            }
        }
        if (piorParticao > -1) {
            this.memoria[piorParticao].adicionarProcesso(processo);
            return true;
        } else {
            memoria[0].removerProcesso(memoria, processo);
            return false;
        }
    }

}
