import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Message, SelectItem } from "primeng/components/common/api";
import { ConfirmationService, LazyLoadEvent } from "primeng/primeng";
import { ParameterTableHeaderService } from "app/masters/parameter-table-header/parameter-table-header.service";
import { ParameterTableHeader } from "app/masters/parameter-table-header/ParameterTableHeader";
import { DropdownOptions } from "app/commons/auto-complete-dropdown/DropdownOptions";
import { ParameterTableDetail } from "app/masters/parameter-table-detail/ParameterTableDetail";
import { Employees } from "app/masters/employees/Employees";

@Component({
  selector: 'app-parameter-table-header',
  templateUrl: './parameter-table-header.component.html',
  styleUrls: ['./parameter-table-header.component.scss'],
  providers:[ ParameterTableHeaderService ,ConfirmationService]
})
export class ParameterTableHeaderComponent implements OnInit {

    @ViewChild("autoCompleteDropdown") autoCompleteDropdown:any;
    @ViewChild("autoCompleteDropdown2") autoCompleteDropdown2:any;

    msgs: Message[] = [];
    pmhform: FormGroup;

    btnLabel = "Save";
    isModify = false;
    selectedParameterTableHeader:ParameterTableHeader[];
    parameterTableHeaders: ParameterTableHeader[];

    totalRecords: number;
    labelSelect:any = null;

    constructor(
        private fb: FormBuilder,
        private ptService: ParameterTableHeaderService,
        private confirmationService: ConfirmationService
                ) {}

    ngOnInit() 
    {
        this.pmhform = this.fb.group({
            'pHeaderId': new FormControl(''),
            'pHeaderCode': new FormControl('', Validators.required),
            'pHeaderName': new FormControl('', Validators.required),
            'pHeaderDescription': new FormControl(''),
            'brand': new FormControl('')
        });
        
        this.autoCompleteDropdown.dropdownOptions = new DropdownOptions<Employees>(
            "/api/employee/load"
            ,{}
            ,"employeeFirstName"
            ,"คำค้นหา"
            ,this.pmhform
            ,"dropdown"
            ,new FormControl('', Validators.required)
        )

        this.autoCompleteDropdown2.dropdownOptions = new DropdownOptions<Employees>(
            "/api/employee/load"
            ,{}
            ,"employeeFirstName"
            ,"คำค้นหา"
            ,this.pmhform
            ,"dropdown2"
            ,new FormControl('', Validators.required)
        );
        
    //this.reloadParameterTableHeader();

    }
  
    onSubmit(value: string) {
        this.msgs = [];
        this.ptService.saveOrUpdateParameterTableHeader(this.pmhform.value,this.isModify)
          .then( 
              result => {
                  this.formReset();
                  this.msgs.push({severity:'success', summary:'Success', detail:'Successfully'});
                  this.reloadParameterTableHeader();
                  this.cancleUpdate();
              },
              errors => {
                let error = errors.json();
                this.msgs.push({severity:'error', summary:'Error', detail:error.msg}) 
              }
        );
    }

    selectParameterTableHeader(parameterTableHeader: ParameterTableHeader){
      (<FormGroup>this.pmhform).reset(parameterTableHeader, {onlySelf: true});
      this.btnLabel = "Update";
      this.isModify = true;
    }

    

    formReset(){
      (<FormGroup>this.pmhform).reset({});
    }

    onRemove() {
      let jsonStr = JSON.stringify(this.selectedParameterTableHeader);

      this.confirmationService.confirm({
          message: 'Are you sure that you want to proceed?',
          header: 'Confirmation',
          icon: 'fa fa-question-circle',
          accept: () => {
              this.ptService.removeParameterTableHeader(this.selectedParameterTableHeader)
                .then( 
                    result => {
                        this.formReset();
                        this.selectedParameterTableHeader = [];
                        this.msgs.push({severity:'success', summary:'Success', detail:'Successfully'});	
                        this.reloadParameterTableHeader();
                    },
                    errors => {
                      let error = errors.json();
                      this.msgs.push({severity:'error', summary:'Error', detail:error.msg}) 
                    }
              );
          },
          reject: () => {
              //console.log("Reject");
          }
      }); 
      
    }

    reloadParameterTableHeader(){
      this.ptService.loadParameterTableHeader().then(result => {
        this.parameterTableHeaders = result;
      });	
    }

    cancleUpdate(){
        this.btnLabel = "Save";
        this.isModify = false;
        this.formReset();
    }

    loadParameterTableHeaderLazy(event: LazyLoadEvent){
      this.ptService.loadLazyParameterTableHeader(event).then(result => {
        this.parameterTableHeaders = result.listOfData;
        this.totalRecords = result.totalRecords;
      });
    }

    onSelection(data){
        console.log(data);
        
    }

}
