import { AutoCompleteDropdownModule } from './../../commons/auto-complete-dropdown/auto-complete-dropdown.module';
import { DropdownModule } from 'primeng/components/dropdown/dropdown';
import { TabViewModule } from 'primeng/components/tabview/tabview';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { GrowlModule } from 'primeng/components/growl/growl';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/components/button/button';
import { PanelModule, DataTableModule, SharedModule, ConfirmDialogModule, InputSwitchModule } from 'primeng/primeng';
import { UserManagementRoutingModule } from './user-management-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PasswordModule } from "primeng/components/password/password";
import { CalendarModule } from "primeng/components/calendar/calendar";
import { UserManagementComponent } from "app/masters/user-management/user-management.component";
import { DialogModule } from "primeng/components/dialog/dialog";
@NgModule({
  imports: [
    CommonModule,
    UserManagementRoutingModule,

    PanelModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    GrowlModule,
    InputTextModule,
    TabViewModule,
    DataTableModule,
    SharedModule,
    ConfirmDialogModule,
    InputSwitchModule,
    PasswordModule,
    CalendarModule,
    DropdownModule,
    AutoCompleteDropdownModule,
    DialogModule

  ],
  declarations: [UserManagementComponent]
})
export class UserManagementModule { }
