public class Main {
    public static void main(String[] args) {
        tabelaHash hash = new tabelaHash(26);

        String caminhoTexto = "C:\\Users\\Joao Vitor\\Desktop\\Matérias\\Estrutura de Dados\\ProjetoAV3\\teste\\texto.txt";
        leitorArquivo.processarTexto(caminhoTexto, hash);

        System.out.println("Índice Remissivo:");
        hash.imprimirIndiceRemissivo();
    }
}
