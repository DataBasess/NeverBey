package com.epro.leave.controller.administrator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epro.infrastructure.security.entity.Authority;
import com.epro.infrastructure.security.entity.Menu;
import com.epro.infrastructure.security.entity.MenuAuthority;
import com.epro.infrastructure.security.entity.User;
import com.epro.infrastructure.util.BeanUtils;
import com.epro.leave.common.CommonResponse;
import com.epro.leave.common.LazyLoadEventRequest;
import com.epro.leave.common.LazyLoadEventResponse;
import com.epro.leave.common.LazyLoadEventUtill;
import com.epro.leave.common.LoadTree;
import com.epro.leave.common.MenusAuthorityBean;
import com.epro.leave.common.MessageResponse;
import com.epro.leave.common.TreeMenu;
import com.epro.leave.entity.Employee;
import com.epro.leave.service.MenuService;

@RestController
@RequestMapping("/api/Menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@PostMapping("/save")
	public ResponseEntity<MessageResponse> save(@RequestBody Menu menu) {
		try {
			System.out.println(menu.getParent().getId());		
			menuService.save(menu);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	
	
	
	@RequestMapping(value="/Test")
	public void  saveMenu() {
		/*
		Authority authority = menuService.get(Authority.class,1);
		
		Set<Authority> setAut = new HashSet<Authority>();
		setAut.add(authority);
		menu.setAuthorities(setAut);*/
		
		Menu menu = new Menu();
		menu.setName("TestMenu");
		menu.setActiveFlag(true);
		menu.setOrder(1);
		
		
		
		menuService.save(menu);
				
	}
	
	@PostMapping("/loadAll")
	@RequestMapping(value="/loadAll")
	public List<Menu> load() {
		List<Menu> menu = menuService.findAll(Menu.class);
		return menu;
	}
	
	@PostMapping("/update")
	public ResponseEntity<MessageResponse> update(@RequestBody Menu menu) {
		try {
			menuService.update(menu);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<MessageResponse> deleteAll(@RequestBody List<Menu> menu) {
		try {
			Authority authority = menuService.get(Authority.class,1);
			
			Set<Authority> setAut = new HashSet<Authority>();
			setAut.add(authority);
			//menu.setAuthorities(setAut);
			
			menuService.mergeAndRemove(menu);
			return CommonResponse.getSuccessMessageResponse();
		} catch (Exception e) {
			// TODO: handle exception
			return CommonResponse.getErrorMessageResponse(e);
		}
	}
	
	@PostMapping("/loadLazy")
	public  LazyLoadEventResponse<Menu> loadMenuLazy(@RequestBody  LazyLoadEventRequest   lazyLoadEventRequest) {
		
		
		
		try {
			System.out.println("+++++++++++++++++++++++"+lazyLoadEventRequest);
			DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
			
			
			return LazyLoadEventUtill.generateLazyLoadEventResponseByCriteria(lazyLoadEventRequest, criteria, menuService);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
		
	@PostMapping("/loadTree")
	@RequestMapping(value="/loadTree")
	public LoadTree  loadmenu() {
			 List<Menu>menuAll = menuService.findAll(Menu.class);			 	 
			 LoadTree loadTree =new LoadTree();
			 loadTree.setData( createTreeNode(menuAll,null));
			 return loadTree;
	}
	
	@PostMapping("/loadTreeAutorities")
	//@RequestMapping(value="/loadTreeAutorities")
	public LoadTree  loadTreeAutorities(@RequestBody Authority authority) {
		
			
			/*System.out.println("+++++++++++++++++++++++"+authority.getAuthorityId());
			
			DetachedCriteria criteriaMA = DetachedCriteria.forClass(MenuAuthority.class);
			criteriaMA.add(Restrictions.eqProperty("authority_id",authority.getAuthorityId().toString()));
			criteriaMA.setProjection(Projections.property("menus_id"));
			
			System.out.println("+++++++++++++++++++++++"+criteriaMA);
			
			DetachedCriteria criteriaM = DetachedCriteria.forClass(Menu.class);
			criteriaM.add(Restrictions.eqProperty("id",criteriaMA.toString()));
			criteriaM.setProjection(Projections.property("*"));
			
			System.out.println("+++++++++++++++++++++++"+criteriaM);*/
		
/*		DetachedCriteria criteria = DetachedCriteria.forClass(MenuAuthority.class);
	 	criteria.createAlias("menus","menus"
	 			,JoinType.RIGHT_JOIN )
	 	.createAlias("authorities","authorities"
	 			,JoinType.LEFT_OUTER_JOIN
	 			,Restrictions.eq("authorities.authorityId", authority.getAuthorityId()));
	 	criteria.setProjection(projection)
	 	
		 List<MenuAuthority> menuAuthority = menuService.findByCriteria(criteria);		 
		 System.err.println("size : "+menuAuthority.size());
		 for(MenuAuthority menuauth: menuAuthority) {

			 if(BeanUtils.isNotNull(menuauth)) {
				 if(BeanUtils.isNull(menuauth.getAuthorities())) {
					 System.out.println("XXXX : "+menuauth.getMenus().getName());
				 }else {
					 System.err.println("XXXX : "+menuauth.getAuthorities().getAuthority()+"\t\t|"+menuauth.getMenus().getId()+"|"+menuauth.getMenus().getName());
				 }
			 }
		 }*/
			 
			 
			 List<Menu>menuAll = menuService.findAll(Menu.class);			 	 
			 LoadTree loadTree =new LoadTree();
			 loadTree.setData( createTreeNode(menuAll,authority));
			 return loadTree;
	}
/*		
	public static TreeMenu loadChildren(List<Menu> menuAll,TreeMenu grand,Integer menuGrandId){
		 try {
			 
			List<Menu> motherNotNullGrand = menuAll.stream().filter( m -> BeanUtils.isNotNull(m.getParent())).collect(Collectors.toList());
			List<Menu> mothers = motherNotNullGrand.stream().filter(m -> m.getParent().getId() == menuGrandId ).collect(Collectors.toList());
			
			if(BeanUtils.isNotEmpty(mothers)) {
				for(Menu menuMother : mothers) {
					System.err.println("\tMother : "+menuMother.getName());
					TreeMenu mother = new TreeMenu();
					//mother.setTitle(menuMother.getName());
					mother.setLabel(menuMother.getName());
					mother.setData(menuMother);
					grand.getChildren().add(mother);
					
					MenuController.loadChildren(menuAll, mother, menuMother.getId());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		 
		 return grand;
	 }
	*/

	private List<TreeMenu> createTreeNode(List<Menu> menus,Authority authority) {
		List<TreeMenu> listTree = new ArrayList<TreeMenu>();
		createTreeNode(listTree, menus, menus, true,authority);
		return listTree;
	}

	private void createTreeNode(List<TreeMenu> listTree, List<Menu> menusAll, List<Menu> menus, boolean isRoot,Authority authority) {
		List<Menu> menuList = isRoot
				? menus.stream().filter(menu -> BeanUtils.isNull(menu.getParent())).collect(Collectors.toList())
				: menus;
		for (Menu menu : menuList) {
			TreeMenu treeNode = new TreeMenu();
			treeNode.setData(menu);
			treeNode.setLabel(menu.getName());
			treeNode.setSelectable(isExistsMenuAuthority(menu, authority));
			List<Menu> childrens = menusAll.stream().filter(children -> BeanUtils.isNotNull(children.getParent())
					&& children.getParent().getId().equals(menu.getId())).collect(Collectors.toList());
			
			if (BeanUtils.isNotEmpty(childrens)) {
				List<TreeMenu> childenTreeNodeList = new ArrayList<>();
				createTreeNode(childenTreeNodeList, menusAll, childrens, false,authority);
				treeNode.getChildren().addAll(childenTreeNodeList);
			}
			
			listTree.add(treeNode);
		}
		
	}
	
	private Boolean isExistsMenuAuthority(Menu menu,Authority authority) {
		if(BeanUtils.isNotNull(authority)) {

			DetachedCriteria criteria = DetachedCriteria.forClass(MenuAuthority.class);
			criteria.add(Restrictions.eq("menus.id", menu.getId()));
			criteria.add(Restrictions.eq("authorities.authorityId", authority.getAuthorityId()));
			
			return BeanUtils.isNotEmpty(menuService.findByCriteria(criteria));
		}
		return false;
	}
	

}
