import { Component, OnInit, ViewChild } from '@angular/core';
import { TreeNode, Message } from "primeng/primeng";
import { FormGroup, FormBuilder, FormControl, Validators, AbstractControl } from "@angular/forms";
import { MenuService } from "app/_services/menu.service";
import { MenuAuthorities } from "app/_models/MenuAuthorities";
import { AuthoritiesModel } from "app/_models/Authorities";
import { Menu } from "app/_models/Menu";
import { DropdownOptions } from "app/commons/auto-complete-dropdown/DropdownOptions";
import { ParameterTableDetail } from "app/masters/parameter-table-detail/ParameterTableDetail";
import { MenuAuthoritiesService } from "app/_services/menu-authorities.service";

@Component({
  selector: 'app-menu-authority',
  templateUrl: './menu-authority.component.html',
  styleUrls: ['./menu-authority.component.scss'],
  providers:[MenuService,MenuAuthoritiesService]
})
export class MenuAuthorityComponent implements OnInit {

  @ViewChild("autoCompleteDropdownPosition") autoCompleteDropdownPosition: any;
  
  constructor(
    private formBuilder: FormBuilder,
    private menuService: MenuService,
    private menuAuthoritiesService : MenuAuthoritiesService) { }

    files: TreeNode[];
    MenuAuthoritiesform: FormGroup;
    msgs:Message[] = [];

    
    menuAuthorities: MenuAuthorities;
    authoritiesModel : AuthoritiesModel;

  ngOnInit() {  

    this.MenuAuthoritiesform = this.formBuilder.group({
      'menuAuthorityId'   : new FormControl(),
      'authorities'       : new FormControl(new AuthoritiesModel),
      'menus'             : new FormControl(new Menu ),
    });

    this.loadMenuAuthorities();
    this.DropdownAuthorities();  

  }

  DropdownAuthorities(){
    this.autoCompleteDropdownPosition.dropdownOptions = new DropdownOptions<ParameterTableDetail>(
      "/api/authorities/load"
      , "TABLE_POSITION_TYPE"
      , "description"
      , "Authorities"
      , this.MenuAuthoritiesform
      , "authorities"
      , new FormControl('', Validators.required)
    )

  }



  loadMenuAuthorities(){
    this.menuService.loadTreemenu()
    .then(files =>this.files= files);
    console.log(this.files);

  }

  SelectDropdown(){
    
    this.authoritiesModel = this.MenuAuthoritiesform.controls['authorities'].value;
    console.log( this.authoritiesModel);
    this.menuAuthoritiesService.loadTreeAuthorities(this.authoritiesModel)
    .then(files =>this.files= files);
  }

  nodeSelect(event) {
    console.log(event.node.data.id);
    this.MenuAuthoritiesform.controls['menus'].setValue(event.node.data);
    console.log(this.MenuAuthoritiesform.value);
    this.menuAuthoritiesService.save(this.MenuAuthoritiesform.value).then(result =>{
      console.log(result);
     // this.msgs.push(result);
    }),
    errors => {
      let error = errors.json();
      console.log(error);
      this.msgs.push(error);
    } 

    
  }

  nodeUnselect(event) {
    console.log(event.node.data.id);
  }

}
