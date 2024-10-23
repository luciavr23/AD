package entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity 

@Table(name="EMPLEADO",catalog="ejercicio3")
public class Empleado implements Serializable{
private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="CODEMPLEADO",unique=true,nullable=false)
    private String codEmpleado;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column (name="APELLIDOS")
    private String apellidos;
    //asociacion unidireccional one to one 
    //para añadir esta restriccion hay que especificar unique=true,nullable=false,updatable=false
    //sino con anotar la restriccion en table es suficiente
    @OneToOne //añadir el tipo de asociacion
    @JoinColumn(name="DIRECCION_FK",unique=true,nullable=false,updatable=false) //se especifica
    //el nombre de la columna que va a surgir del join, se creara una nueva columna
    //llamada DIRECCION_FK
    private Direccion dir;
    
    @OneToOne(targetEntity=PlazaParking.class) //inidica que voy a relacionarlo con plaza parking,no hace
    //falta ponerlo ya q es informacion redundante
    @JoinColumn (name="PLAZA_FK",unique=true,nullable=false,updatable=false)
    private PlazaParking plaza;
    
    
    public Empleado() {
	
	}
    
    public Empleado(String codEmpleado, String nombre, String apellidos, Direccion dir) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dir = dir;
	}

	public Empleado(String codEmpleado, String nombre, String apellidos,Direccion dir,PlazaParking plaza) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dir=dir;
		this.plaza=plaza;
	}
    public Empleado(String codEmpleado, String nombre, String apellidos) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
    
    
    public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

	public PlazaParking getPlaza() {
		return plaza;
	}

	public void setPlaza(PlazaParking plaza) {
		this.plaza = plaza;
	}

	@Override
	public String toString() {
		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	public String getCodEmpleado() {
        return codEmpleado;
    }


	public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
