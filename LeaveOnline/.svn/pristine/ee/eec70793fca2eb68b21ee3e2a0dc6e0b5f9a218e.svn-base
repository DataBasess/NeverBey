import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import { CommonFunction } from "app/commons/CommonFunction";
import { CommonOptions } from "app/commons/CommonOptions";
import { DropdownOptions } from "app/commons/auto-complete-dropdown/DropdownOptions";

@Injectable()
export class AutoCompleteDropdownService {

  constructor(private http : Http) { }
  commonFn = new CommonFunction(this.http);

  loadDataDropdown(commonOpt: DropdownOptions<any>){
    return this.commonFn.postDropdown(commonOpt);
  }

}
