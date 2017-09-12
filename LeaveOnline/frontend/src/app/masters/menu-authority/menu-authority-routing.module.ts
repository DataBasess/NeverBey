import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuAuthorityComponent } from "app/masters/menu-authority/menu-authority.component";

const routes: Routes = [
  
    {path: '', component: MenuAuthorityComponent},
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuAuthorityRoutingModule { }
