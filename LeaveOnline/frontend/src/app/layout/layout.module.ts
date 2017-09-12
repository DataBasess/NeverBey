import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';

import { LayoutRoutingModule } from './layout-routing.module';
import { LayoutComponent } from './layout.component';
import { HeaderComponent, SidebarComponent } from '../shared';
import { TreeModule,TieredMenuModule } from "primeng/primeng";
import { MenuModule } from 'primeng/primeng';

@NgModule({
    imports: [
        CommonModule,
        NgbDropdownModule.forRoot(),
        LayoutRoutingModule,
        TranslateModule,
        TreeModule,
        TieredMenuModule,
        MenuModule

    ],
    declarations: [
        LayoutComponent,
        HeaderComponent,
        SidebarComponent
    ]
    
})
export class LayoutModule { }
