import { LazyLoadEvent } from 'primeng/primeng';
import { CommonOptions } from './../../commons/CommonOptions';
import { CommonFunction } from './../../commons/CommonFunction';
import { Observable } from 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { Message } from "primeng/components/common/api";
import { Employees } from "app/masters/employees/Employees";

let rootPath = "/api/employee/";

@Injectable()
export class EmployeesService {

  constructor(private http: Http) { }
  common = new CommonFunction(this.http);



  loadEmployee() : Promise<Employees[]>{
    return this.common.post(new CommonOptions(rootPath + "load", {}));
  }


  saveUpdate(formValue: Employees): Promise<Employees> {
    return this.http.post("/api/employee/save", formValue).toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }


  saveOrUpdateEmployee(formValue: Employees, isModify: boolean): Promise<Message> {
    var path = isModify ? "update" : "save";
    return this.common.post(new CommonOptions(rootPath + path, formValue));

  }


  removeEmployee(employees: Employees[]): Promise<Message> {
    return this.common.post(new CommonOptions(rootPath + "remove", employees));
  }

  loadEmployeeDropdown() {
    return this.http.post('/api/employee/dropdown/employee', {})
      .toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }

   loadLazyEmployee(lazy: LazyLoadEvent) {
    return this.common.post(new CommonOptions(rootPath+"loadLazy", lazy));
  }

  loadLazyEmployeeForLOV(lazy: LazyLoadEvent) {
    return this.common.post(new CommonOptions(rootPath+"loadLazyEmployeeForLOV", lazy));
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
