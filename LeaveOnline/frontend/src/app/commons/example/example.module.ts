import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExampleRoutingModule } from './example-routing.module';
import { TableModule } from "app/commons/table/table.module";
import { ExampleComponent } from "app/commons/example/example.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AutoCompleteDropdownModule } from "app/commons/auto-complete-dropdown/auto-complete-dropdown.module";
import { LovModule } from "app/commons/lov/lov.module";
import { ButtonModule } from "primeng/primeng";

@NgModule({
  imports: [
    CommonModule,
    ExampleRoutingModule,
    TableModule,
    FormsModule,
    ReactiveFormsModule,
    ButtonModule,

    AutoCompleteDropdownModule,
    LovModule,
  ],
  declarations: [ExampleComponent]
})
export class ExampleModule { }
