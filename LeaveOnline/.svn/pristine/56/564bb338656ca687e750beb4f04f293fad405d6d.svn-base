package com.epro.infrastructure.hibernate4.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.epro.leave.entity.Employee;

/**
 * @author Nattawut Verarattakul
 * @author Channawit Yaithong
 */
@MappedSuperclass
public abstract class AbstractEntityMobile extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// user update by
	@ManyToOne()
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id" , foreignKey = @ForeignKey(name = "employee_id_fk"), nullable = true)
	private  Employee employeeId;

	@Column(name = "employee_name")
	private  String employeeName;// temp log

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
