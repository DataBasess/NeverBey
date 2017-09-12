import { Component, OnInit, ElementRef, Renderer2, ViewChild, ViewEncapsulation, ViewContainerRef, ComponentFactoryResolver, Pipe, PipeTransform } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, FormArray } from "@angular/forms";

import { LazyLoadEvent, ConfirmationService } from "primeng/primeng";
import { LeaveTypeService } from "app/masters/leave-type/leave-type.service";
import { LeaveType } from "app/masters/leave-type/LeaveType";
import { WorkingPeriodType } from "app/masters/leave-type/WorkingPeriodType";

@Component({
  selector: 'app-leave-type',
  templateUrl: './leave-type.component.html',
  styleUrls: ['./leave-type.component.scss'],
  providers: [LeaveTypeService, ConfirmationService]
})
export class LeaveTypeComponent implements OnInit {
  rows: Array<string> = Array();
  htmlText: string;
  msgs: any[];

  leaveObj: LeaveType[];
  totalRecords: number;
  leavetypeform: FormGroup;
  btnLabel: string = "Save";
  probationSelected: LeaveType[];
  isModify: boolean = false;
  counts = [];
  count = 1;

  booleanChecked = true;
  selectedLeavetype: LeaveType[];

  constructor(private leaveService: LeaveTypeService, private fb: FormBuilder
    , private renderer: Renderer2, private element: ElementRef, private resolver: ComponentFactoryResolver, private confirmationService: ConfirmationService) {

  }

  ngOnInit() {

    this.leavetypeform = this.fb.group({
      'leaveTypeId': new FormControl(''),
      'leaveTypeName': new FormControl('', Validators.required),
      'probationFlag': new FormControl('', Validators.required),
      'countWorkingFlag': new FormControl(''),
      'holidayFlag': new FormControl(''),
      'effectiveDate': new FormControl('', Validators.required),
      'activeFlag': new FormControl(''),
      'leaveDay': new FormControl('', Validators.required),
      'leaveCondition': new FormControl('', Validators.required),
      workingPeriodTypes: this.fb.array([])

    });
    //console.log(this.workingPeriodTypes.length);
    //  this.addBtn=false;
    this.addWorkingPeriodType();
    this.workingPeriodTypes.disable();
    this.booleanChecked = true;
  }

  get workingPeriodTypes() { return <FormArray>this.leavetypeform.get('workingPeriodTypes'); }


  loadLazyLeaveType(event: LazyLoadEvent) {
    this.leaveService.loadLazyLeaveType(event).then(result => {
      //  result.effectiveDate = result.effectiveDate ? new Date(result.effectiveDate) : null;
      this.leaveObj = result.listOfData;
      this.totalRecords = result.totalRecords;
      //console.log(this.leaveObj);

      this.leaveObj.forEach(element => {
        element.effectiveDate = element.effectiveDate ? new Date(element.effectiveDate) : null;
        element.effectiveDate = element.effectiveDate ? new Date(element.effectiveDate) : null;

      });

    })
  }

  onSubmit(value: LeaveType) {
    console.log(value);
    this.msgs = [];
    // this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Order submitted' });
    this.leaveService.saveOrUpdate(value, this.isModify).then(result => {
      // this.onResetForm();
      this.msgs.push(result);
      this.isModify = false;
      this.btnLabel = "Save";
      // this.onReload();
    }),
      errors => {
        let error = errors.json();
        this.msgs.push(error);
        // this.onReload();
      }
  }

  addWorkingPeriodType() {

    this.workingPeriodTypes.push(this.fb.group({
      'workingPeriodTypeId': new FormControl(''),
      'workingPeriodYear': new FormControl('', Validators.required),
      'leaveDay': new FormControl('', Validators.required)
    }));
    //console.log(this.workingPeriodTypes);
  }

  selectLeaveType(value) {

    // console.log(value);
    value.effectiveDate = value.effectiveDate ? new Date(value.effectiveDate) : null;
    this.addWorkingPeriodType();
    this.leavetypeform.reset(value);

    this.isModify = true;
    this.btnLabel = "Update";

  }

  removeWorkingPeriodType(i) {
    console.log(i);
    this.workingPeriodTypes.removeAt(i);
    console.log(i);
  }

  /*   handleChange(event){
      this.booleanCheck = false;
    } */

  toggleDisabled(event) {
    if((this.leavetypeform.controls['countWorkingFlag'].value==false)
      ||(this.leavetypeform.controls['countWorkingFlag'].value==null)){
          this.workingPeriodTypes.disable();
          this.leavetypeform.controls['leaveDay'].enable();
    }else{
      this.workingPeriodTypes.enable();
          this.leavetypeform.controls['leaveDay'].disable();
    }
  }

  onRemove() {
    let jsonStr = JSON.stringify(this.selectedLeavetype);

    this.confirmationService.confirm({
      message: 'Are you sure that you want to proceed?',
      header: 'Confirmation',
      icon: 'fa fa-question-circle',
      accept: () => {
        this.leaveService.onRemoveLeaveType(this.selectedLeavetype)
          .then(
          result => {
            console.log(result);
            // this.onResetForm();
            this.selectedLeavetype = [];
            this.msgs.push(result);
            // this.onReload();
          },
          errors => {
            let error = errors.json();
            //console.log(error);
            this.msgs.push(error)
          }
          );
      },
      reject: () => {
        //console.log("Reject");
      }
    });
  }

  onResetForm() {
    this.leavetypeform.reset({});
  }

}
