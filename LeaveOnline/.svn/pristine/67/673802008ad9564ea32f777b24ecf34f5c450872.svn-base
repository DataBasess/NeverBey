import { Component ,OnInit} from '@angular/core';
import { MenuService } from "app/_services/menu.service";
import { TreeNode } from "primeng/primeng";
import {MenuModule,MenuItem} from 'primeng/primeng';

@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss'],
    providers:[MenuService],
})
export class SidebarComponent implements OnInit{
    constructor(
        private menuService: MenuService ,
      ) { }
    isPageExpands:number[]=[];
    private items: MenuItem[];

    isActive = false;
    showMenu = '';
    files: TreeNode[];

    ngOnInit() {
        this.menuService.loadTreemenu()
        .then(files => {
            this.files= files;
            //this.items = files;
            console.log(files);
            

          });


    }
    eventCalled() {
        this.isActive = !this.isActive;
    }
    addExpandClass(element: number) {
        try {
            console.log("element=:"+element);

            if(this.isPageExpands.indexOf(element)==-1){
                this.isPageExpands.push(element);
            }else{
                this.isPageExpands.splice(this.isPageExpands.indexOf(element), 1);
            } 
            console.log("page element=:"+this.isPageExpands.indexOf(element));
            console.log("page 3=:"+this.isPageExpands.indexOf(3));
            console.log("isPageExpands=:"+this.isPageExpands);
        } catch (error) {
            console.log("error=:"+error);
        }
      
    }
}
