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
		return total = valorTotal();
	}

	public void setTotal(double total) {
		this.total = total;
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
		return this.total =  this.quantidade * this.destino.getPreco();
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", data=" + data + ", quantidade=" + quantidade + ", total=" + total + "]";
	}

}
