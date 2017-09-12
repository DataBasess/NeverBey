import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { GrowlModule } from "primeng/components/growl/growl";
import { PanelModule } from "primeng/components/panel/panel";
import { InputTextModule } from "primeng/components/inputtext/inputtext";
import { InputTextareaModule } from "primeng/components/inputtextarea/inputtextarea";
import { ButtonModule } from "primeng/components/button/button";
import { TabViewModule } from "primeng/components/tabview/tabview";
import { CodeHighlighterModule } from "primeng/components/codehighlighter/codehighlighter";
import { DataTableModule } from "primeng/components/datatable/datatable";
import { SharedModule } from "primeng/components/common/shared";
import { ConfirmDialogModule } from "primeng/components/confirmdialog/confirmdialog";
import { AutoCompleteModule } from "primeng/primeng";
import { ParameterTableHeaderRoutingModule } from "app/masters/parameter-table-header/parameter-table-header-routing.module";
import { AutoCompleteDropdownModule } from "app/commons/auto-complete-dropdown/auto-complete-dropdown.module";
import { ParameterTableHeaderComponent } from "app/masters/parameter-table-header/parameter-table-header.component";
//import { LovModule } from "app/commons/lov/lov.module";

@NgModule({
  imports: [
    CommonModule,
    ParameterTableHeaderRoutingModule,

    FormsModule,
    ReactiveFormsModule,
    GrowlModule,
    PanelModule,
    InputTextModule,
    InputTextareaModule,
    ButtonModule,
    TabViewModule,
    CodeHighlighterModule,
    DataTableModule,
    SharedModule,
    AutoCompleteModule,
    

    ConfirmDialogModule,
    AutoCompleteDropdownModule
],
  declarations: [ParameterTableHeaderComponent] 
})
export class ParameterTableHeaderModule { }
