package br.ufpb.sisru;
import java.util.List;
public interface SisRU {
	
	public boolean cadastrarUsuario(Usuario u);
	public List<Usuario> pesquisarUsuarioDaCidade(String cidade);
	public Usuario pesquisaUsuariopelaMatricula(String matricula) throws UsuarioNaoExisteException;
	public List<Usuario> pesquisaUsuariosComNomeDeInicial(String prefixoNome);
	public void salvarDados();
	public void recuperarDados();
	public void cadastrarRefeicaoRealizada(String matricula, int dia, int mes, int ano, String tipoRefeicao);
	public List<RefeicaoRealizada>getlistaR();
	public List<Usuario> getusuario();
}
