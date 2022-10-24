package br.com.jntour.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	@Column(nullable = false, length = 100)
	private int quantidade;
	private double total;
	@ManyToOne
	@JoinColumn(name = "id_destino")
	private Destino destino;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Compra() {
	}

	public Compra(Long id, int quantidade, Destino destino, Cliente cliente) {
		this.id_compra = id;
		this.quantidade = quantidade;
		this.destino = destino;
		this.cliente = cliente;

	}

	public Long getId_compra() {
		return id_compra;
	}

	public void setId(Long id) {
		this.id_compra = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total = valorTotal();
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private double valorTotal() {
		return this.total = this.quantidade * this.destino.getPreco();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, data, destino, id_compra, quantidade, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(data, other.data)
				&& Objects.equals(destino, other.destino) && Objects.equals(id_compra, other.id_compra)
				&& quantidade == other.quantidade
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}

}
