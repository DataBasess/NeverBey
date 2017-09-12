import { EmployeesComponent } from 'app/masters/employees/employees.component';
import { AutoCompleteDropdownModule } from './../../commons/auto-complete-dropdown/auto-complete-dropdown.module';
import { AutoCompleteModule, InputMaskModule } from 'primeng/primeng';

import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { InputTextareaModule } from 'primeng/components/inputtextarea/inputtextarea';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { GrowlModule } from 'primeng/components/growl/growl';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/components/button/button';
import { PanelModule, ConfirmDialogModule } from 'primeng/primeng';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SplitButtonModule } from 'primeng/primeng';
import { DataTableModule, SharedModule, RadioButtonModule } from 'primeng/primeng';
import { InputSwitchModule } from "primeng/components/inputswitch/inputswitch";
import { CalendarModule } from "primeng/components/calendar/calendar";
import { EmployeesRoutingModule } from "app/masters/employees/employees-routing.module";


@NgModule({
  imports: [
    CommonModule,
    EmployeesRoutingModule,
    PanelModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    GrowlModule,
    InputTextModule,
    InputTextareaModule,
    CodeHighlighterModule,
    SplitButtonModule,
    DataTableModule,
    SharedModule,
    ConfirmDialogModule,
    RadioButtonModule,
    AutoCompleteModule,
    InputSwitchModule,
    AutoCompleteDropdownModule,
    CalendarModule,
    InputMaskModule
  ],
  declarations: [EmployeesComponent]
})
export class EmployeesModule { }
