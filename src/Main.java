import java.io.File;

public class Main {
    public static void main(String[] args) {
        tabelaHash hash = new tabelaHash(26);

        String caminhoTexto = "C:\\Users\\joaov\\OneDrive\\Documentos\\Faculdade\\Estrutura de Dados\\IndiceRemissivo\\teste\\texto.txt";
        leitorArquivo.processarTexto(caminhoTexto, hash);

        System.out.println("indices remissivos:");
        hash.imprimirIndiceRemissivo();

        String pastaDestino = "C:\\Users\\joaov\\OneDrive\\Documentos\\Faculdade\\Estrutura de Dados\\IndiceRemissivo\\resultado";

        String nomeArquivo = "resultado.txt";
        File arquivoSaida = new File(pastaDestino, nomeArquivo);

        hash.exportarIndiceRemissivo(arquivoSaida.getAbsolutePath());

        System.out.println("indice salvo em: " + arquivoSaida.getAbsolutePath());
    }
}
