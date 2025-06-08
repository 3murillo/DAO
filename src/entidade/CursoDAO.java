package entidade;

import java.sql.SQLException;
import java.util.List;

public interface CursoDAO {

	public void insert(Curso obj) throws SQLException;
	public void update(Curso obj) throws SQLException;
	public void deleteById(Integer id) throws SQLException;
	public List<Curso> findAll() throws SQLException;
	public Curso findById(Integer id)throws SQLException;
	
}