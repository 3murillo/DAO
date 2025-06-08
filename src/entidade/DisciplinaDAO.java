package entidade;

import java.sql.SQLException;
import java.util.List;

public interface DisciplinaDAO {
	void insert(Disciplina d) throws SQLException;
	void update(Disciplina d) throws SQLException;
	void deleteById(Integer id) throws SQLException;
	List<Disciplina> findAll() throws SQLException;
	Disciplina findById(Integer id) throws SQLException;
}
