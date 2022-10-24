package br.com.jntour.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "destino")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_destino;
	@Column(nullable = false, length = 50)
	private String pais;
	@Column(nullable = false, length = 50, unique = true)
	private String cidade;
	private double preco;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataIda;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataVolta;

	@OneToMany(mappedBy = "destino")
	private List<Compra> compras = new ArrayList<Compra>();

	public Destino() {
	}

	public Destino(Long id_destino, String pais, String cidade, double preco, LocalDate dataIda, LocalDate dataVolta) {
		super();
		this.id_destino = id_destino;
		this.pais = pais;
		this.cidade = cidade;
		this.preco = preco;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
	}

	public Long getId_destino() {
		return id_destino;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public void setId_destino(Long id_destino) {
		this.id_destino = id_destino;
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

	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(LocalDate dataVolta) {
		this.dataVolta = dataVolta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, compras, dataIda, dataVolta, id_destino, pais, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(compras, other.compras)
				&& Objects.equals(dataIda, other.dataIda) && Objects.equals(dataVolta, other.dataVolta)
				&& Objects.equals(id_destino, other.id_destino) && Objects.equals(pais, other.pais)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

}
