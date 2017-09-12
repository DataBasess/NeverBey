import { Message } from 'primeng/components/common/api';
import { AuthoritiesModel } from './../_models/Authorities';
import { Http, RequestOptions,Response, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Rx";

let headers = new Headers({'Content-Type':'application/json'});
let options = new RequestOptions({headers:headers});
@Injectable()
export class AuthoritiesService {

  constructor(private http: Http) { }

  loadAuthoritiesTable(){
    return this.http.post("/api/authorities/load", options)
    .toPromise()
    .then(this.extractData)
    .catch(this.handleErrorPromise);
  }

  removeAuthoritiesTable(authoritiesTable: AuthoritiesModel[]){
    return this.http.post("/api/authorities/delete", authoritiesTable, options)
               .toPromise()
               .then(this.extractData)
               .catch(this.handleErrorPromise); 
  }

  saveOrUpdate(formValue: AuthoritiesModel, isModify: boolean): Promise<Message>{
    var path = isModify?"/api/authorities/update":"/api/authorities/save";
    return this.http.post(path, formValue, options)
    .toPromise()
    .then(this.extractData)
    .catch(this.handleErrorPromise);
    
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

