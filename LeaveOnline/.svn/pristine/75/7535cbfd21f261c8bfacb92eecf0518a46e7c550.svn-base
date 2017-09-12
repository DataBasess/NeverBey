package com.epro.infrastructure.security.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.epro.leave.entity.Employee;
import com.epro.infrastructure.hibernate4.entity.AbstractEntity;
import com.epro.infrastructure.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Nattawut Verarattakul
 * @customize Worachet Suparat
 * @customize Watsaphol Koongaew
 */

@Entity
@Table(name = "users")
//@org.hibernate.annotations.Entity(dynamicUpdate = true, selectBeforeUpdate = true)
@DynamicUpdate
@SelectBeforeUpdate
public class User extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1391670498250658953L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@Column(name = "effective_date")
	private Date effectiveDate;
	
//	@Column(name = "cs_level")
//	private Integer csLevel;
	
	@ManyToOne()
	@JoinColumn(name="user_id", referencedColumnName="employee_id", foreignKey = @ForeignKey(name="users_fk1"))
	private Employee employeeObjectemployeeId;

	@ManyToOne()
	@JoinColumn(name = "authority_id", referencedColumnName="id",foreignKey = @ForeignKey(name="users_fk2"))
	private Authority authorities;

	
	
	/*@ManyToOne()
	@JoinColumnsOrFormulas(value = {
			@JoinColumnOrFormula(column = @JoinColumn(name = "user_type", referencedColumnName = "code", nullable = true)),
			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "table_code", value = "'"+Constant.TABLE_USER_TYPE+"'")) })
	private ReferenceDataList userType;
	*/
	
	@Column(name = "user_type" ,columnDefinition="varchar(50) default 'NORMAL'",nullable=false)
	private String userType; // NORMAL,MOBILE_CAR,MOBILE_CENTER

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

//	public Integer getCsLevel() {
//		return csLevel;
//	}
//
//	public void setCsLevel(Integer csLevel) {
//		this.csLevel = csLevel;
//	}

	public Employee getEmployeeObjectemployeeId() {
		return employeeObjectemployeeId;
	}

	public void setEmployeeObjectemployeeId(Employee employeeObjectemployeeId) {
		this.employeeObjectemployeeId = employeeObjectemployeeId;
	}

	public Authority getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


}