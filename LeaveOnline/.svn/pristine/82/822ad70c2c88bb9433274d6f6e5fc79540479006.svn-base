import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from "@angular/forms";
import { Message, ConfirmationService, ConfirmDialogModule, LazyLoadEvent } from "primeng/primeng";
import { ParameterTableDetailService } from "app/masters/parameter-table-detail/parameter-table-detail.service";
import { ParameterTableDetail } from "app/masters/parameter-table-detail/ParameterTableDetail";



@Component({
  selector: 'app-parameter-table-detail',
  templateUrl: './parameter-table-detail.component.html',
  styleUrls: ['./parameter-table-detail.component.scss'],
  providers: [ParameterTableDetailService, ConfirmationService]
})
export class ParameterTableDetailComponent implements OnInit {

  ptform: FormGroup;
  msgs: Message[] = [];
  btnLabel: string = "Save";
  isModify: boolean = false;
  ptDetails: ParameterTableDetail[];
  stacked: boolean;
  selectedPTDetail: ParameterTableDetail[];
  totalRecords: number;

  constructor(private fb: FormBuilder, private PTService: ParameterTableDetailService, private confirmationService: ConfirmationService) { }

  ngOnInit() {

    this.ptform = this.fb.group({
      'id': new FormControl(''),
      'tableCode': new FormControl('', Validators.required),
      'code': new FormControl('', Validators.required),
      'description': new FormControl(''),
      'shortDescription': new FormControl(''),
      'note': new FormControl(''),
      'sequence': new FormControl(''),
      'parentCode': new FormControl(''),
      'parentTableCode': new FormControl(''),
      'activeFlag': new FormControl(''),
    });

   // this.onLoadParameterTableDetail();

  }

  onSubmit(value: ParameterTableDetail) {
    console.log(value);
    this.msgs = [];
    // this.msgs.push({ severity: 'success', summary: 'Success Message', detail: 'Order submitted' });
    this.PTService.saveOrUpdate(value, this.isModify).then(result => {
      this.onResetForm();
      this.msgs.push(result);
      this.isModify = false;
      this.btnLabel = "Save";
      this.onReload();
    }),
      errors => {
        let error = errors.json();
        this.msgs.push(error);
        this.onReload();
      }
  }

  onResetForm() {
    this.ptform.reset({});
  }

  onLoadParameterTableDetail() {
    this.PTService.loadParameterTableDetail().then(result => {
      this.ptDetails = result;
      console.log(result);
    })
  }

  selectParameterTableDetail(value) {
    (<FormGroup>this.ptform).reset(value);
    this.isModify = true;
    this.btnLabel = "Update";
  }

  onRemove() {
    let jsonStr = JSON.stringify(this.selectedPTDetail);

    this.confirmationService.confirm({
      message: 'Are you sure that you want to proceed?',
      header: 'Confirmation',
      icon: 'fa fa-question-circle',
      accept: () => {
        this.PTService.onRemoveParameterTableDetail(this.selectedPTDetail)
          .then(
          result => {
            console.log(result);
            this.onResetForm();
            this.selectedPTDetail = [];
            this.msgs.push(result);
            this.onReload();
          },
          errors => {
            let error = errors.json();
            //console.log(error);
            this.msgs.push(error)
          }
          );
      },
      reject: () => {
        //console.log("Reject");
      }
    });
  }

  cancleUpdate() {
    this.onResetForm();
    this.isModify = false;
    this.btnLabel = "Save";
  }

  onReload() {
    this.PTService.loadParameterTableDetail().then(result => {
      this.ptDetails = result;
    })
  }

   loadParameterTableDetailLazy(event: LazyLoadEvent){
      this.PTService.loadLazyParameterTableDetail(event).then(result =>{
         this.ptDetails = result.listOfData;
          this.totalRecords = result.totalRecords;
          console.log(result);
      })
  }

}
