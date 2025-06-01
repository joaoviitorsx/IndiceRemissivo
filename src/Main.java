public class Main {
    public static void main(String[] args) {
        tabelaHash hash = new tabelaHash(26);

        String caminhoTexto = "C:\\Users\\joaov\\OneDrive\\Documentos\\Faculdade\\IndiceRemissivo\\teste\\texto.txt";
        leitorArquivo.processarTexto(caminhoTexto, hash);

        System.out.println("indices remissivos:");
        hash.imprimirIndiceRemissivo();

        String caminhoSainda = "C:\\Users\\joaov\\OneDrive\\Documentos\\Faculdade\\IndiceRemissivo\\teste\\indice.txt";
        hash.exportarIndiceRemissivo(caminhoSainda);
    }
}
