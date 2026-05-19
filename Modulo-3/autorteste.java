import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    private Autor autor;
    private Livro livroTecnologia;
    private Livro livroFiccao;

    @BeforeEach
    public void setUp() {
        autor = new Autor("Jess", "Brasileira");
        livroTecnologia = new Livro("Java Basico", autor, "tecnologia", true);
        livroFiccao = new Livro("Mundo Novo", autor, "ficcao", true);
    }

    @Test
    public void testGetNome() {
        assertEquals("Jess", autor.getNome());
    }

    @Test
    public void testGetNacionalidade() {
        assertEquals("Brasileira", autor.getNacionalidade());
    }

    @Test
    public void testSetNacionalidade() {
        autor.setNacionalidade("Americana");
        assertEquals("Americana", autor.getNacionalidade());
    }

    @Test
    public void testGetObrasPublicadas() {
        List<Livro> obras = autor.getObrasPublicadas();
        assertEquals(2, obras.size());
        assertTrue(obras.contains(livroTecnologia));
        assertTrue(obras.contains(livroFiccao));
    }

    @Test
    public void testGetObrasPublicadasPorGenero() {
        List<Livro> obrasTec = autor.getObrasPublicadasPorGenero("tecnologia");
        assertEquals(1, obrasTec.size());
        assertEquals("Java Basico", obrasTec.get(0).getTitulo());
    }

    @Test
    public void testGetObrasPublicadasPorGeneroInexistente() {
        List<Livro> obras = autor.getObrasPublicadasPorGenero("romance");
        assertTrue(obras.isEmpty());
    }

    @Test
    public void testAdicionarLivro() {
        Livro novoLivro = new Livro("Python Basico", autor, "tecnologia", true);
        // adicionarLivro é chamado automaticamente no construtor do Livro
        assertTrue(autor.getObrasPublicadas().contains(novoLivro));
    }
}