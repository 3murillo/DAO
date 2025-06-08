package entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;

public class CursoDAOImpl implements  CursoDAO {
	
	private Connection cnx;
	
	public CursoDAOImpl(Connection conexao) {
		this.cnx = conexao;
	}
	
	@Override
	public void insert(Curso obj) throws SQLException {
		
		PreparedStatement pst = null;
		String sql = "INSERT INTO curso (nomeCurso) VALUES (?)";

		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, obj.getNomeCurso());
			if (pst.executeUpdate() >= 1)
				System.out.println("Curso " + obj.getNomeCurso() + " inserido com sucesso!");
			else  
				System.out.println("Erro: não foi possível Cadastrar o curso " + obj.getNomeCurso() + " !");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			pst.close();
		}
	}

	@Override
	public void update(Curso obj) throws SQLException {
		
		PreparedStatement pst = null;
		try {
			pst = cnx.prepareStatement("UPDATE curso"
									+ " SET nomeCurso = ?"
									+ "	WHERE idCurso=?");
			pst.setString(1, obj.getNomeCurso());
			pst.setInt(2, obj.getIdCurso());
			
			int linhas = pst.executeUpdate();
			if (linhas > 0) {	
				System.out.println("Curso (id: " + obj.getIdCurso() + ") alterado com sucesso!");
			}
			else {
				System.out.println("Não foi realizada a alteração do Curso!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			pst.close();
		}
		
	}

	@Override
	public void deleteById(Integer id) throws SQLException {
		
		PreparedStatement pst = null;
		String sql = "DELETE FROM curso WHERE idCurso = ?";

		try {
			pst = cnx.prepareStatement(sql);
			pst.setInt(1, id);
			if (pst.executeUpdate() >= 1)
				System.out.println("Curso foi excluido com sucesso!");
			else  
				System.out.println("Erro: não foi possível excluir o curso!");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			pst.close();
		}
	}

	@Override
	public List<Curso> findAll() throws SQLException {
		
		List<Curso> cursos = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = cnx.createStatement();
			rs = st.executeQuery("SELECT * FROM curso");
			while (rs.next()) {
				Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nomeCurso"));
				cursos.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
		}
		return cursos;
	}

	@Override
	public Curso findById(Integer id) throws SQLException {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = cnx.prepareStatement("SELECT * FROM curso WHERE idCurso = ?");
			pst.setInt(1, id);	
			rs = pst.executeQuery();
			if (rs.next())
				return new Curso(rs.getInt("idCurso"), rs.getString("nomeCurso"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		return null;
	}
}