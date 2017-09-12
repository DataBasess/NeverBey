import { Component, OnInit, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { ParameterTableHeader } from "app/masters/parameter-table-header/ParameterTableHeader";
import { LovService } from "app/commons/lov/lov.service";
import { LazyLoadEvent } from "primeng/primeng";
import { LOVOptions } from "app/commons/lov/LOVOptions";
import { FormControl, Validators } from "@angular/forms";

@Component({
  selector: 'app-lov',
  templateUrl: './lov.component.html',
  styleUrls: ['./lov.component.scss'],
  providers: [LovService]
})
export class LovComponent implements OnInit {
  @Input() lovOptions : LOVOptions<any>;
  @Input() display:boolean;
  @Output() displayChange = new EventEmitter();
  @Output() onSelectTableRow = new EventEmitter();

  @ViewChild('tableLOV') tableLOV;

  constructor(private lovService: LovService) { }

  ngOnInit() {
    this.tableLOV.tableOptions = this.lovOptions.tableOptions; 
    
    let formControl:FormControl = this.lovOptions.formControl == null?
                                  new FormControl('', Validators.required)//if
                                  :this.lovOptions.formControl;//else

    this.lovOptions.formGroup.addControl(this.lovOptions.fieldFormGroup,formControl);
  

  }

  onClose(data:any){
    this.display = false;
    this.displayChange.emit(this.display);
  }

  onRowSelect(data){
    this.onSelectTableRow.emit(data);
    this.onClose(data);
  }
}
