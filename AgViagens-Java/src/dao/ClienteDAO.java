package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Acesso;
import modelo.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, email, senha, cpf, id_acesso) values(?,?,?,?,?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getSenha());
			pstm.setString(4, cliente.getCpf());
			pstm.setInt(5, cliente.getAcesso().getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<Cliente> getCliente() {
		String sql = "select * from cliente;";

		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();
				Acesso acesso = new Acesso();

				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setEmail(rset.getString("email"));
				cliente.setSenha(rset.getString("senha"));
				cliente.setCpf(rset.getString("cpf"));
				acesso.setId(rset.getInt("id_acesso"));

				clientes.add(cliente);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return clientes;
	}


	public void update(Cliente cliente) {
		String sql = "UPDATE cliente set nome = ?, email = ?, senha = ?, cpf = ?, id_acesso = ? WHERE id_cliente = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getSenha());
			pstm.setString(4, cliente.getCpf());
			pstm.setInt(5, cliente.getAcesso().getId());
			pstm.setInt(6, cliente.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void deleteById(int id) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Cliente getClienteById(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";

		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome"));
			cliente.setEmail(rset.getString("email"));
			cliente.setSenha(rset.getString("senha"));
			cliente.setCpf(rset.getString("cpf"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return cliente;
	}

}