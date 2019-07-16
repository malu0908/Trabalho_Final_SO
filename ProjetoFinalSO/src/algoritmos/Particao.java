package algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Particao {

    private final int tamanho;

    private int espacoLivre;

    List<Processo> processos;

    public Particao(int tamanho) {
        this.tamanho = tamanho;
        this.espacoLivre = tamanho;
        this.processos = new ArrayList<>();
    }

    public void adicionarProcesso(Processo processo) {
        processos.add(processo);
        espacoLivre -= processo.getSize();
    }

    public void removerProcesso(Particao memoria[], Processo inserir) {
        for (Particao particao : memoria) {
            if (particao.processos.size() > 0 && particao.tamanho >= inserir.getSize()) {
                Random remove = new Random();
                int processoRem = remove.nextInt(particao.processos.size());
            
                Processo retorno = particao.processos.remove(processoRem);
                System.out.println("\n\t\t\tRemovendo o processo ... " + retorno.getId());
                
                particao.espacoLivre += retorno.getSize();
            }
        }
    }

    public int getEspacoLivre() {
        return espacoLivre;
    }

    public void setEspacoLivre(int espacoLivre) {
        this.espacoLivre = espacoLivre;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

}
