import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Autor tradicional (não é usuário)
        Autor autorTradicional = new Autor("Jessica Felix", "Brasileira");

        // Autor que também é usuário
        Autor autorUsuario = new Autor("Alan Turing", "Inglês", true);

        // Livro
        Livro livro = new Livro("Java for Beginners", autorTradicional, "Tecnologia", true);

        // Usuário
        Usuario usuario = new Usuario("Lucas Rafael", 25);

        // Artigo
        Artigo artigo = new Artigo("Entendendo Compiladores", autorUsuario, "tecnologia", true);

        // Empréstimo
        livro.validarDisponibilidade();
        Emprestimo emprestimo = new Emprestimo(new Date(), new Date(), livro, usuario);

        // Saída
        System.out.println("=== Empréstimo ===");
        livro.validarDisponibilidade();
        System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
        System.out.println("Autor: " + emprestimo.getLivro().getAutor().getNome());
        System.out.println("Autor é usuário? " + emprestimo.getLivro().getAutor().isEhUsuario());
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