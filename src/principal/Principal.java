package principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.DB;
import entidade.Curso;
import entidade.CursoDAO;
import entidade.CursoDAOImpl;
import entidade.Disciplina;
import entidade.DisciplinaDAO;
import entidade.DisciplinaDAOImpl;
public class Principal {

	public static void main(String[] args) throws SQLException {

		Scanner console = new Scanner(System.in);
		Connection cnx = DB.getConexao();

		if (cnx != null) {
			System.out.println("Conexão realizada!");
		}
		
		DisciplinaDAO dao = new DisciplinaDAOImpl(DB.getConexao());

		// Teste de inserção
		Disciplina d1 = new Disciplina("Estrutura de Dados", 60);
		dao.insert(d1);

		// Listar disciplinas
		List<Disciplina> disciplinas = dao.findAll();
		for (Disciplina d : disciplinas) {
			System.out.println(d);
		}


		// Objeto DAO para Curso
		CursoDAO cursoDao = new CursoDAOImpl(DB.getConexao());
		
		// Teste - Insert
		//Curso c = new Curso("Teste");
		//cursoDao.insert(c);
		//console.nextLine();
		
		// Teste - Delete
		//cursoDao.deleteById(3);
		//console.nextLine();

		// Teste - Update
		//Curso c1 = new Curso(3, "Teste3");
		//cursoDao.update(c1);
		//console.nextLine();
		
		// Teste - Select All
		//List<Curso> listaCurso = cursoDao.findAll();
		//System.out.println("Lista dos Cursos");
		//for (Curso c : listaCurso) {
		//	System.out.println(c);
		//}

		// Teste - Select Curso por idCurso
		//Curso c = cursoDao.findById(2);
		//System.out.println(c);
	}

}