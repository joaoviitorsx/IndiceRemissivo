public class Palavra implements Comparable<Palavra> {
    private final String texto;
    private final listaEncadeada<Integer> linhas;

    public Palavra(String texto) {
        this.texto = texto.toLowerCase();
        this.linhas = new listaEncadeada<>();
    }

    public void adicionarLinha(int linha) {
        if (!linhas.verificar(linha)) {
            linhas.adicionar(linha);
        }
    }


    public String getTexto() {
        return texto;
    }

    public listaEncadeada<Integer> getLinhas() {
        return linhas;
    }



    @Override
    public String toString() {
        return texto + " " + linhas.obterLinha();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;

        if (obj == null || !(obj instanceof Palavra)) 
            return false;

        Palavra outra = (Palavra) obj;
        String a = this.texto;
        String b = outra.texto;

        if (a.length() != b.length()) 
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) 
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        String s = this.texto;
        for (int i = 0; i < s.length(); i++) {
            hash = 31 * hash + s.charAt(i);
        }
        return hash;
    }

    @Override
    public int compareTo(Palavra outra) {
        String textoA = this.texto;
        String textoB = outra.texto;
        int len = Math.min(textoA.length(), textoB.length());

        for (int i = 0; i < len; i++) {
            char charA = textoA.charAt(i);
            char charB = textoB.charAt(i);
            if (charA != charB) {
                return charA - charB;
            }
        }
        return textoA.length() - textoB.length();
    }
}
