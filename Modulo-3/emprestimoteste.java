import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoTest {

    private Date dataRetirada;
    private Date dataDevolucao;
    private Livro livro;
    private Usuario usuario;
    private Emprestimo emprestimo;

    @BeforeEach
    public void setUp() {
        dataRetirada = new Date();
        dataDevolucao = new Date();
        livro = new Livro("Java Basics", new Autor("Alan Turing", "Inglês"), "Tecnologia", true);
        usuario = new Usuario("Gabriel", 21);
        emprestimo = new Emprestimo(dataRetirada, dataDevolucao, livro, usuario);
    }

    @Test
    public void testGetDataRetirada() {
        assertEquals(dataRetirada, emprestimo.getDataRetirada());
    }

    @Test
    public void testGetDataDevolucao() {
        assertEquals(dataDevolucao, emprestimo.getDataDevolucao());
    }

    @Test
    public void testSetDataDevolucao() {
        Date novaData = new Date(System.currentTimeMillis() + 86400000L); // +1 dia
        emprestimo.setDataDevolucao(novaData);
        assertEquals(novaData, emprestimo.getDataDevolucao());
    }

    @Test
    public void testGetLivro() {
        assertEquals(livro, emprestimo.getLivro());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuario, emprestimo.getUsuario());
    }

    @Test
    public void testLivroMarcadoComoIndisponivelAoEmprestar() {
        assertFalse(livro.isDisponivel());
    }

    @Test
    public void testEmprestimoAdicionadoAoHistoricoDoUsuario() {
        assertTrue(usuario.getHistoricoEmprestimos().contains(emprestimo));
    }
}