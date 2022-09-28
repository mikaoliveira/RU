package br.ufpb.sisru;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SisRuRioTinto implements SisRU {
	private List<Usuario> usuarios;
	List<RefeicaoRealizada> listaR;

	public SisRuRioTinto() {
		this.usuarios = new ArrayList<Usuario>();
		this.listaR = new ArrayList<RefeicaoRealizada>();
		
	}
	public List<RefeicaoRealizada> getlistaR(){
		return this.listaR;
	}
	public List<Usuario>getusuario(){
		return this.usuarios;
	}

	public boolean cadastrarUsuario(Usuario u) {
		for (Usuario x : this.usuarios) {
			if (x.getmatricula().equals(u.getmatricula())) {
				return false;
			}
		}
		this.usuarios.add(u);
		return true;
	}

	public List<Usuario> pesquisarUsuarioDaCidade(String cidade) {
		ArrayList<Usuario> listacidade = new ArrayList<Usuario>();
		for (Usuario x : this.usuarios) {
			if (x.getcidadeResidencia().equals(cidade)) {
				listacidade.add(x);
			}
		}
		return listacidade;
	}

	public Usuario pesquisaUsuariopelaMatricula(String matricula) throws UsuarioNaoExisteException {
		for (Usuario x : usuarios) {
			if (x.getmatricula().equals(matricula)) {
				return x;
			}
		}
		throw new UsuarioNaoExisteException("Não Existe Usuário com essa Matricula");
	}

	public void salvarDados() {
		GravadorDeDados gravador = new GravadorDeDados();
		try {
			gravador.gravarUsuarios(this.usuarios);
		} catch (IOException e) {
			System.out.println("Erro ao gravar dados! " + e.getMessage());
		}
	}

	public void recuperarDados() {
		GravadorDeDados recuperar = new GravadorDeDados();
		try {
			this.usuarios = recuperar.recuperarUsuarios();
		} catch (IOException e) {
			System.out.println("Erro ao recuperar dados! " + e.getMessage());
		}

	}

	public List<Usuario> pesquisaUsuariosComNomeDeInicial(String prefixoNome) {
		ArrayList<Usuario> listaP = new ArrayList<Usuario>();
		for (Usuario x : usuarios) {
			if (x.getnome().startsWith(prefixoNome)) {
				listaP.add(x);
			}
		}
		return listaP;
	}

	// Analisar
	public void cadastrarRefeicaoRealizada(String matricula, int dia, int mes, int ano, String tipoRefeicao) {
		boolean cadastrar = false;
		for (Usuario x : usuarios) {
			if (x.getmatricula().equals(matricula)) {
				cadastrar = true;
				Data data = new Data(dia, mes, ano);
				RefeicaoRealizada objRefeicao = new RefeicaoRealizada(data, matricula, tipoRefeicao);
				listaR.add(objRefeicao);
				JOptionPane.showMessageDialog(null,"Refeição cadastrada com sucesso!");
				break;
			}
		}
		if (cadastrar == false ) {
			JOptionPane.showMessageDialog(null, " Usuário não está autorizado para fazer refeição.");

		} 
		
		
	}

}
