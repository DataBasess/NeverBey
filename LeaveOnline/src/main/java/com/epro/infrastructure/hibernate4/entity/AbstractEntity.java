package com.epro.infrastructure.hibernate4.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 * @author Nattawut Verarattakul
 * @author Channawit Yaithong
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 4092499842085705660L;
	
	@Column(name = "created_by", updatable=false, length=15)
	private String createdBy;
	
	@Column(name = "created_date", updatable=false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "updated_by", length=15)
	private String updatedBy ;
	
	@Column(name = "updated_date")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@Column(name = "updated_by_program",length=30)
	private String updatedByProgram;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedByProgram() {
		return updatedByProgram;
	}

	public void setUpdatedByProgram(String updatedByProgram) {
		this.updatedByProgram = updatedByProgram;
	}
}
