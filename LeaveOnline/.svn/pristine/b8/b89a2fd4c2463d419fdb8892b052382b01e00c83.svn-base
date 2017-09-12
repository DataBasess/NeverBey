package com.epro.leave.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;
import com.epro.infrastructure.util.JsonDateSerializer;
import com.epro.leave.common.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "employee")
@DynamicUpdate
@SelectBeforeUpdate
public class Employee extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pk_sequence", sequenceName = "employee_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "employee_code", nullable = false, length = 10)
	private String employeeCode;

	@Column(name = "identification_number", nullable = true, length = 17)
	private String identificationNumber;

	@Column(name = "employee_firstname", nullable = false, length = 50)
	private String employeeFirstName;

	@Column(name = "employee_lastname", nullable = false, length = 50)
	private String employeeLastName;

	@Column(name = "employee_nickname", nullable = true, length = 50)
	private String employeeNickname;

	@Column(name = "email_address")
	private String emailAddress;

	@Formula("(concat(employee_prefix,' ',employee_firstname,' ',employee_lastname ))")
	private String employeePrefixFullName;

	@Formula("(concat(employee_firstname,' ',employee_lastname ))")
	private String employeeFullName;

	/*
	 * @Formula("(concat(employee_firstname,' ',employee_lastname ,' (',(select center.center_name from center where center.center_id = belong_to_center_id),')'))"
	 * ) private String employeeFullNameCenter;
	 */
	@Column(name = "employee_tel_no", length = 13)
	private String employeeTelNo;

	@Column(name = "employee_start_date")
	private Date employeeStartDate;

	@Column(name = "employee_resign_date")
	private Date employeeResignDate;

	@ManyToOne()
	@JoinColumnsOrFormulas(value = {
			@JoinColumnOrFormula(column = @JoinColumn(name = "employee_prefix", referencedColumnName = "code", nullable = true)),
			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "table_code", value = "'"
					+ Constant.TABLE_NAME_PREFIX + "'")) })
	private ParameterTableDetail employeePrefix;

	@Column(name = "active_flag", nullable = true, length = 5)
	private Boolean activeFlag;

	@Column(name = "profile_image", columnDefinition = "TEXT")
	private String profileImage;

	@ManyToOne()
	@JoinColumnsOrFormulas(value = {
			@JoinColumnOrFormula(column = @JoinColumn(name = "cause_of_resign", referencedColumnName = "code", nullable = true)),
			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "table_code", value = "'"
					+ Constant.TABLE_CAUSE_OF_VALUE + "'")) })
	private ParameterTableDetail causeOfResign;
	

	@Column(name = "employee_address")
	private String employeeAddress;

	@Column(name = "probation_flag")
	private Boolean probationFlag;
	
	@ManyToOne()
	@JoinColumnsOrFormulas(value = {
			@JoinColumnOrFormula(column = @JoinColumn(name = "employee_position", referencedColumnName = "code", nullable = true)),
			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "table_code", value = "'"
					+ Constant.TABLE_POSITION_TYPE + "'")) })
	private ParameterTableDetail employeePosition;

	@ManyToOne()
	@JoinColumnsOrFormulas(value = {
			@JoinColumnOrFormula(column = @JoinColumn(name = "employee_department", referencedColumnName = "code", nullable = true)),
			@JoinColumnOrFormula(formula = @JoinFormula(referencedColumnName = "table_code", value = "'"
					+ Constant.TABLE_DEPARTMENT_TYPE + "'")) })
	private ParameterTableDetail employeeDepartment;

	/*
	 * @Formula("(array_to_string( (select array_agg(center.center_name) from center inner join employee_belong_to_second on employee_belong_to_second.center_id = center.center_id and employee_belong_to_second.employee_id = employee_id),','))"
	 * ) private String belongToCenterSecond;
	 */

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public ParameterTableDetail getCauseOfResign() {
		return causeOfResign;
	}

	public void setCauseOfResign(ParameterTableDetail causeOfResign) {
		this.causeOfResign = causeOfResign;
	}

	public Boolean getProbationFlag() {
		return probationFlag;
	}

	public void setProbationFlag(Boolean probationFlag) {
		this.probationFlag = probationFlag;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeTelNo() {
		return employeeTelNo;
	}

	public void setEmployeeTelNo(String employeeTelNo) {
		this.employeeTelNo = employeeTelNo;
	}


	public Date getEmployeeStartDate() {
		return employeeStartDate;
	}

	
	public void setEmployeeStartDate(Date employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}


	public Date getEmployeeResignDate() {
		return employeeResignDate;
	}


	public void setEmployeeResignDate(Date employeeResignDate) {
		this.employeeResignDate = employeeResignDate;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@JsonIgnore
	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getEmployeePrefixFullName() {
		return employeePrefixFullName;
	}

	public void setEmployeePrefixFullName(String employeePrefixFullName) {
		this.employeePrefixFullName = employeePrefixFullName;
	}

	public String getEmployeeFullName() {
		return employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getEmployeeNickname() {
		return employeeNickname;
	}

	public void setEmployeeNickname(String employeeNickname) {
		this.employeeNickname = employeeNickname;
	}

	public ParameterTableDetail getEmployeePrefix() {
		return employeePrefix;
	}

	public void setEmployeePrefix(ParameterTableDetail employeePrefix) {
		this.employeePrefix = employeePrefix;
	}

	

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public ParameterTableDetail getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(ParameterTableDetail employeePosition) {
		this.employeePosition = employeePosition;
	}

	public ParameterTableDetail getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(ParameterTableDetail employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	/*
	 * public String getBelongToCenterSecond() { return belongToCenterSecond; }
	 * 
	 * public void setBelongToCenterSecond(String belongToCenterSecond) {
	 * this.belongToCenterSecond = belongToCenterSecond; }
	 * 
	 * public String getEmployeeFullNameCenter() { return employeeFullNameCenter; }
	 * 
	 * public void setEmployeeFullNameCenter(String employeeFullNameCenter) {
	 * this.employeeFullNameCenter = employeeFullNameCenter; }
	 */

}
