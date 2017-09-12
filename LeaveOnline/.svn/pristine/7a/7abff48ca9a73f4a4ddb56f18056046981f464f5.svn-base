
import { EventEmitter } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";

export class DropdownOptions<T> {
  fieldValue:string;
  path:string;
  placeholder:string;
  dataList:any[];
  postData:{};
  filteredData:T[];
  callback: EventEmitter<T>
  formGroup: FormGroup;
  fieldFormGroup:string;
  formControl: FormControl;

  constructor(path:string,postData:{},fieldValue:string,placeholder:string, formGroup: FormGroup,fieldFormGroup:string,formControl: FormControl) {
    this.path = path;
    this.postData = postData;
    this.fieldValue = fieldValue;
    this.placeholder = placeholder;
    this.formGroup = formGroup;
    this.fieldFormGroup = fieldFormGroup;
    this.formControl = formControl;
  }
}