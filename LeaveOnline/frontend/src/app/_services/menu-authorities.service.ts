import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from "@angular/http";
import { Observable } from 'rxjs/Rx';
import { MenuAuthorities } from "app/_models/MenuAuthorities";
import { TreeNode } from "primeng/primeng";
import { AuthoritiesModel } from "app/_models/Authorities";

let headers = new Headers({ 'Content-Type': 'application/json' });
let options = new RequestOptions({ headers: headers });
@Injectable()
export class MenuAuthoritiesService {

  constructor(private http: Http) { }


  save(formValue: MenuAuthorities):Promise<MenuAuthorities> {
    console.log(formValue);
    var path = "/api/MenuAuthorities/save";
    return this.http.post(path, formValue, options).toPromise()
    .then(this.extractData)
    .catch(this.handleErrorPromise);

  }

  loadTreeAuthorities(authoritiesModel: AuthoritiesModel){
    return this.http.post('/api/Menu/loadTreeAutorities',authoritiesModel, options).toPromise()
    .then(res => <TreeNode[]> res.json().data);
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
