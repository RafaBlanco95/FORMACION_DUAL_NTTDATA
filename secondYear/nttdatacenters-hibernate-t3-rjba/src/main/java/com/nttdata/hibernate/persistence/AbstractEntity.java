package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
/**
 * Clase Abstracta de la que van a heredar todas las entidades de la BBDD
 * 
 * @author RAFA
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{
	
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría | Usuario que actualiza */
	private String updatedUser;

	/** Auditoría | Día actualizado */
	private Date updatedDate;
	
	/**
	 * GET ID
	 * 
	 * @return Long 
	 */
	@Transient
	public abstract Long getId();

	/**
	 * SET ID
	 * 
	 * @param id El identificador
	 */
	@Transient
	public abstract void setId(final Long id);

	/**
	 * @return updatedUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser El ususario actualizado
	 *            
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate La fecha actualizada
	 *            
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
