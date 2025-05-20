import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;

public class escritoIndice {

    public static void gerarIndice(String caminhoPalavrasChave, String caminhoSaida, tabelaHash hash) {
        try (
            BufferedReader br = new BufferedReader(new FileReader(caminhoPalavrasChave));
            BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoSaida))
        ) {
            String palavraChave;

            while ((palavraChave = br.readLine()) != null) {
                palavraChave = limparTexto(palavraChave);

                if (palavraChave == null || palavraChave.trim().isEmpty()) continue;

                Palavra encontrada = hash.buscar(palavraChave);

                if (encontrada != null) {
                    bw.write(encontrada.toString());
                    bw.newLine();
                }
            }

            System.out.println("Índice remissivo salvo em: " + caminhoSaida);

        } catch (IOException e) {
            System.out.println("Erro ao gerar o índice remissivo: " + e.getMessage());
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
