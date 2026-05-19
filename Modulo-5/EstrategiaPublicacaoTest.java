import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstrategiaPublicacaoTest {

    private Autor autor;

    @BeforeEach
    public void setUp() {
        autor = new Autor("Jessica Felix", "Brasileira");
    }

    @Test
    public void testPublicarSemEstrategiaDefinida() {
        assertDoesNotThrow(() -> autor.publicar());
    }

    @Test
    public void testSetEstrategiaPublicacaoLivro() {
        EstrategiaPublicacao e = new EstrategiaPublicacaoLivro("Java for Beginners");
        autor.setEstrategiaPublicacao(e);
        assertDoesNotThrow(() -> autor.publicar());
    }

    @Test
    public void testSetEstrategiaPublicacaoArtigo() {
        EstrategiaPublicacao e = new EstrategiaPublicacaoArtigo("Entendendo Compiladores");
        autor.setEstrategiaPublicacao(e);
        assertDoesNotThrow(() -> autor.publicar());
    }

    @Test
    public void testTrocarEstrategiaEmTempoDeExecucao() {
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro("Livro A"));
        assertDoesNotThrow(() -> autor.publicar());
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo("Artigo B"));
        assertDoesNotThrow(() -> autor.publicar());
    }

    @Test
    public void testGetEstrategiaConfigurada() {
        EstrategiaPublicacao e = new EstrategiaPublicacaoLivro("Livro X");
        autor.setEstrategiaPublicacao(e);
        assertEquals(e, autor.getEstrategiaPublicacao());
    }

    @Test
    public void testAutorEhUsuarioComEstrategia() {
        Autor a = new Autor("Alan Turing", "Inglês", true);
        a.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo("Artigo de Turing"));
        assertTrue(a.isEhUsuario());
        assertDoesNotThrow(() -> a.publicar());
    }
}
