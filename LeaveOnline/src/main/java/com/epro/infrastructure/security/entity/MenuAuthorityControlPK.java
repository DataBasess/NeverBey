package com.epro.infrastructure.security.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.epro.leave.entity.ParameterTableDetail;


/**
 * @author Worachet Suparat
 * @author Tanakarn Intanuwat
 * @customize Tinnaphob Nunwongsa
 */

@Embeddable
public class MenuAuthorityControlPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne()
	@JoinColumn(name="menu_authority_id", referencedColumnName="menu_authority_id", foreignKey = @ForeignKey(name="menu_authorities_fk"))
	private MenuAuthority menuAuthority;
	
	@ManyToOne()
	@JoinColumn(name="reference_data_list_id", referencedColumnName="id", foreignKey = @ForeignKey(name="menu_authorities_fk3"))
	private ParameterTableDetail parameterTableDetail;

	
	public MenuAuthorityControlPK() {
		super();
	}


	public MenuAuthorityControlPK(MenuAuthority menuAuthority, ParameterTableDetail parameterTableDetail) {
		super();
		this.menuAuthority = menuAuthority;
		this.parameterTableDetail = parameterTableDetail;
	}


	public MenuAuthority getMenuAuthority() {
		return menuAuthority;
	}


	public void setMenuAuthority(MenuAuthority menuAuthority) {
		this.menuAuthority = menuAuthority;
	}


	public ParameterTableDetail getParameterTableDetail() {
		return parameterTableDetail;
	}


	public void setParameterTableDetail(ParameterTableDetail parameterTableDetail) {
		this.parameterTableDetail = parameterTableDetail;
	}
	

	
	/*@ManyToOne()
	@JoinColumn(name="authority_id", referencedColumnName="id", foreignKey = @ForeignKey(name="menu_authorities_fk1"))
	private Authority authorities;
	
	@ManyToOne()
	@JoinColumn(name="menus_id", referencedColumnName="id", foreignKey = @ForeignKey(name="menu_authorities_fk2"))
	private Menu menus;
	
	public MenuAuthorityControlPK(Authority authorities, Menu menus,
			ParameterTableDetail parameterTableDetail) {
		super();
		this.authorities = authorities;
		this.menus = menus;
		this.parameterTableDetail = parameterTableDetail;
	}

	public Authority getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}

	public Menu getMenus() {
		return menus;
	}

	public void setMenus(Menu menus) {
		this.menus = menus;
	}*/


}
