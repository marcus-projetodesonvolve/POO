public class EstrategiaPublicacaoLivro implements EstrategiaPublicacao {
    private String tituloLivro;

    public EstrategiaPublicacaoLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando livro: " + tituloLivro);
        System.out.println("Estratégia: Envio para editoras e distribuidoras físicas.");
    }
}