package entidad;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the TEMP_EQUIPO_JUGADOR database table.
 * 
 */
@Embeddable
public class TempEquipoJugadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODTEMP", insertable=false, updatable=false)
	private String codtemp;

	@Column(name="CODEQUIPO", insertable=false, updatable=false)
	private String codequipo;

	@Column(name="CODJUGADOR", insertable=false, updatable=false)
	private String codjugador;

	public TempEquipoJugadorPK() {
	}
	public String getCodtemp() {
		return this.codtemp;
	}
	public void setCodtemp(String codtemp) {
		this.codtemp = codtemp;
	}
	public String getCodequipo() {
		return this.codequipo;
	}
	public void setCodequipo(String codequipo) {
		this.codequipo = codequipo;
	}
	public String getCodjugador() {
		return this.codjugador;
	}
	public void setCodjugador(String codjugador) {
		this.codjugador = codjugador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TempEquipoJugadorPK)) {
			return false;
		}
		TempEquipoJugadorPK castOther = (TempEquipoJugadorPK)other;
		return 
			this.codtemp.equals(castOther.codtemp)
			&& this.codequipo.equals(castOther.codequipo)
			&& this.codjugador.equals(castOther.codjugador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codtemp.hashCode();
		hash = hash * prime + this.codequipo.hashCode();
		hash = hash * prime + this.codjugador.hashCode();
		
		return hash;
	}
}