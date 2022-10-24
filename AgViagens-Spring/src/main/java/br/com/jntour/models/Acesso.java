package br.com.jntour.models;

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

@Entity
@Table(name = "acesso")
public class Acesso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_acesso;
	@Column(nullable = false, length = 10, unique = true)
	private String tipo;

	@OneToMany(mappedBy = "acesso")
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public Acesso() {
	}

	public Acesso(Long id_acesso, String tipo) {
		super();
		this.id_acesso = id_acesso;
		this.tipo = tipo;
	}

	public Long getId_acesso() {
		return id_acesso;
	}

	public void setId_acesso(Long id_acesso) {
		this.id_acesso = id_acesso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientes, id_acesso, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		return Objects.equals(clientes, other.clientes) && Objects.equals(id_acesso, other.id_acesso)
				&& Objects.equals(tipo, other.tipo);
	}

}
