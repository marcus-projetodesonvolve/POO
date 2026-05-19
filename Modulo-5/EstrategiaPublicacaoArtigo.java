public class EstrategiaPublicacaoArtigo implements EstrategiaPublicacao {
    private String tituloArtigo;

    public EstrategiaPublicacaoArtigo(String tituloArtigo) {
        this.tituloArtigo = tituloArtigo;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando artigo: " + tituloArtigo);
        System.out.println("Estratégia: Publicação em plataformas digitais e periódicos.");
    }
}