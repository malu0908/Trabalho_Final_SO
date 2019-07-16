package algoritmos;

import java.util.LinkedList;
import java.util.Queue;

public class Memoria {

    private final int tamanho = 512;
    private Queue<Processo> filaDeProcessos = new LinkedList<>();
    private Particao[] particoes;
    private static Memoria memoria = new Memoria();

    private Memoria() {
    }

    public Particao[] getParticoes() {
        if (particoes == null) {
            particoes = new Particao[5];

            particoes[0] = new Particao(60);
            particoes[1] = new Particao(130);
            particoes[2] = new Particao(122);
            particoes[3] = new Particao(100);
            particoes[4] = new Particao(100);

        }
        return particoes;
    }
    
    public static Memoria getMemoria() {
        return memoria;
    }
    
    public Queue getFila() {
        return filaDeProcessos;
    }
}
