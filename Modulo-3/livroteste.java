import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    private Autor autor;
    private Livro livro1;
    private Livro livro2;

    @BeforeEach
    public void setUp() {
        autor = new Autor("Jess", "Brasileira");
        livro1 = new Livro("Java Basico", autor, "tecnologia", true);
        livro2 = new Livro("Java Avancado", autor, "tecnologia", false);
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Java Basico", livro1.getTitulo());
        assertEquals("Java Avancado", livro2.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertEquals(autor, livro1.getAutor());
    }

    @Test
    public void testGetGenero() {
        assertEquals("tecnologia", livro1.getGenero());
    }

    @Test
    public void testIsDisponivel() {
        assertTrue(livro1.isDisponivel());
        assertFalse(livro2.isDisponivel());
    }

    @Test
    public void testSetDisponivel() {
        livro1.setDisponivel(false);
        assertFalse(livro1.isDisponivel());

        livro2.setDisponivel(true);
        assertTrue(livro2.isDisponivel());
    }

    @Test
    public void testValidarDisponibilidadeDisponivel() {
        // livro1 está disponível — não deve lançar exceção
        assertDoesNotThrow(() -> livro1.validarDisponibilidade());
    }

    @Test
    public void testValidarDisponibilidadeIndisponivel() {
        // livro2 não está disponível — não deve lançar exceção
        assertDoesNotThrow(() -> livro2.validarDisponibilidade());
    }
}