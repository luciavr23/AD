package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="DEPARTAMENTO" ,catalog="ejercicio3")
public class Departamento implements Serializable {
	
	@Id
	@Column(name="CODDEPT",unique= true, nullable=false)
	private Integer codDept;
	
	@Column(name="DNOMBRE")
	private String dNombre;
	
	@Column(name="PRESU")
	private Double presu; 
	
	//asociaciones 1:n
	@OneToMany(targetEntity=Empleado.class)
	@JoinColumn(name="CODDEPTO_FK") //COLUMNA QUE SE VA A CREAR EN EMPLEADO
	private List<Empleado> empleados;
	
	//asociaciones 1:n
	@OneToMany(targetEntity=Proyecto.class,mappedBy="dept")//aqui se pone ONeToMany porq un departamento tiene varios 
	//proyectos, el oneToMany se pone en la entidad que contenga la lista.
	//el mappedBy se pone en las relaciones 1:n bidireccional y hay que ponerle el nombre del objeto
	//de esta entidad en la ntidad proyecto
	//@JoinColumn(name="CODDEPTO_FK") este falla en la 1:n bidireccional
	private List<Proyecto> proyectos;

	
	
	public Departamento() {

	}

	public Departamento(Integer codDept, String dNombre, Double presu) {
		super();
		this.codDept = codDept;
		this.dNombre = dNombre;
		this.presu = presu;
		this.empleados=new ArrayList <Empleado>();
		this.proyectos=new ArrayList <Proyecto>();
	}

	public Departamento(String dNombre, Double presu) {
		super();
		this.dNombre = dNombre;
		this.presu = presu;
		this.empleados = empleados;
		this.empleados=new ArrayList <Empleado>();
		this.proyectos=new ArrayList <Proyecto>();
	}
    //AÑADIR Y BORRAR EMPLEADOS
	public void addEmpleado(Empleado e) {
		this.empleados.add(e);
	}
	public void removeEmpleado(Empleado e) {
		this.empleados.remove(e);
	}
	//AÑADIR Y BORRAR EMPLEADOS
		public void addProyecto(Proyecto p) {
			this.proyectos.add(p);
			p.setDept(this); //como es bidireccional asignamos al proyecto este departamento
		}
		public void removeProyecto(Proyecto p) {
			this.proyectos.remove(p);
			p.setCodProy(null);
		}
		

	@Override
	public String toString() {
		return "Departamento [codDept=" + codDept + ", dNombre=" + dNombre + ", presu=" + presu + "]";
	}

	public Integer getCodDept() {
		return codDept;
	}

	public void setCodDept(Integer codDept) {
		this.codDept = codDept;
	}

	public String getdNombre() {
		return dNombre;
	}

	public void setdNombre(String dNombre) {
		this.dNombre = dNombre;
	}

	public Double getPresu() {
		return presu;
	}

	public void setPresu(Double presu) {
		this.presu = presu;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}	
	
}
