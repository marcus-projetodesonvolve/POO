import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstrategiaPublicacaoTest {
    private Autor autor;

    @BeforeEach public void setUp() { autor = new Autor("Jessica Felix", "Brasileira"); }

    @Test public void testPublicarSemEstrategia() { assertDoesNotThrow(() -> autor.publicar()); }
    @Test public void testEstrategiaLivro() {
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro("Java for Beginners"));
        assertDoesNotThrow(() -> autor.publicar());
    }
    @Test public void testEstrategiaArtigo() {
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo("Entendendo Compiladores"));
        assertDoesNotThrow(() -> autor.publicar());
    }
    @Test public void testTrocarEstrategiaEmExecucao() {
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro("Livro A"));
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo("Artigo B"));
        assertDoesNotThrow(() -> autor.publicar());
    }
    @Test public void testGetEstrategiaConfigurada() {
        EstrategiaPublicacao e = new EstrategiaPublicacaoLivro("Livro X");
        autor.setEstrategiaPublicacao(e);
        assertEquals(e, autor.getEstrategiaPublicacao());
    }
    @Test public void testAutorUsuarioComEstrategia() {
        Autor a = new Autor("Alan Turing", "Inglês", true);
        a.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo("Artigo de Turing"));
        assertTrue(a.isEhUsuario());
        assertDoesNotThrow(() -> a.publicar());
    }
}