package br.ufpb.sisru;

public class RefeicaoRealizada {
	private Data dataRefeicao;
	private String matriculaUsuario;
	private String tipoRefeicao;
	public RefeicaoRealizada(Data dataRefeicao, String matriculaUsuario, String tipoRefeicao) {
		this.dataRefeicao = dataRefeicao;
		this.matriculaUsuario = matriculaUsuario;
		this.tipoRefeicao = tipoRefeicao;
	}
	public String toString() {
		String msg ="Data da refeição: "+this.dataRefeicao+", de Matricula: "+this.matriculaUsuario+
				", com o tipo de Refeição: "+this.tipoRefeicao; 
		return msg;
	}
	public Data getdatarefeicao() {
		return this.dataRefeicao;
	}
	public void setdataRefeicao(Data dRefeicao) {
		this.dataRefeicao = dRefeicao;
	}
	public String getmatriculaUsuario() {
		return this.matriculaUsuario;
	}
	public void setmatriculaUsuario(String mUsuario) {
		this.matriculaUsuario = mUsuario;
	}
	public String gettipoRefeicao() {
		return this.tipoRefeicao;
	}
	public void settipoRefeicao(String tRefeicao) {
		this.tipoRefeicao = tRefeicao;
	}
}
