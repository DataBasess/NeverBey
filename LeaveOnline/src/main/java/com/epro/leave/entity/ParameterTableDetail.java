package com.epro.leave.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;
import com.epro.leave.common.Constant;

@Entity
@Table(name = "parameter_table_detail", uniqueConstraints = {
	      @UniqueConstraint(
		          columnNames = {"table_code", "code"},
		          name="uk_reference_data_list"
		      )
		   })
@DynamicUpdate
@SelectBeforeUpdate
public class ParameterTableDetail extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="parameter_table_detail_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "table_code", nullable = false, length = 50)
	private String tableCode ;
	
	@Column(name = "code", nullable = false, length = 50)
	private String code;
	
	// for display only.
	@Formula("(array_to_string(array(select ref.description from parameter_table_detail ref where ref.code =ANY (string_to_array(parent_code,',') )and ref.table_code='"+Constant.TABLE_SERVICE_POINT_TYPE+"'),','))  ")
	private String parentCodeDescription;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "note")
	private String note;
	
	@Column(name = "sequence")
	private String sequence;
	

	@Column(name = "parent_code")
	private String parentCode;
	
	@Column(name = "parent_table_code")
	private String parentTableCode;
	

	@Column(name = "active_flag", nullable = true, length = 5)
	private Boolean activeFlag;

	public String getParentCodeDescription() {
		return parentCodeDescription;
	}

	public void setParentCodeDescription(String parentCodeDescription) {
		this.parentCodeDescription = parentCodeDescription;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}


	public String getParentTableCode() {
		return parentTableCode;
	}

	public void setParentTableCode(String parentTableCode) {
		this.parentTableCode = parentTableCode;
	}
}