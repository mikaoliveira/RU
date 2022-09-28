package br.ufpb.sisru;
public class Usuario {
	private String nome;
	private String matricula;
	private String cidadeResidencia;
	public Usuario (String n, String mat, String cidadeR) {
		this.nome = n;
		this.matricula = mat;
		this.cidadeResidencia = cidadeR;
	}
	public String toString(){
		String nEmat = nome + " de matricula: " + this.matricula;
		return nEmat;
	}
	public String getnome() {
		return this.nome;
	}
	public void setnome(String n) {
		this.nome = n;
	}
	public String getmatricula() {
		return this.matricula;
	}
	public void setmatricula(String mat) {
		this.matricula = mat;
	}
	public String getcidadeResidencia() {
		return this.cidadeResidencia;
	}
	public void setcidadeResidencia(String cidadeR) {
		this.cidadeResidencia = cidadeR;
	}
}
