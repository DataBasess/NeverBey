import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Rx";
import { CommonOptions } from "app/commons/CommonOptions";
import { Http } from "@angular/http";
import { CommonFunction } from "app/commons/CommonFunction";
import { LazyLoadEvent } from "primeng/primeng";

let rootPath = "/api/parameterTableHeader/";

@Injectable()
export class LovService {

  constructor(private http: Http) { }
  common = new CommonFunction(this.http);

  loadDataTableLazy(lazy: LazyLoadEvent){
    return this.common.post(new CommonOptions(rootPath+"loadLazy", lazy));
  }
}
