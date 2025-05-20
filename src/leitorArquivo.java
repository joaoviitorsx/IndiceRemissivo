import java.io.*;
import java.text.Normalizer;

public class leitorArquivo {

    public static void processarTexto(String caminhoArquivoTexto, tabelaHash hash) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminhoArquivoTexto), "UTF-8"))) {

            String linha;
            int numeroLinha = 1;

            while ((linha = br.readLine()) != null) {
                linha = limparTexto(linha);
                String[] palavras = linha.split("\\s+");

                for (String p : palavras) {
                    if (p == null || p.trim().isEmpty()) continue;

                    Palavra novaPalavra = new Palavra(p);
                    novaPalavra.adicionarLinha(numeroLinha);
                    hash.inserir(novaPalavra);
                }

                numeroLinha++;
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static String limparTexto(String texto) {
        texto = texto.toLowerCase();

        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        texto = texto.replaceAll("[^a-z0-9\\s]", " ");

        texto = texto.replaceAll("\\s+", " ").trim();

        return texto;
    }

}
