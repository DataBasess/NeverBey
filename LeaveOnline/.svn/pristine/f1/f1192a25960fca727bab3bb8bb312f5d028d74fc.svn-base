import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from "@angular/http";
import { Observable } from 'rxjs/Rx';
import { Menu } from "app/_models/Menu";
import { LazyLoadEvent, TreeNode } from "primeng/primeng";


let headers = new Headers({ 'Content-Type': 'application/json' });
let options = new RequestOptions({ headers: headers });

@Injectable()
export class MenuService {

  constructor(private http: Http) { }

  saveOrUpdate(formValue: Menu, isModify: boolean):Promise<Menu> {
    console.log(formValue);
    var path = isModify ? "/api/Menu/update" : "/api/Menu/save";
    return this.http.post(path, formValue, options).toPromise()
    .then(this.extractData)
    .catch(this.handleErrorPromise);

  }

  

  loadMenu() {

    return this.http.post('/api/Menu/loadAll', {}, options).toPromise()
      .then(this.extractData)
      .catch(this.handleErrorPromise);
  }

  loadTreemenu(){
    return this.http.post('/api/Menu/loadTree', {}, options).toPromise()
    .then(res => <TreeNode[]> res.json().data);
  }

  loadMenulLazy(Lazy: LazyLoadEvent) {
        //Lazy.filters.toString();
        console.log(Lazy.filters);
        return this.http.post('/api/Menu/loadLazy', Lazy, options).toPromise()
          .then(this.extractData)
          .catch(this.handleErrorPromise);
  }

  onRemovemenu(menu: Menu[]) {
      
      return this.http.post('/api/Menu/delete', menu, options).toPromise()
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
