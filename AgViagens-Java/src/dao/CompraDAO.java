package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Compra;
import modelo.Destino;
import modelo.Cliente;

public class CompraDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Compra compra) {
		String sql = "INSERT INTO compra (data_compra, quantidade, total, id_destino, id_cliente) values(?,?,?,?,?)";

		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(1, new Date(formatter.parse(compra.getData()).getTime()));
			pstm.setInt(2, compra.getQuantidade());
			pstm.setDouble(3, compra.getTotal());
			pstm.setInt(4, compra.getDestino().getId());
			pstm.setInt(5, compra.getCliente().getId());
			
			

			
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


	public List<Compra> getCompra() {
		String sql = "select * from compra;";

		List<Compra> compras = new ArrayList<Compra>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();
				Destino destino = new Destino();
				Cliente cliente = new Cliente();

				compra.setId(rset.getInt("id_compra"));
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				compra.setData(formatter.format(rset.getDate("data_compra")));
				compra.setQuantidade(rset.getInt("quantidade"));
				compra.setTotal(rset.getDouble("total"));
				destino.setId(rset.getInt("id_destino"));
				cliente.setId(rset.getInt("id_cliente"));
				

				compras.add(compra);

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

		return compras;
	}


	public void update(Compra compra) {
		String sql = "UPDATE compra set data_compra = ?, quantidade = ?, total = ?, id_destino = ?, id_cliente = ?" + "WHERE id_compra = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
			pstm.setDate(1, new Date(formatter.parse(compra.getData()).getTime()));
			pstm.setInt(2, (compra.getQuantidade()));
			pstm.setDouble(3, compra.getTotal());
			pstm.setInt(4, compra.getDestino().getId());
			pstm.setInt(5, compra.getCliente().getId());
			pstm.setInt(6, compra.getId());
		
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
		String sql = "DELETE FROM compra WHERE id_compra = ?";

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

	public Compra getCompraById(int id) {
		String sql = "SELECT * FROM compra WHERE id_compra = ?;";

		Compra compra = new Compra();
		Destino destino = new Destino();
		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();
			compra.setId(rset.getInt("id_compra"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			compra.setData(formatter.format(rset.getDate("data_compra")));
			compra.setQuantidade(rset.getInt("quantidade"));
			compra.setTotal(rset.getDouble("total"));
			destino.setId(rset.getInt("id_destino"));
			cliente.setId(rset.getInt("id_cliente"));
			

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

		return compra;
	}

}
