package entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PROYECTO" , catalog="ejercicio3")
public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CODPROY",unique=true,nullable=false)
	private Integer codProy;
	
	@Column(name="PNOMBRE")
	private String pNombre;
	
	@ManyToOne(targetEntity=Departamento.class) //aqui es many to one pq muchos proyectos van a tener 1 
	//dpto, el manyToOne hay q ponerlo solo en las relaciones 1:n bidireccionales en la entidad que no 
	//contiene la lista
    @JoinColumn (name="CODDEPTO_FK",unique=true,nullable=false,updatable=false)
    private Departamento dept;

	public Proyecto(Integer codProy, String pNombre, Departamento dept) {
		super();
		this.codProy = codProy;
		this.pNombre = pNombre;
		this.dept = dept;
	}

	public Proyecto(Integer codProy, String pNombre) {
		super();
		this.codProy = codProy;
		this.pNombre = pNombre;
	}

	public Integer getCodProy() {
		return codProy;
	}

	public void setCodProy(Integer codProy) {
		this.codProy = codProy;
	}

	public String getpNombre() {
		return pNombre;
	}

	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}

	public Departamento getDept() {
		return dept;
	}

	public void setDept(Departamento dept) {
		this.dept = dept;
	}
	
	

}
