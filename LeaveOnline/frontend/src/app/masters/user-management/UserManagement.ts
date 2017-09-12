import { Employees } from "app/masters/employees/Employees";
import { Authorities } from "app/masters/authorities/Authorities";

export class Usermanagement {
    id: number;
    username: string;
    password: string;
    enabled: boolean;
    effectiveDate: Date;
    employeeObjectemployeeId: Employees;
    authorities: Authorities[];
}