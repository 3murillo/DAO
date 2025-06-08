package entidade;

import java.util.Objects;

public class Curso {

	int idCurso;
	String nomeCurso;
	
	public Curso(int idCurso, String nomeCurso) {
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
	}

	public Curso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	
	public int getIdCurso() {
		return idCurso;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(nomeCurso);
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(nomeCurso, other.nomeCurso);
	}


	
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", nomeCurso=" + nomeCurso + "]";
	}
	
}