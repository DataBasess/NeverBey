package com.epro.leave.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;

@Entity
@Table(name = "working_period_type")
public class WorkingPeriodType extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="working_period_type_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "working_period_type_id")
	private Integer workingPeriodTypeId;
	
	@Column(name = "leave_day")
	private Integer leaveDay;
	
	@Column(name = "working_period_type_year")
	private Integer workingPeriodYear;
	
	@ManyToOne
	@JoinColumn(name = "leave_type_id", referencedColumnName = "leave_type_id", nullable = false)
	public LeaveType leaveTypeId;
	

	public WorkingPeriodType(Integer workingPeriodTypeId, Integer leaveDay, Integer workingPeriodYear,
			LeaveType leaveTypeId) {
		super();
		this.workingPeriodTypeId = workingPeriodTypeId;
		this.leaveDay = leaveDay;
		this.workingPeriodYear = workingPeriodYear;
		this.leaveTypeId = leaveTypeId;
	}

	public Integer getWorkingPeriodTypeId() {
		return workingPeriodTypeId;
	}

	public void setWorkingPeriodTypeId(Integer workingPeriodTypeId) {
		this.workingPeriodTypeId = workingPeriodTypeId;
	}

	public Integer getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(Integer leaveDay) {
		this.leaveDay = leaveDay;
	}

	public Integer getWorkingPeriodYear() {
		return workingPeriodYear;
	}

	public void setWorkingPeriodYear(Integer workingPeriodYear) {
		this.workingPeriodYear = workingPeriodYear;
	}

	public LeaveType getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(LeaveType leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	
	

}
