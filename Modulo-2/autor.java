import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa {
    private String nacionalidade;
    private List<Livro> livros;

    public Autor(String nome, String nacionalidade) {
        super(nome);
        this.nacionalidade = nacionalidade;
        this.livros = new ArrayList<>();
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getObrasPublicadas() {
        return livros;
    }

    public List<Livro> getObrasPublicadasPorGenero(String genero) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
}