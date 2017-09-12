import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuAuthorityRoutingModule } from './menu-authority-routing.module';
import { MenuAuthorityComponent } from "app/masters/menu-authority/menu-authority.component";
import { TreeModule, PanelModule, InputMaskModule, AutoCompleteModule, GrowlModule } from "primeng/primeng";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { AutoCompleteDropdownModule } from "app/commons/auto-complete-dropdown/auto-complete-dropdown.module";

@NgModule({
  imports: [
    CommonModule,
    MenuAuthorityRoutingModule,
    TreeModule,
    PanelModule,
    FormsModule,
    ReactiveFormsModule,
    AutoCompleteModule,
    InputMaskModule,
    AutoCompleteDropdownModule,
    GrowlModule

  ],
  declarations: [MenuAuthorityComponent]
})
export class MenuAuthorityModule { }
