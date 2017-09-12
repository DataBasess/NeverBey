import { Usermanagement } from './UserManagement';
import { Authorities } from './../authorities/Authorities';
import { Message } from 'primeng/components/common/api';
import { Http, RequestOptions,Response, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Rx";
import { LazyLoadEvent } from "primeng/components/common/lazyloadevent";
import { CommonFunction } from "app/commons/CommonFunction";
import { CommonOptions } from "app/commons/CommonOptions";

let rootPath = "/api/users/";
@Injectable()
export class UserManagementService {
  
  constructor(private http: Http) {}
  common = new CommonFunction(this.http);

  saveOrUpdate(formValue: Usermanagement, isModify: boolean): Promise<Message>{
    var path = isModify?"update":"save";
    return this.common.post(new CommonOptions(rootPath+path, formValue));
  }
  
  loadUserManagementTableLazy(lazy: LazyLoadEvent){
    return this.common.post(new CommonOptions(rootPath+"loadLazy", lazy));
  }

  removeUserManagementTable(userManagementTable: Usermanagement[]){
    return this.common.post(new CommonOptions(rootPath+"delete", userManagementTable));
  }

  private extractData(res: Response){
    let body =res.json();
    return body || {};
  }
 
 private handleErrorObsevable (error:Response|any){
     console.error(error.message || error);
     return Observable.throw(error.message || error);
 }
 
  private handleErrorPromise (error: Response | any) {
   console.error(error.message || error);
   return Promise.reject(error.message || error);
     }

}
