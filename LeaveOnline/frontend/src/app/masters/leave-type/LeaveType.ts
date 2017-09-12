import { WorkingPeriodType } from "app/masters/leave-type/WorkingPeriodType";

export class LeaveType {
    leaveTypeId: number;
    leaveTypeName: string;
    probationFlag: boolean;
    countWorkingFlag: boolean;
    holidayFlag: boolean;
    effectiveDate: Date;
    activeFlag: boolean;
    leaveDay: number;
    leaveCondition: string;
    workingPeriodTypes :WorkingPeriodType[];
}