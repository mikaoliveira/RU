package br.ufpb.sisru;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	public Data (int dia,int mes,int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	public String toString() {
		String msg = "Data: "+this.dia+"/"+this.mes+"/"+this.ano;
		return msg;
	}
	public int getdia() {
		return this.dia;
	}
	public void setdia(int d) {
		this.dia = d;
	}
	public int getmes() {
		return this.mes;
	}
	public void setmes(int m) {
		this.mes = m;
	}
	public int getano() {
		return this.ano;
	}
	public void setano(int a) {
		this.ano = a;
	}
}
