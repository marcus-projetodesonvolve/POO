import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Autor autorLivro = new Autor("Jessica Felix", "Brasileira");
        Livro livro = new Livro("Java for Beginners", autorLivro, "Tecnologia", true);
        autorLivro.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro(livro.getTitulo()));
        autorLivro.publicar();

        System.out.println("---");

        Autor autorArtigo = new Autor("Alan Turing", "Inglês", true);
        Artigo artigo = new Artigo("Entendendo Compiladores", autorArtigo, "tecnologia", true);
        autorArtigo.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo(artigo.getTitulo()));
        autorArtigo.publicar();

        System.out.println("---");

        Usuario usuario = new Usuario("Lucas Rafael", 25);
        livro.validarDisponibilidade();
        Emprestimo emprestimo = new Emprestimo(new Date(), new Date(), livro, usuario);
        livro.validarDisponibilidade();

        System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
        System.out.println("Autor: " + emprestimo.getLivro().getAutor().getNome());
        System.out.println("Genero: " + emprestimo.getLivro().getGenero());
        System.out.println("Usuario: " + emprestimo.getUsuario().getNome());
        System.out.println("Idade: " + emprestimo.getUsuario().getIdade());
        System.out.println("Data de Retirada: " + emprestimo.getDataRetirada());
        System.out.println("Data de Devolucao: " + emprestimo.getDataDevolucao());

        System.out.println("\n=== Artigo ===");
        System.out.println("Titulo: " + artigo.getTitulo());
        System.out.println("Autor: " + artigo.getAutor().getNome());
        System.out.println("Autor é usuário? " + artigo.getAutor().isEhUsuario());
        System.out.println("Genero: " + artigo.getGenero());
        System.out.println("Publicado: " + artigo.isPublicado());
    }
}
