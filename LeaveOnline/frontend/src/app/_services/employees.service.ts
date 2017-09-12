import { Observable } from 'rxjs/Rx';
import { Employees } from './../_models/Employees';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { Message } from "primeng/components/common/api";

let headers = new Headers({ 'Content-Type': 'application/json' });
let options = new RequestOptions({ headers: headers });
@Injectable()
export class EmployeesService {

  constructor(private http: Http) { }

  loadEmployee(){
    return this.http.post('/api/employee/load', {}, options)
          .toPromise()
          .then(this.extractData)
          .catch(this.handleErrorPromise);
  }

  saveUpdate(formValue: Employees): Promise<Employees> {
    return this.http.post("/api/employee/save", formValue, options).toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }


  saveOrUpdateEmployee(formValue: Employees,isModify: boolean): Promise<Message>{
    var path = isModify?"/api/employee/update":"/api/employee/save";
    return this.http.post(path, formValue, options)
            .toPromise()
            .then(this.extractData)
            .catch(this.handleErrorPromise); 
   
  }
  removeEmployee(employees: Employees[]): Promise<Message>{
    return this.http.post('/api/employee/remove', employees, options)
               .toPromise()
               .then(this.extractData)
               .catch(this.handleErrorPromise); 
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
