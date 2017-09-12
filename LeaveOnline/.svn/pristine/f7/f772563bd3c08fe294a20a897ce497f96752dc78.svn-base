import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response, Headers } from "@angular/http";
import { Observable } from "rxjs/Rx";
import { ParameterTableDetail } from "app/masters/parameter-table-detail/ParameterTableDetail";
import { CommonFunction } from "app/commons/CommonFunction";
import { CommonOptions } from "app/commons/CommonOptions";
import { LazyLoadEvent } from "primeng/primeng";

let rootPath = "/api/parametertabledetail/";
@Injectable()
export class ParameterTableDetailService {

  constructor(private http: Http) { }
  common = new CommonFunction(this.http);

  saveOrUpdate(parametertabledetaill: ParameterTableDetail, isModify: boolean): Promise<ParameterTableDetail> {

       var path = isModify?"update":"save";
    return this.common.post(new CommonOptions(rootPath+path, parametertabledetaill));
  }

  loadParameterTableDetail() {
   return this.common.post(new CommonOptions(rootPath+"load", {}));
  }


  onRemoveParameterTableDetail(parameterTableDetail: ParameterTableDetail[]) {
    return this.common.post(new CommonOptions(rootPath+"remove", parameterTableDetail));
  }

    loadLazyParameterTableDetail(lazy: LazyLoadEvent){
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
