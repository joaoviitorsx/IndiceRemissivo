import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class tabelaHash {

    private abb[] tabela;
    private int capacidade;
    private int nElementos;

    public tabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new abb[capacidade];
        this.nElementos = 0;

        for (int i = 0; i < capacidade; i++) {
            this.tabela[i] = new abb();
        }
    }

    public int tamanho() {
        return this.nElementos;
    }

    private int funcaoHashDiv(String palavra) {
        char letra = palavra.toLowerCase().charAt(0);
        int codigo = letra - 'a'; 
        return codigo % capacidade;
    }

    public void inserir(Palavra p) {
        int chave = funcaoHashDiv(p.getTexto());

        Palavra existente = tabela[chave].buscar(p.getTexto());
        if (existente != null) {
            for (int i = 0; i < p.getLinhas().tamanho(); i++) {
                existente.adicionarLinha(Integer.parseInt(
                    p.getLinhas().obterLinha().split(" ")[i]
                ));
            }
        } else{
            tabela[chave].inserir(p);
            nElementos++;
        }
    }

    public Palavra buscar(String texto) {
        int chave = funcaoHashDiv(texto);
        return tabela[chave].buscar(texto);
    }

    public void imprimirIndiceRemissivo() {
        for (int i = 0; i < capacidade; i++) {
            tabela[i].imprimirEmOrdem();
        }
    }

    public void exportarIndiceRemissivo(String caminhoSaida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoSaida))) {
            for (int i = 0; i < capacidade; i++) {
                tabela[i].exportarEmOrdem(bw);
            }
            System.out.println("indice remissivo completo exportado para: " + caminhoSaida);
        } catch (IOException e) {
            System.out.println("erro ao exportar indice remissivo: " + e.getMessage());
        }
    }
}