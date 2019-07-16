package algoritmos;

public class NextFit extends Algoritmos {

    private Particao memoria[] = Memoria.getMemoria().getParticoes();
    private int ultimaAlocada = -1;

    @Override
    public boolean alocaProcesso(Processo processo) {

        int k;
        if (ultimaAlocada > -1) {
            k = ultimaAlocada;
        } else {
            k = 0;
        }

        int j = 0;
        int i = k;
        int limite = memoria.length;

        while (j < 2) {
            for (; i < limite; i++) {
                if (memoria[i].getEspacoLivre() >= processo.getSize()) {
                    memoria[i].adicionarProcesso(processo);
                    ultimaAlocada = i;
                    return true;
                }
            }
            j++;
            limite = k;
            i = 0;
        }
        memoria[0].removerProcesso(memoria, processo);
        return false;
    }

}
