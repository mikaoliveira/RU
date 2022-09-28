package br.ufpb.sisru;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class GravadorDeDados {

	private String arquivoUsuarios = "usuarios.txt";
	
	public void gravarUsuarios(List<Usuario> listaUsuarios) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(arquivoUsuarios));
			for (Usuario u : listaUsuarios) {
				gravador.write(u.getnome() + "#" + u.getmatricula() + "#" + u.getcidadeResidencia() + "\n");
			}
		} 
		finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

	public List<Usuario> recuperarUsuarios() throws IOException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(arquivoUsuarios));
			String linhaLida = leitor.readLine();
			while(linhaLida != null) {
				String [] dados = linhaLida.split("#");
				Usuario u = new Usuario(dados[0], dados[1], dados[2]);
				listaUsuarios.add(u);
				linhaLida = leitor.readLine();
			}
			return listaUsuarios;
		} 
		finally {
			if (leitor != null) {
				leitor.close();
			}
		}
	}
	//Analisar
	public void gravaRefeicoes(List<RefeicaoRealizada> refeicoes)throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(arquivoUsuarios));
			for (RefeicaoRealizada x: refeicoes) {
				gravador.write(x.getdatarefeicao()+ "#" +x.getmatriculaUsuario()+ "#" +x.gettipoRefeicao());
			}
		} 
		finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}
	//Analisar
	public List<RefeicaoRealizada> recuperaRefeicoes()throws IOException{
		List<RefeicaoRealizada> listaRR = new ArrayList<RefeicaoRealizada>();
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(arquivoUsuarios));
			String lerLinha = leitor.readLine();
			while(lerLinha != null){
				String [] dados = lerLinha.split("#");
				int dia = Integer.parseInt(dados[0]);
				int mes =Integer.parseInt(dados[1]);
				int ano = Integer.parseInt(dados[2]);
				RefeicaoRealizada x = new RefeicaoRealizada(new Data(dia,mes,ano), dados[3], dados[4]);
				listaRR.add(x);
				lerLinha = leitor.readLine();
			}
			return listaRR;
		}
		finally {
			if(leitor != null) {
				leitor.close();
			}
		}
		
	}
}
