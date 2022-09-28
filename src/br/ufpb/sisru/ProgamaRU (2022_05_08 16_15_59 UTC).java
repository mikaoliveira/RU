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
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção:\n1.Cadastrar Usuário"
					+ "\n2.Pesquisar usuários da cidade\n3.Pesquisar usuário pela matricula\n4.Pesquisar usuário com nome de inicial..."
					+ "\n5.Sair\n6.Cadastrar refeição realizada\n7.Pesquisar número de refeições totais realizadas em um certo dia"
					+ "\n8.Pesquisar número de refeições de um certo tipo realizadas em um certo mês de um ano"
					+ "\n9.Pesquisar número de usuários que fizeram refeições em um certo mês de um ano\n10.Pesquisar usuários que "
					+ "fizeram refeições em um certo dia\n11.Salvar Dados "));
			//Obs:(lembrar de passar dia, mês e ano nas opcoes 7,10)
			if(opcao==1){
				String nome = JOptionPane.showInputDialog("Digite seu Nome:");
				String matricula = JOptionPane.showInputDialog("Digite sua Matricula:");
				String cidade = JOptionPane.showInputDialog("Informe sua Cidade:"); 
				Usuario u = new Usuario(nome, matricula,cidade);
				boolean cadastrou = sistema.cadastrarUsuario(u);
				if(cadastrou == true){
					JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");
				}
				else {
					JOptionPane.showMessageDialog(null,"Já existe usuário com está matricula. "
							+ "Tente Novamente!");
				}
			}
			else if(opcao==2) {
				String city = JOptionPane.showInputDialog("Informe sua cidade: ");
				List<Usuario> lista = sistema.pesquisarUsuarioDaCidade(city);
				for(Usuario u:lista) {
					JOptionPane.showInputDialog("Os Usuarios da cidade é a seguinte:"+u.toString());	
				}
				
			}
			else if(opcao==3){
				try {
						String mat = JOptionPane.showInputDialog("Digite a matricula do usuário");
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
				JOptionPane.showMessageDialog(null,"Até mais !");
				break;
			}
			else if(opcao==6) {
				String matricula = JOptionPane.showInputDialog("Informe sua Matricula:");
				String novaRefeicao = JOptionPane.showInputDialog("Qual foi a refeição do dia?"
						+ "/n1.Café:1 /n2.Almoço:2 /n3.Jantar:3");
				int dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia:"));
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o Mês:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				Data data = new Data(dia,mes,ano);
				RefeicaoRealizada x = new RefeicaoRealizada(data,matricula, novaRefeicao);
				sistema.cadastrarRefeicaoRealizada(matricula,dia,mes,ano,novaRefeicao);
			}
			else if(opcao==7) {
				int dia =Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia:"));
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o Mês:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				int cont = 0;
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(dia == x.getdatarefeicao().getdia() && mes == x.getdatarefeicao().getmes() && ano == x.getdatarefeicao().getano()){
						cont ++;
					}
					
				}
				JOptionPane.showMessageDialog(null, "Foram realizadas: "+cont+" Refeições, no dia: "+dia+"/"+mes+"/"+ano);
			}
			else if(opcao==8) {
				String tipo = JOptionPane.showInputDialog("Qual o tipo de Refeição?"
						+ "\n1.Café:1 \n2.Almoço:2 \n3.Jantar:3");
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o Mês:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				int cont = 0;
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(x.gettipoRefeicao().equals(tipo)) {
						if(x.getdatarefeicao().getmes()==(mes) && x.getdatarefeicao().getano()==(ano)) {
							cont ++;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "Foram realizadas: "+cont+" Refeições, do tipo: "+tipo+", na data: "+mes+"/"+ano);
						
			}
			else if(opcao==9) {
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o Mês:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				int cont = 0;
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(x.getdatarefeicao().getmes() == mes && x.getdatarefeicao().getano() == ano) {
						cont ++;
					}
				}
				JOptionPane.showMessageDialog(null, "O numero de Usuarios que fizeram refeição é: "+cont+", na data: "+mes+"/"+ano);
				
			}
			else if(opcao==10) {
				List<Usuario> lmatriculas = new ArrayList<Usuario>();
				int dia =Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia:"));
				int mes =Integer.parseInt(JOptionPane.showInputDialog("Informe o Mês:"));
				int ano =Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano:"));
				for(RefeicaoRealizada x: sistema.getlistaR()) {
					if(dia == x.getdatarefeicao().getdia() && mes == x.getdatarefeicao().getmes() && ano == x.getdatarefeicao().getano()){
						for(Usuario y: sistema.getusuario()) {
							if(x.getmatriculaUsuario().equals(y.getmatricula())){
								JOptionPane.showMessageDialog(null, "Os usuarios que realizaram refeições foram: "+y+", no dia: "+dia+"/"+mes+"/"+ano);
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
