import java.io.*;
import java.text.Normalizer;

public class escritoIndice {

    public static void gerarIndice(String caminhoPalavrasChave, String caminhoSaida, tabelaHash hash) {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminhoPalavrasChave), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(caminhoSaida), "UTF-8"))
        ) {
            String palavraChave;

            while ((palavraChave = br.readLine()) != null) {
                palavraChave = limparTexto(palavraChave);
                if (palavraChave == null || palavraChave.trim().isEmpty()) 
                    continue;

                Palavra encontrada = hash.buscar(palavraChave);
                if (encontrada != null) {
                    bw.write(encontrada.toString());
                    bw.newLine();
                } else {
                    bw.write(palavraChave + " - nao encontrada");
                    bw.newLine();
                }
            }

            System.out.println("indice remissivo salvo em: " + caminhoSaida);

        } catch (IOException e) {
            System.out.println("erro ao gerar o índice remissivo: " + e.getMessage());
        }
    }

    private static String limparTexto(String texto) {
        texto = texto.toLowerCase();
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        texto = texto.replaceAll("[^a-z0-9\\s\\-]", " ").replaceAll("\\s+", " ").trim();
        return texto;
    }
}
