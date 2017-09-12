package com.epro.leave.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;

@Entity
@Table(name = "leave_type")
public class LeaveType extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="leave_type_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "leave_type_id")
	private Integer leaveTypeId;
	
	@Column(name = "leave_type_name")
	private String leaveTypeName;
	
	@Column(name = "probation_flag", nullable = false, length = 1)
	private String probationFlag;
	
	@Column(name = "holiday_flag", nullable = false, length = 5)
	private Boolean holidayFlag;
	
	@Column(name = "leave_condition")
	private String leaveCondition;
	
	@Column(name = "effective_date")
	private Date effectiveDate;
	
	@Column(name = "active_flag", nullable = false, length = 5)
	private Boolean activeFlag;
	
	@Column(name = "count_working_flag", nullable = false, length = 1)
	private String countWorkingFlag;
	
	@Column(name = "leave_day")
	private Integer leaveDay;

	
	public LeaveType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LeaveType(Integer leaveTypeId, String leaveTypeName, String probationFlag, Boolean holidayFlag,
			String leaveCondition, Date effectiveDate, Boolean activeFlag, String countWorkingFlag, Integer leaveDay) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.leaveTypeName = leaveTypeName;
		this.probationFlag = probationFlag;
		this.holidayFlag = holidayFlag;
		this.leaveCondition = leaveCondition;
		this.effectiveDate = effectiveDate;
		this.activeFlag = activeFlag;
		this.countWorkingFlag = countWorkingFlag;
		this.leaveDay = leaveDay;
	}


	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getProbationFlag() {
		return probationFlag;
	}

	public void setProbationFlag(String probationFlag) {
		this.probationFlag = probationFlag;
	}

	public Boolean getHolidayFlag() {
		return holidayFlag;
	}

	public void setHolidayFlag(Boolean holidayFlag) {
		this.holidayFlag = holidayFlag;
	}

	public String getLeaveCondition() {
		return leaveCondition;
	}

	public void setLeaveCondition(String leaveCondition) {
		this.leaveCondition = leaveCondition;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getCountWorkingFlag() {
		return countWorkingFlag;
	}

	public void setCountWorkingFlag(String countWorkingFlag) {
		this.countWorkingFlag = countWorkingFlag;
	}

	public Integer getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(Integer leaveDay) {
		this.leaveDay = leaveDay;
	}
	
	
	
}
