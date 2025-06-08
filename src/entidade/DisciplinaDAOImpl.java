package entidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;

public class DisciplinaDAOImpl implements DisciplinaDAO {

	private Connection cnx;

	public DisciplinaDAOImpl(Connection cnx) {
		this.cnx = cnx;
	}

	@Override
	public void insert(Disciplina d) throws SQLException {
		String sql = "INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?)";
		try (PreparedStatement pst = cnx.prepareStatement(sql)) {
			pst.setString(1, d.getNomeDisciplina());
			pst.setInt(2, d.getCargaHoraria());
			pst.executeUpdate();
			System.out.println("Disciplina inserida com sucesso!");
		}
	}

	@Override
	public void update(Disciplina d) throws SQLException {
		String sql = "UPDATE disciplina SET nomedisciplina=?, cargahoraria=? WHERE iddisciplina=?";
		try (PreparedStatement pst = cnx.prepareStatement(sql)) {
			pst.setString(1, d.getNomeDisciplina());
			pst.setInt(2, d.getCargaHoraria());
			pst.setInt(3, d.getIdDisciplina());
			int linhas = pst.executeUpdate();
			System.out.println(linhas > 0 ? "Disciplina atualizada!" : "Disciplina não encontrada.");
		}
	}

	@Override
	public void deleteById(Integer id) throws SQLException {
		String sql = "DELETE FROM disciplina WHERE iddisciplina=?";
		try (PreparedStatement pst = cnx.prepareStatement(sql)) {
			pst.setInt(1, id);
			int linhas = pst.executeUpdate();
			System.out.println(linhas > 0 ? "Disciplina deletada!" : "Disciplina não encontrada.");
		}
	}

	@Override
	public List<Disciplina> findAll() throws SQLException {
		List<Disciplina> lista = new ArrayList<>();
		String sql = "SELECT * FROM disciplina";
		try (Statement st = cnx.createStatement();
			 ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Disciplina d = new Disciplina(
					rs.getInt("iddisciplina"),
					rs.getString("nomedisciplina"),
					rs.getInt("cargahoraria")
				);
				lista.add(d);
			}
		}
		return lista;
	}

	@Override
	public Disciplina findById(Integer id) throws SQLException {
		String sql = "SELECT * FROM disciplina WHERE iddisciplina=?";
		try (PreparedStatement pst = cnx.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new Disciplina(
					rs.getInt("iddisciplina"),
					rs.getString("nomedisciplina"),
					rs.getInt("cargahoraria")
				);
			}
		}
		return null;
	}
}
