
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Rx";
import { LazyLoadEvent } from "primeng/primeng";
import { ParameterTableHeader } from "app/masters/parameter-table-header/ParameterTableHeader";
import { CommonFunction } from "app/commons/CommonFunction";
import { CommonOptions } from "app/commons/CommonOptions";

let rootPath = "/api/parameterTableHeader/";
@Injectable()
export class ParameterTableHeaderService {


  constructor(private http: Http) {}
  common = new CommonFunction(this.http);
 


  saveOrUpdateParameterTableHeader(parameterTableHeaderl: ParameterTableHeader,isModify: boolean): Promise<ParameterTableHeader>{
    var path = isModify?"update":"save";
    return this.common.post(new CommonOptions(rootPath+path, parameterTableHeaderl)); 
   
  }

  loadParameterTableHeader(){
    return this.common.post(new CommonOptions(rootPath+"load", {}));
  }
  
  removeParameterTableHeader(parameterTableHeaders: ParameterTableHeader[]){
    return this.common.post(new CommonOptions(rootPath+"remove", parameterTableHeaders)); 
  }

  loadLazyParameterTableHeader(lazy: LazyLoadEvent){
    return this.common.post(new CommonOptions(rootPath+"loadLazy", lazy));
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleErrorObsevable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

  private handleErrorPromise(error: Response | any) {
    console.error(error.message || error);
    return Promise.reject(error.message || error);
  }

}
