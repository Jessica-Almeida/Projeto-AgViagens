package br.com.jntour.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	@Column(nullable = false, length = 80, unique = true)
	private String nome;
	@Column(nullable = false, length = 80, unique = true)
	private String email;
	private String senha;
	@Column(nullable = false, length = 14, unique = true)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "id_acesso")
	private Acesso acesso;

	public Cliente() {
	}

	public Cliente(Long id_cliente, String nome, String email, String senha, String cpf, Acesso acesso) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.acesso = acesso;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acesso, cpf, email, id_cliente, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(acesso, other.acesso) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(id_cliente, other.id_cliente)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha);
	}

}
