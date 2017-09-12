import { ParameterTableHeader } from './../_models/ParameterTableHeader';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Rx";
import { LazyLoadEvent } from "primeng/primeng";


let headers = new Headers({ 'Content-Type': 'application/json' });
let options = new RequestOptions({ headers: headers });
@Injectable()
export class ParameterTableHeaderService {


  constructor(private http: Http) { }

  saveOrUpdateParameterTableHeader(parameterTableHeaderl: ParameterTableHeader,isModify: boolean): Promise<ParameterTableHeader>{
    var path = isModify?"update":"save";
    return this.http.post("/api/parameterTableHeader/"+path, parameterTableHeaderl, options)
            .toPromise()
            .then(this.extractData)
            .catch(this.handleErrorPromise); 
   
  }

  loadParameterTableHeader(){
    return this.http.post('/api/parameterTableHeader/load', {}, options)
          .toPromise()
          .then(this.extractData)
          .catch(this.handleErrorPromise);
  }
  
  removeParameterTableHeader(parameterTableHeaders: ParameterTableHeader[]){
    return this.http.post("/api/parameterTableHeader/remove", parameterTableHeaders, options)
               .toPromise()
               .then(this.extractData)
               .catch(this.handleErrorPromise); 
  }

  loadLazyParameterTableHeader(lazy: LazyLoadEvent){
    return this.http.post('/api/parameterTableHeader/loadLazy', lazy, options)
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
