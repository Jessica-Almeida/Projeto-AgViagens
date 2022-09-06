package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {
	private int id;
	private LocalDate data;
	private int quantidade;
	private double total;
	private Destino destino;
	private Cliente cliente;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Compra() {
	}

	public Compra(String data, int quantidade, Destino destino, Cliente cliente) {

		this.data = LocalDate.parse(data, formatter);
		this.quantidade = quantidade;
		this.total = valorTotal(destino.getPreco());
		this.destino = destino;
		this.cliente = cliente;

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return formatter.format(data);
	}

	public void setData(String data) {
		this.data = LocalDate.parse(data, formatter);
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
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private double valorTotal(double preco) {
		return this.total = this.quantidade * preco;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", data=" + data + ", quantidade=" + quantidade + ", total=" + total + "]";
	}

}
