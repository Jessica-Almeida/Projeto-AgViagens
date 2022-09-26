package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destino;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {
		String sql = "INSERT INTO destino (pais, cidade, data_ida, data_volta, preco) values(?,?,?,?,?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
			pstm.setDate(3, new Date(destino.getDataIda().getTime()));
			pstm.setDate(4, new Date(destino.getDataVolta().getTime()));
			pstm.setDouble(5, destino.getPreco());
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

	public List<Destino> getDestino() {
		String sql = "select * from destino;";

		List<Destino> destinos = new ArrayList<Destino>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();

				destino.setId(rset.getInt("id_destino"));
				destino.setPais(rset.getString("pais"));
				destino.setCidade(rset.getString("cidade"));
				destino.setDataIda(rset.getDate("data_ida"));
				destino.setDataVolta(rset.getDate("data_volta"));
				destino.setPreco(rset.getDouble("preco"));
				destinos.add(destino);

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

		return destinos;
	}

	public void update(Destino destino) {
		String sql = "UPDATE destino set pais = ?, cidade = ?, data_ida = ?, data_volta = ?, preco = ? WHERE id_destino = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
			pstm.setDate(3, new Date(destino.getDataIda().getTime()));
			pstm.setDate(4, new Date(destino.getDataVolta().getTime()));
			pstm.setDouble(5, destino.getPreco());
			pstm.setInt(6, destino.getId());

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
		String sql = "DELETE FROM destino WHERE id_destino = ?";

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

	public Destino getDestinoById(int id) {
		String sql = "SELECT * FROM destino WHERE id_destino = ?;";

		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();
			destino.setId(rset.getInt("id_destino"));
			destino.setPais(rset.getString("pais"));
			destino.setCidade(rset.getString("cidade"));
			destino.setDataIda(rset.getDate("data_ida"));
			destino.setDataVolta(rset.getDate("data_volta"));
			destino.setPreco(rset.getDouble("preco"));

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

		return destino;
	}

}