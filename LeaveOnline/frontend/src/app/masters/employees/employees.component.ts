import { DropdownComponent } from './../../layout/bs-component/components/dropdown/dropdown.component';
import { CommonOptions } from 'app/commons/CommonOptions';
import { element } from 'protractor';

import { ConfirmDialogModule, ConfirmationService } from 'primeng/primeng';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Message } from "primeng/primeng";
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Employees } from "app/masters/employees/Employees";
import { EmployeesService } from "app/masters/employees/employees.service";
import { LazyLoadEvent } from "primeng/components/common/api";
import { CalendarModule } from 'primeng/primeng';
import { DropdownOptions } from "app/commons/auto-complete-dropdown/DropdownOptions";
import { ParameterTableDetail } from "app/masters/parameter-table-detail/ParameterTableDetail";
import { InputMaskModule } from 'primeng/primeng';
import { CommonFunctionComponent } from "app/commons/CommonFunctionComponent";


let common = new CommonFunctionComponent();

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss'],
  providers: [EmployeesService, ConfirmationService]

})
export class EmployeesComponent implements OnInit {



  @ViewChild("autoCompleteDropdownPrefix") autoCompleteDropdownPrefix: any;
  @ViewChild("autoCompleteDropdownPosition") autoCompleteDropdownPosition: any;
  @ViewChild("autoCompleteDropdownDepartment") autoCompleteDropdownDepartment: any;
  @ViewChild("autoCompleteDropdownCauseOfResign") autoCompleteDropdownCauseOfResign: any;

  totalRecords: number;
  employeeform: FormGroup;
  errorMessage: string;
  msgs: Message[] = [];
  employeeResignDate: any;
  employeeStartDate: any;
  th: any;

  currentDate: Date;

  workStatus: boolean = null;

  btnLabel = "Save";
  isModify = false;

  selectedEmployees: Employees[];
  employeesObj: Employees[];
  datatest: {};

  globalEvent: LazyLoadEvent;



  minDate: Date;
  maxDate: Date;

  durationDate: number;
  durationMonth: number;
  durationYear: number;
  diffDate: string;
  eventStartTime: Date;
  eventEndTime: Date;
  constructor(public formBuilder: FormBuilder, public employeesService: EmployeesService, private confirmationService: ConfirmationService) { }

  ngOnInit() {
    this.currentDate = new Date();
    this.th = {
      firstDayOfWeek: 0,
      dayNames: ["อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์", "เสาร์"],
      dayNamesShort: ["อา", "จ", "อ", "พ", "พฤ", "ศ", "ส"],
      dayNamesMin: ["อา", "จ", "อ", "พ", "พฤ", "ศ", "ส"],
      monthNames: ["มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"],
      monthNamesShort: ["ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.", "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค."]
    };

    this.employeeform = this.formBuilder.group({
      'employeeId': new FormControl(''),
      'employeeCode': new FormControl('', Validators.required),
      'employeeFirstName': new FormControl('', Validators.required),
      'employeeLastName': new FormControl('', Validators.required),
      'employeeNickname': new FormControl('', Validators.required),
      'emailAddress': new FormControl('', Validators.required),
      'employeeTelNo': new FormControl('', Validators.required),
      'activeFlag': new FormControl(true),
      'causeOfResign': new FormControl(''),
      'employeeAddress': new FormControl(''),
      'employeeStartDate': new FormControl('', Validators.required),
      'employeeResignDate': new FormControl(''),
      'identificationNumber': new FormControl('', Validators.required),
      'probationFlag': new FormControl(true),



    });
    this.autoCompleteDropdownPrefix.dropdownOptions = new DropdownOptions<ParameterTableDetail>(
      "/api/dropdown/employee"
      , "TABLE_NAME_PREFIX"
      , "description"
      , "ค้นหา 'คำนำหน้า'"
      , this.employeeform
      , "employeePrefix"
      , new FormControl('', Validators.required)
    ),
      this.autoCompleteDropdownPosition.dropdownOptions = new DropdownOptions<ParameterTableDetail>(
        "/api/dropdown/employee"
        , "TABLE_POSITION_TYPE"
        , "description"
        , "ค้นหา 'ตำแหน่ง'"
        , this.employeeform
        , "employeePosition"
        , new FormControl('', Validators.required)
      ),
      this.autoCompleteDropdownDepartment.dropdownOptions = new DropdownOptions<ParameterTableDetail>(
        "/api/dropdown/employee"
        , "TABLE_DEPARTMENT_TYPE"
        , "description"
        , "ค้นหา 'หน่วยงาน/แผนก'"
        , this.employeeform
        , "employeeDepartment"
        , new FormControl('', Validators.required)
      ),
      this.autoCompleteDropdownCauseOfResign.dropdownOptions = new DropdownOptions<ParameterTableDetail>(
        "/api/dropdown/employee"
        , "TABLE_CAUSE_OF_VALUE"
        , "description"
        , "ค้นหา 'สาเหตุที่ออก'"
        , this.employeeform
        , "causeOfResign"
        , new FormControl('')
      )
  }

  onSubmit(value: Employees) {
    this.msgs = [];

    this.employeesService.saveOrUpdateEmployee(this.employeeform.value, this.isModify)
      .then(
      result => {
     
        this.cancleUpdate();
        this.msgs.push(result);
        this.loadEmployeesLazy(this.globalEvent);
      },
      errors => {
        let error = errors.json();
        
        this.msgs.push(error)
      }
      );

  }


  onRemove() {
    this.confirmationService.confirm({
      message: 'Are you sure that you want to proceed?',
      header: 'Confirmation',
      icon: 'fa fa-question-circle',
      accept: () => {

        this.employeesService.removeEmployee(this.selectedEmployees)
          .then(
          result => {
    
            this.resetForm();
            this.selectedEmployees = [];
            this.msgs.push(result);
            this.loadEmployeesLazy(this.globalEvent);
          },
          errors => {
            let error = errors.json();

            this.msgs.push(error)
          }
          );
      },
      reject: () => {

      }
    });

  }

  reloadEmployee() {
    this.employeesService.loadEmployee().then(result => {
      this.employeesObj = result;
    });
  }

  selectEmployee(employee: Employees) {

    employee.employeeStartDate = employee.employeeStartDate ? new Date(employee.employeeStartDate) : null;
    employee.employeeResignDate = employee.employeeResignDate ? new Date(employee.employeeResignDate) : null;

    (<FormGroup>this.employeeform).reset(employee);
    this.btnLabel = "Update";
    this.isModify = true;
    this.disabled = false;

    this.minDate = new Date(employee.employeeStartDate);
    this.onChangeResignDate(employee.employeeResignDate);

    this.diffDate = this.calDiffDate(employee.employeeStartDate, employee.employeeResignDate);
  }

  resetForm() {
    (<FormGroup>this.employeeform).reset({});
    this.btnLabel = "Save";
    this.isModify = false;
    this.diffDate = "";
    this.workStatus = null;
  }

  cancleUpdate() {
    this.resetForm();
    this.btnLabel = "Save";
    this.isModify = false;

  }

  loadEmployeesLazy(event: LazyLoadEvent) {
    this.globalEvent = event;


    this.employeesService.loadLazyEmployee(event).then(result => {

      this.employeesObj = result.listOfData;
      this.totalRecords = result.totalRecords;

      this.employeesObj.forEach(element => {
        element.employeeStartDate = element.employeeStartDate ? new Date(element.employeeStartDate) : null;
        element.employeeResignDate = element.employeeResignDate ? new Date(element.employeeResignDate) : null;

      });
    });

  } // use lazy

  disabled = true;
  onChangeStartDate(data: any) {

    this.minDate = new Date(data);
    this.eventStartTime = data;

    if (this.eventStartTime <= this.currentDate) {
      this.diffDate = common.getDiffdate(data, null);
    } else this.diffDate = "";

    this.disabled = false;

    if (this.eventEndTime == null) {
      this.workStatus = true;
    }

  }

  onChangeResignDate(data: any) {

    if (data > this.currentDate) {
      this.workStatus = true;
      this.eventEndTime = new Date();
    } else if (data <= this.currentDate) {
      this.workStatus = false;
      this.eventEndTime = new Date(data);
    }
    this.maxDate = new Date(data);

    if (this.eventStartTime <= this.currentDate) {
      this.diffDate = common.getDiffdate(this.eventStartTime, this.eventEndTime);
    } else this.diffDate = "";
  }

  calDiffDate(startDate: Date, endDate: Date): string {

    let diffDate: string;

    if (endDate > this.currentDate) {
      endDate = new Date();
    } else if (endDate <= this.currentDate) {
      endDate = new Date(endDate);
    }

    if (startDate <= this.currentDate) {
      diffDate = common.getDiffdate(startDate, endDate);
    }

    return diffDate;

  }

}
