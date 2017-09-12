package com.epro.leave.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;

@Entity
@Table(name = "parameter_table_header")
public class ParameterTableHeader extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="p_table_header_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "p_header_id")
	private Integer pHeaderId;
	
	@Column(name = "p_header_name")
	private String pHeaderName;
	
	@Column(name = "p_header_code")
	private String pHeaderCode;
	
	@Column(name = "p_header_description")
	private String pHeaderDescription;
	
	
	
	public Integer getpHeaderId() {
		return pHeaderId;
	}
	public void setpHeaderId(Integer pHeaderId) {
		this.pHeaderId = pHeaderId;
	}
	public String getpHeaderName() {
		return pHeaderName;
	}
	public void setpHeaderName(String pHeaderName) {
		this.pHeaderName = pHeaderName;
	}
	public String getpHeaderCode() {
		return pHeaderCode;
	}
	public void setpHeaderCode(String pHeaderCode) {
		this.pHeaderCode = pHeaderCode;
	}
	public String getpHeaderDescription() {
		return pHeaderDescription;
	}
	public void setpHeaderDescription(String pHeaderDescription) {
		this.pHeaderDescription = pHeaderDescription;
	}
	
	
}
