import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import { Observable } from "rxjs/Rx";
import { CommonFunction } from "app/commons/CommonFunction";
import { TableOptions } from "app/commons/table/TableOptions";

@Injectable()
export class TableService {

  constructor(
    private http : Http) { }
    common = new CommonFunction(this.http);

    loadDataTableLazy(tableOptions:TableOptions<any>){
      return this.common.postTable(tableOptions);
    }

}
