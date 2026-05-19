import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa implements PublicavelInterface {
    private String nacionalidade;
    private List<Livro> livros;
    private boolean ehUsuario;
    private EstrategiaPublicacao estrategiaPublicacao;

    public Autor(String nome, String nacionalidade) {
        super(nome);
        this.nacionalidade = nacionalidade;
        this.livros = new ArrayList<>();
        this.ehUsuario = false;
    }

    public Autor(String nome, String nacionalidade, boolean ehUsuario) {
        super(nome);
        this.nacionalidade = nacionalidade;
        this.livros = new ArrayList<>();
        this.ehUsuario = ehUsuario;
    }

    public void setEstrategiaPublicacao(EstrategiaPublicacao estrategia) {
        this.estrategiaPublicacao = estrategia;
    }

    public EstrategiaPublicacao getEstrategiaPublicacao() {
        return estrategiaPublicacao;
    }

    @Override
    public void publicar() {
        if (estrategiaPublicacao == null) {
            System.out.println("Nenhuma estratégia de publicação definida para " + getNome());
            return;
        }
        estrategiaPublicacao.publicar();
    }

    public boolean isEhUsuario() { return ehUsuario; }
    public void setEhUsuario(boolean ehUsuario) { this.ehUsuario = ehUsuario; }
    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String n) { this.nacionalidade = n; }
    public List<Livro> getObrasPublicadas() { return livros; }

    public List<Livro> getObrasPublicadasPorGenero(String genero) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getGenero().equalsIgnoreCase(genero)) resultado.add(livro);
        }
        return resultado;
    }

    public void adicionarLivro(Livro livro) { livros.add(livro); }
}
