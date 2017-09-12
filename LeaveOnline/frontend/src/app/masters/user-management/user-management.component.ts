  import { element } from 'protractor';
import { LazyLoadEvent } from 'primeng/primeng';
import { EmployeesService } from './../employees/employees.service';
import { Employees } from './../employees/Employees';
import { DropdownOptions } from './../../commons/auto-complete-dropdown/DropdownOptions';
import { UserManagementService } from 'app/masters/user-management/user-management.service';
import { ConfirmationService } from 'primeng/primeng';
import { Message } from 'primeng/components/common/api';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Component, OnInit, ViewChild } from '@angular/core';
import { AuthoritiesService } from "app/masters/authorities/authorities.service";
import { Authorities } from "app/masters/authorities/Authorities";
import { Usermanagement } from "app/masters/user-management/UserManagement";
@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss'],
  providers: [UserManagementService, ConfirmationService, EmployeesService]
})
export class UserManagementComponent implements OnInit {

  @ViewChild("autoCompleteDropdown") autoCompleteDropdown: any;
  msgs: Message[] = [];

  /* User */
  userManagementForm: FormGroup;
  userTable: Usermanagement[];
  selectUserTable: Usermanagement[];
  btnLabel = "Save";
  isModify = false;
  totalRecordsUserManagement: number;
  th: any;
  display: boolean = false;
  globalEventUsermanageMent: LazyLoadEvent;
  disabled: boolean = true;
  /* Employee */
  employeesObj: Employees[];
  globalEventEmployee: LazyLoadEvent;
  totalRecordsEmployee: number;

  employeeCodeFullname:string;


  constructor(private fb: FormBuilder,
    private usersManagementService: UserManagementService,
    private confirmationService: ConfirmationService,
    private employeesService: EmployeesService) { }

  ngOnInit() {
    this.userManagementForm = this.fb.group({
      'effectiveDate': new FormControl('', Validators.required),
      'username': new FormControl('', Validators.required),
      'password': new FormControl('', Validators.required),
      'enabled': new FormControl(false)
    });
    this.userManagementForm.addControl('employeeObjectemployeeId',new FormControl());
    
    this.th = {
      firstDayOfWeek: 0,
      dayNames: ["อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์", "เสาร์"],
      dayNamesShort: ["อา", "จ", "อ", "พ", "พฤ", "ศ", "ส"],
      dayNamesMin: ["อา", "จ", "อ", "พ", "พฤ", "ศ", "ส"],
      monthNames: ["มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"],
      monthNamesShort: ["ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.", "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค."]
    };

    this.autoCompleteDropdown.dropdownOptions = new DropdownOptions<Usermanagement>(
      "/api/dropdown/authorities"
      , {}
      , "authority"
      , "คำค้นหา"
      , this.userManagementForm
      , "authorities"
      , new FormControl('', Validators.required)
    )
  }

  onSubmit(value: Usermanagement) {
    console.log(value);
    this.msgs = [];
    this.usersManagementService.saveOrUpdate(this.userManagementForm.value, this.isModify)
      .then(
      res => {
        console.log(res);
        this.formReset();
        this.msgs.push(res);
        this.cancleUpdate();
        this.loadUserManagementTableLazy(this.globalEventUsermanageMent);
        this.loadLazyEmployeeForLOV(this.globalEventEmployee);
      },
      errors => {
        let error = errors.json();
        console.log(error);
        this.msgs.push(error);
      });
      this.employeeCodeFullname = null;
  }

  loadUserManagementTableLazy(event: LazyLoadEvent) {
    this.globalEventUsermanageMent = event;
    this.usersManagementService.loadUserManagementTableLazy(event)
      .then(result => {
        this.userTable = result.listOfData;
        this.totalRecordsUserManagement = result.totalRecords;
      });
  }

  cancleUpdate() {
    this.formReset();
    this.btnLabel = "Save";
    this.isModify = false;
  }

  formReset() {
    (<FormGroup>this.userManagementForm).reset({});;
    this.employeeCodeFullname = null;

    this.btnLabel = "Save";
    this.isModify = false;
  }

  onRemove() {
    console.log(this.selectUserTable);

    this.confirmationService.confirm({
      message: 'Are you sure that you want to proceed?',
      header: 'Confirmation',
      icon: 'fa fa-question-circle',
      accept: () => {        
        this.usersManagementService.removeUserManagementTable(this.selectUserTable)
          .then(
          result => {
            //console.log(result);
            this.formReset();
            this.selectUserTable = [];
            this.msgs.push(result);

            this.loadUserManagementTableLazy(this.globalEventUsermanageMent);
            this.loadLazyEmployeeForLOV(this.globalEventEmployee);

          },
          errors => {
            let error = errors.json();
            console.log(error);
            this.msgs.push(error);
          }
          );
      },
      reject: () => {
        //console.log("Reject");
      }
    });

  }

  showDialog() {
    this.display = true;
  }

  loadLazyEmployeeForLOV(event: LazyLoadEvent) {
    this.globalEventEmployee = event;    
    this.employeesService.loadLazyEmployeeForLOV(event).then(result => {
      this.employeesObj = result.listOfData;
      this.totalRecordsEmployee = result.totalRecords;
    });

  } // use lazy

  onRowSelectEmployee(event) {
    console.log(event.data);
    this.userManagementForm.controls['employeeObjectemployeeId'].setValue(event.data);
   
    this.employeeCodeFullname = event.data.employeeCode + " : "+ event.data.employeePrefixFullName;

    this.btnLabel = "Save";
    this.isModify = false;
    this.display = false;
  }

  selectUserManagementTable(value: Usermanagement){
    this.employeeCodeFullname = value.employeeObjectemployeeId.employeePrefixFullName;
    value.effectiveDate = value.effectiveDate?new Date(value.effectiveDate):null;
    
    (<FormGroup>this.userManagementForm).reset(value);
    this.btnLabel = "Update";
    this.isModify = true;
  }

}
