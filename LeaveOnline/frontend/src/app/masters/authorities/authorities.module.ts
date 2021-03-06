import { DropdownModule } from 'primeng/components/dropdown/dropdown';
import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { TabViewModule } from 'primeng/components/tabview/tabview';
import { InputTextareaModule } from 'primeng/components/inputtextarea/inputtextarea';
import { InputTextModule } from 'primeng/components/inputtext/inputtext';
import { GrowlModule } from 'primeng/components/growl/growl';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PanelModule } from "primeng/components/panel/panel";
import { ButtonModule } from "primeng/components/button/button";
import { RadioButtonModule } from "primeng/components/radiobutton/radiobutton";
import { DataTableModule } from "primeng/components/datatable/datatable";
import { SharedModule } from "primeng/components/common/shared";
import { ConfirmDialogModule } from "primeng/components/confirmdialog/confirmdialog";
import { AuthoritiesComponent } from "app/masters/authorities/authorities.component";
import { AuthoritiesRoutingModule } from "app/masters/authorities/authorities-routing.module";
import { InputSwitchModule } from "primeng/components/inputswitch/inputswitch";

@NgModule({
  imports: [
    CommonModule,
    AuthoritiesRoutingModule,

    PanelModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    GrowlModule,
    InputTextModule,
    InputTextareaModule,
    TabViewModule,
    CodeHighlighterModule,
    RadioButtonModule,
    DataTableModule,
    SharedModule,
    ConfirmDialogModule,
    InputSwitchModule
    

  ],
  declarations: [AuthoritiesComponent]
})
export class AuthoritiesModule { }
