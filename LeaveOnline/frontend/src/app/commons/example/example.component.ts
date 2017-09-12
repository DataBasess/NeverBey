import { Component, OnInit, ViewChild } from '@angular/core';
import { TableOptions } from "app/commons/table/TableOptions";
import { TableColumnOptions } from "app/commons/table/TableColumnOptions";
import { ParameterTableHeader } from "app/masters/parameter-table-header/ParameterTableHeader";
import { FormControl, FormGroup, Validators, FormBuilder } from "@angular/forms";
import { DropdownOptions } from "app/commons/auto-complete-dropdown/DropdownOptions";
import { Employees } from "app/masters/employees/Employees";
import { LOVOptions } from "app/commons/lov/LOVOptions";

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.scss']
})
export class ExampleComponent implements OnInit {

  addStatus:boolean = false;
  addStatus2:boolean = true;
  @ViewChild("autoCompleteDropdown") autoCompleteDropdown:any;
  @ViewChild("autoCompleteDropdown2") autoCompleteDropdown2:any;

  @ViewChild('tableExample') tableExample;
  @ViewChild('lovPTHeader') lovPTHeader;
  @ViewChild('lovPTHeader2') lovPTHeader2;
  

  exampleform: FormGroup;

  labelSelect:any = null;
  labelSelect2:any = null;
  
  displayModalEmp:boolean = false;
  displayModalEmp2:boolean = false;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    //form group
    this.exampleform = this.fb.group({});

    //table common
    this.tableExample.tableOptions = new TableOptions<ParameterTableHeader>(
      "ptHeaderTB",
      "/api/parameterTableHeader/loadLazy",
      {},
      "pHeaderId",
      [
        new TableColumnOptions("pHeaderId","pHeaderId",true,true),
        new TableColumnOptions("pHeaderCode","pHeaderCode",true,true),
        new TableColumnOptions("pHeaderName","pHeaderName",true,true),
        new TableColumnOptions("pHeaderDescription","pHeaderDescription",false,false)
      ]
    );

    //dropdown
    this.autoCompleteDropdown.dropdownOptions = new DropdownOptions<Employees>(
      "/api/employee/load"
      ,{}
      ,"employeeFirstName"
      ,"คำค้นหา"
      ,this.exampleform
      ,"dropdown"
      ,new FormControl('', Validators.required)
    )

  //dropdown on selected
  this.autoCompleteDropdown2.dropdownOptions = new DropdownOptions<Employees>(
      "/api/employee/load"
      ,{}
      ,"employeeFirstName"
      ,"คำค้นหา"
      ,this.exampleform
      ,"dropdown2"
      ,new FormControl('', Validators.required)
  );

  //lov
  this.lovPTHeader.lovOptions = new LOVOptions<ParameterTableHeader>(
    "เลือกพนักงาน",
    this.exampleform,
    "fieldObject",
    new FormControl('', Validators.required),
    new TableOptions<ParameterTableHeader>(
      "ptHeaderTB",
      "/api/parameterTableHeader/loadLazy",
      {},
      "pHeaderId",
      [
        new TableColumnOptions("pHeaderId","pHeaderId",true,true),
        new TableColumnOptions("pHeaderCode","pHeaderCode",true,true),
        new TableColumnOptions("pHeaderName","pHeaderName",true,true),
        new TableColumnOptions("pHeaderDescription","pHeaderDescription",false,false)
      ]
    )
  );

  //lov2
  this.lovPTHeader2.lovOptions = new LOVOptions<ParameterTableHeader>(
    "เลือกพนักงาน",
    this.exampleform,
    "",
    new FormControl('', Validators.required),
    new TableOptions<ParameterTableHeader>(
      "ptHeaderTB",
      "/api/parameterTableHeader/loadLazy",
      {},
      "pHeaderId",
      [
        new TableColumnOptions("pHeaderId","pHeaderId",true,true),
        new TableColumnOptions("pHeaderCode","pHeaderCode",true,true),
        new TableColumnOptions("pHeaderName","pHeaderName",true,true),
        new TableColumnOptions("pHeaderDescription","pHeaderDescription",false,false)
      ]
    )
  );

  }//end init


  //Event on selected(dropdown2)
  onSelection(data){
    console.log(data);
  }

  onClickBtnLOV(event:any){
    this.displayModalEmp = true;;
  }

  onClickBtnLOV2(event:any){
    this.displayModalEmp2 = true;;
  }

  onRowSelect(data){
    console.log(data);
  }

  onSelectTableRowInLOV(data){
    console.log("onSelectTableRowInLOV in example",data);
    this.labelSelect = data.pHeaderName;
  }

  onSelectTableRowInLOV2(data){
    console.log("onSelectTableRowInLOV2 in example",data);
    this.labelSelect2 = data.pHeaderName;
  }


}
