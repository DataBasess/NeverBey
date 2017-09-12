import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ParameterTableDetailComponent } from "app/masters/parameter-table-detail/parameter-table-detail.component";

const routes: Routes = [
  {path:'', component: ParameterTableDetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ParameterTableDetailRoutingModule { }
