package model;

import java.util.Date;

public class Compra {
	private int id;
	private Date data;
	private int quantidade;
	private double total;
	private Destino destino;
	private Cliente cliente;

	public Compra() {
	}

	public Compra(int id, int quantidade, Destino destino, Cliente cliente) {
		this.id = id;
		this.quantidade = quantidade;
		this.total = destino.getPreco();
		this.destino = destino;
		this.cliente = cliente;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;

	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
		this.total = destino.getPreco() * this.quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", data=" + data + ", quantidade=" + quantidade + ", total=" + total + "]";
	}

}
