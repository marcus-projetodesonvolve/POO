import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtigoTest {

    private Autor autor;
    private Artigo artigo;

    @BeforeEach
    public void setUp() {
        autor = new Autor("Alan Turing", "Inglês", true);
        artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", true);
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Entendendo Compiladores", artigo.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        artigo.setTitulo("Novo Título");
        assertEquals("Novo Título", artigo.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertEquals(autor, artigo.getAutor());
    }

    @Test
    public void testSetAutor() {
        Autor novoAutor = new Autor("Grace Hopper", "Americana");
        artigo.setAutor(novoAutor);
        assertEquals(novoAutor, artigo.getAutor());
    }

    @Test
    public void testGetGenero() {
        assertEquals("tecnologia", artigo.getGenero());
    }

    @Test
    public void testSetGenero() {
        artigo.setGenero("ciencia");
        assertEquals("ciencia", artigo.getGenero());
    }

    @Test
    public void testIsPublicado() {
        assertTrue(artigo.isPublicado());
    }

    @Test
    public void testSetPublicado() {
        artigo.setPublicado(false);
        assertFalse(artigo.isPublicado());
    }

    @Test
    public void testAutorDoArtigoEhUsuario() {
        assertTrue(artigo.getAutor().isEhUsuario());
    }
}