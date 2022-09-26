package model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Destino {
	private int id;
	private String pais;
	private String cidade;
	private double preco;
	private Date dataIda;
	private Date dataVolta;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Destino() {
	}

	public Destino(int id, String pais, String cidade, double preco, Date dataIda, Date dataVolta,
			DateTimeFormatter formatter) {
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
		this.preco = preco;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.formatter = formatter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataIda() {
		return dataIda;
	}

	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

}