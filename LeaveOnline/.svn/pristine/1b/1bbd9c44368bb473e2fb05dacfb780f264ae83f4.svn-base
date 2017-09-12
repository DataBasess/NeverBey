import { Injectable } from '@angular/core';
import { LazyLoadEvent } from "primeng/primeng";
import { Http } from "@angular/http";
import { CommonFunction } from "app/commons/CommonFunction";
import { CommonOptions } from "app/commons/CommonOptions";
import { Observable } from "rxjs/Rx";
import { LeaveType } from "app/masters/leave-type/LeaveType";

let rootPath = "/api/leavetype/";
@Injectable()
export class LeaveTypeService {

  constructor(private http: Http) { }
  common = new CommonFunction(this.http);

  saveOrUpdate(leavetype: LeaveType, isModify: boolean): Promise<LeaveType> {

       var path = isModify?"update":"save";
    return this.common.post(new CommonOptions(rootPath+path, leavetype));
  }

  loadLeaveType() {
   return this.common.post(new CommonOptions(rootPath+"load", {}));
  }

  onRemoveLeaveType(leavetype: LeaveType[]) {
    return this.common.post(new CommonOptions(rootPath+"remove", leavetype));
  }

    loadLazyLeaveType(lazy: LazyLoadEvent){
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
