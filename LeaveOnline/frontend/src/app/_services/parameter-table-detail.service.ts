import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response, Headers } from "@angular/http";
import { Observable } from "rxjs/Rx";
import { ParameterTableDetail } from "app/_models/ParameterTableDetail";
import { LazyLoadEvent } from "primeng/primeng";

let headers = new Headers({ 'Content-Type': 'application/json' });
let options = new RequestOptions({ headers: headers });

@Injectable()
export class ParameterTableDetailService {

  constructor(private http: Http) { }


  saveOrUpdate(formValue: ParameterTableDetail, isModify: boolean): Promise<ParameterTableDetail> {
    var path = isModify ? "/api/parametertabledetail/update" : "/api/parametertabledetail/save";
    return this.http.post(path, formValue, options).toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }

  loadParameterTableDetail() {

    return this.http.post('/api/parametertabledetail/loadAll', {}, options).toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }

  loadParameterTableDetailLazy(Lazy: LazyLoadEvent) {
    
        return this.http.post('/api/parametertabledetail/loadLazy', Lazy, options).toPromise()
          .then(this.extractData)
          .catch(this.handleErrorPromise);
      }


  onRemoveParameterTableDetail(parameterTableDetail: ParameterTableDetail[]) {
  
    return this.http.post('/api/parametertabledetail/delete', parameterTableDetail, options).toPromise()
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
