package entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*La etiqueta Entity se utiliza para crear una entidad*/
@Entity

/*
 * La etiqueta @table crea una tabla con el nombre que indiques en la base de
 * datos que indiques en catalog, es decir, catalog es la BD donde vamos a
 * guardar la tabla creada
 */
@Table(name = "LIBROS", catalog = "ejercicio2")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * El Id indica que atributo es la clave primaria. Este se coloca encima del
	 * atributo PK
	 */
	@Id
	/* @Column especifica la columna de la tabla */
	@Column(name = "ISBN", unique = true, nullable = false)
	private String isbn;
	@Column(name = "AUTOR")
	private String autor;
	@Column(name = "PRESTADO")
	private byte prestado;
	@Column(name = "TITULO", unique = true, nullable = false)
	private String titulo;

	//LAS CLASES ENTIDAN TIENEN Q TENER EL CONSTRUCTOR VACIO POR DEFECTO SI O SI Y LOS GETTERS Y SETTERS
	public Libro() {

	}

	public Libro(String isbn, String autor,String titulo,byte prestado) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.prestado = prestado;
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public byte getPrestado() {
		return prestado;
	}

	public void setPrestado(byte prestado) {
		this.prestado = prestado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", autor=" + autor + ", prestado=" + prestado + ", titulo=" + titulo + "]";
	}

}
