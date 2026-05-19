import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Gabriel", 21);
    }

    @Test
    public void testGetNome() {
        assertEquals("Gabriel", usuario.getNome());
    }

    @Test
    public void testSetNome() {
        usuario.setNome("Lucas");
        assertEquals("Lucas", usuario.getNome());
    }

    @Test
    public void testGetIdade() {
        assertEquals(21, usuario.getIdade());
    }

    @Test
    public void testSetIdade() {
        usuario.setIdade(25);
        assertEquals(25, usuario.getIdade());
    }

    @Test
    public void testHistoricoEmprestimosInicialmenteVazio() {
        assertTrue(usuario.getHistoricoEmprestimos().isEmpty());
    }

    @Test
    public void testAdicionarEmprestimo() {
        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia", true);
        Emprestimo emprestimo = new Emprestimo(new Date(), new Date(), livro, usuario);

        usuario.adicionarEmprestimo(emprestimo);

        assertEquals(1, usuario.getHistoricoEmprestimos().size());
        assertEquals(emprestimo, usuario.getHistoricoEmprestimos().get(0));
    }
}