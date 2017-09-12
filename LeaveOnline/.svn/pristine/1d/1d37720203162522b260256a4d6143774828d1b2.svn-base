import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { TableOptions } from "app/commons/table/TableOptions";
import { TableService } from "app/commons/table/table.service";
import { LazyLoadEvent } from "primeng/primeng";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
  providers: [TableService]
})
export class TableComponent implements OnInit {

  @Input() tableOptions : TableOptions<any>;
  @Output() onRowSelectEvent = new EventEmitter<any>();

  constructor(private tableService:TableService) { }

  ngOnInit() {
    
  }

  loadDataTableLazy(lazy:LazyLoadEvent){
    lazy.globalFilter = this.tableOptions.postData;
    this.tableOptions.lazyLoadEvents = lazy;

    this.tableService.loadDataTableLazy(this.tableOptions).then(
      result => {
        this.tableOptions.dataList = result.listOfData;
        this.tableOptions.totalRecords = result.totalRecords;
      },
      errors => {}
    );
  }

  onRowSelect(event:any){
    this.onRowSelectEvent.emit(event.data);
  }

}
