package br.ufpb.sisru;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class ProgamaRU {
	public static void main(String args[]) {
		SisRU sistema = new SisRuRioTinto();
		sistema.recuperarDados();
		JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema do Restaurante Universitario !");
		while(true) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite uma op��o:\n1.Cadastrar Usu�rio"
					+ "\n2.Pesquisar usu�rios da cidade\n3.Pesquisar usu�rio pela matricula\n4.Pesquisar usu�rio com nome de inicial..."
					+ "\n5.Sair\n6.Cadastrar refei��o realizada\n7.Pesquisar n�mero de refei��es totais realizadas em um certo dia"
					+ "\n8.Pesquisar n�mero de refei��es de um certo tipo realizadas em um certo m�s de um ano"
					+ "\n9.Pesquisar n�mero de usu�rios que fizeram refei��es em um certo m�s de um ano\n10.Pesquisar usu�rios que "
					+ "fizeram refei��es em um certo dia\n11.Salvar Dados "));
			//Obs:(lembrar de passar dia, m�s e ano nas opcoes 7,10)
			if(opcao==1){
				String nome = JOptionPane.showInputDialog("Digite seu Nome:");
				String matricula = JOptionPane.showInputDialog("Digite sua Matricula:");
				String cidade = JOptionPane.showInputDialog("Informe sua Cidade:"); 
				Usuario u = new Usuario(nome, matricula,cidade);
				boolean cadastrou = sistema.cadastrarUsuario(u);
				if(cadastrou == true){
					JOptionPane.showMessageDialog(null,"Usu�rio cadastrado com sucesso!");
				}
				else {
					JOptionPane.showMessageDialog(null,"J� existe usu�rio com est� matricula. "
							+ "Tente Novamente!");
				}
			}
			else if(opcao==2) {
				String city = JOptionPane.showInputDialog("Informe sua cidade: ");
				List<Usuario> lista = sistema.pesquisarUsuarioDaCidade(city);
				for(Usuario u:lista) {
					JOptionPane.showInputDialog("Os Usuarios da cidade � a seguinte:"+u.toString());	
				}
				
			}
			else if(opcao==3){
				try {
						String mat = JOptionPane.showInputDialog("Digite a matricula do usu�rio");
						Usuario u = sistema.pesquisaUsuariopelaMatricula(mat);
						JOptionPane.showMessageDialog(null,u.toString());
				}catch(UsuarioNaoExisteException e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
			else if(opcao==4) {
				String inicial = JOptionPane.showInputDialog("Digite sua Inicial:");
				List<Usuario> lista = sistema.pesquisaUsuariosComNomeDeInicial(inicial);
				for(Usuario u:lista) {
					JOptionPane.showMessageDialog(null, u.toString());
				}
			}
			else if(opcao==5) {
				JOptionPane.showMessageDialog(null,"At� mais !");
				break;
			}
			else if(opcao==6) {
				String matricula = JOptionPane.showInputDialog("Informe sua Matricula:");
				String novaRefeicao = JOptionPane.showInputDialog("Qual foi a refei��o do dia?"
						+ "/n1.Caf�:1 /n2.Almo�o:2 /n3.Jantar:3");
				int dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia:"));
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o M�s:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				Data data = new Data(dia,mes,ano);
				RefeicaoRealizada x = new RefeicaoRealizada(data,matricula, novaRefeicao);
				sistema.cadastrarRefeicaoRealizada(matricula,dia,mes,ano,novaRefeicao);
			}
			else if(opcao==7) {
				int dia =Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia:"));
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o M�s:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				int cont = 0;
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(dia == x.getdatarefeicao().getdia() && mes == x.getdatarefeicao().getmes() && ano == x.getdatarefeicao().getano()){
						cont ++;
					}
					
				}
				JOptionPane.showMessageDialog(null, "Foram realizadas: "+cont+" Refei��es, no dia: "+dia+"/"+mes+"/"+ano);
			}
			else if(opcao==8) {
				String tipo = JOptionPane.showInputDialog("Qual o tipo de Refei��o?"
						+ "\n1.Caf�:1 \n2.Almo�o:2 \n3.Jantar:3");
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o M�s:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				int cont = 0;
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(x.gettipoRefeicao().equals(tipo)) {
						if(x.getdatarefeicao().getmes()==(mes) && x.getdatarefeicao().getano()==(ano)) {
							cont ++;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "Foram realizadas: "+cont+" Refei��es, do tipo: "+tipo+", na data: "+mes+"/"+ano);
						
			}
			else if(opcao==9) {
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o M�s:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				int cont = 0;
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(x.getdatarefeicao().getmes() == mes && x.getdatarefeicao().getano() == ano) {
						cont ++;
					}
				}
				JOptionPane.showMessageDialog(null, "O numero de Usuarios que fizeram refei��o �: "+cont+", na data: "+mes+"/"+ano);
				
			}
			else if(opcao==10) {
				List<Usuario> lmatriculas = new ArrayList<Usuario>();
				int dia =Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia:"));
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o M�s:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(dia == x.getdatarefeicao().getdia() && mes == x.getdatarefeicao().getmes() && ano == x.getdatarefeicao().getano()){
						for(Usuario y: sistema.getusuario()) {
							if(x.getmatriculaUsuario().equals(y.getmatricula())){
								JOptionPane.showMessageDialog(null, "Os usuarios que realizaram refei��es foram: "+y+", no dia: "+dia+"/"+mes+"/"+ano);
							}
						}
						
					}
						
				}
			}
			else if(opcao==11) {
				sistema.salvarDados();
			}
		}
	}

}
