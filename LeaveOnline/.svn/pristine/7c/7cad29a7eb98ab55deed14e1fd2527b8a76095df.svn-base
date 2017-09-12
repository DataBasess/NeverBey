import { LazyLoadEvent } from 'primeng/primeng';
import { ConfirmationService } from 'primeng/primeng';
import { AuthoritiesService } from 'app/masters/authorities/authorities.service';
import { Authorities } from './Authorities';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Message } from "primeng/components/common/api";

@Component({
  selector: 'app-authorities',
  templateUrl: './authorities.component.html',
  styleUrls: ['./authorities.component.scss'],
  providers:[AuthoritiesService, ConfirmationService]
})
export class AuthoritiesComponent implements OnInit {


  msgs: Message[] = [];
  authoritiesform: FormGroup;

  btnLabel = "Save";
  isModify = false;
  selectedAuthoritiesTable: Authorities[];
  authoritiesTable: Authorities[];

  totalRecords: number;

  constructor(private fb: FormBuilder,
              private authorityService: AuthoritiesService,
              private confirmationService: ConfirmationService) { }

  ngOnInit() {
    this.authoritiesform = this.fb.group({
      'authorityId': new FormControl(''),
      'authority': new FormControl('', Validators.required),
      'description': new FormControl(''),
      'activeFlag': new FormControl(false)
  });
  }

  reloadAuthoritiesTable(){
    this.authorityService.loadAuthoritiesTable().then(result => {
      this.authoritiesTable = result;
    });	
  }

  onSubmit(value: Authorities){
    console.log(value);
    this.msgs = [];
    this.authorityService.saveOrUpdate(this.authoritiesform.value,this.isModify)
    .then(
      res => 
      {
      console.log(res);
      this.formReset();
      this.msgs.push(res);
      this.cancleUpdate();
  },
  errors => {
    let error = errors.json();
    console.log(error);
    this.msgs.push(error); 
  });

  }

  selectAuthoritiesTable(authoritiesTable: Authorities){
    console.log(authoritiesTable);
    (<FormGroup>this.authoritiesform).reset(authoritiesTable);    
    this.btnLabel = "Update";
    this.isModify = true;
  }


  onRemove() {
    let jsonStr = JSON.stringify(this.selectedAuthoritiesTable);
    console.log(jsonStr);

    this.confirmationService.confirm({
        message: 'Are you sure that you want to proceed?',
        header: 'Confirmation',
        icon: 'fa fa-question-circle',
        accept: () => {
            this.authorityService.removeAuthoritiesTable(this.selectedAuthoritiesTable)
              .then( 
                  result => {
                      //console.log(result);
                      this.formReset();
                      this.selectedAuthoritiesTable = [];
                      this.msgs.push(result);	
                  },
                  errors => {
                    let error = errors.json();
                    console.log(error);
                    this.msgs.push(error); 
                  }
            );
        },
        reject: () => {
            //console.log("Reject");
        }
    }); 
    
  }

  cancleUpdate(){
    this.btnLabel = "Save";
    this.isModify = false;
    this.formReset();
  }

  formReset(){
    (<FormGroup>this.authoritiesform).reset({});
  }

  loadAuthoritiesTableLazy(event: LazyLoadEvent){
    console.log(event);
    this.authorityService.loadLazyAuthoritiesTableLazy(event)
    .then(result => {
      this.authoritiesTable = result.listOfData;
      this.totalRecords = result.totalRecords;      
    });	
  }

}
