package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Destino {
	private int id;
	private String pais;
	private String cidade;
	private double preco;
	private LocalDate dataIda;
	private LocalDate dataVolta;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Destino() {
	}

	public Destino(int id, String pais, String cidade, String dataIda, String dataVolta, double preco) {
		this.id = id;
		this.pais = pais;
		this.cidade = cidade;
		this.dataIda = LocalDate.parse(dataIda, formatter);
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
		this.preco = preco;
		
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

	public String getDataIda() {
		return formatter.format(dataIda);
	}

	public void setDataIda(String dataIda) {
		this.dataIda = LocalDate.parse(dataIda, formatter);
	}

	public String getDataVolta() {
		return formatter.format(dataVolta);
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
	}

}
