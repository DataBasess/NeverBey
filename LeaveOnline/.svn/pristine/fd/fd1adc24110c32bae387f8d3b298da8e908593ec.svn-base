package com.epro.infrastructure.security.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;

/**
 * @author Worachet Suparat
 * @author Tanakarn Intanuwat
 * @customize Tinnaphob Nunwongsa
 */
@Entity
@Table(name = "menu_authorities_control")
public class MenuAuthorityControl extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -5013482862266135366L;

	@EmbeddedId
	private MenuAuthorityControlPK menuAuthorityControlPK;

	public MenuAuthorityControlPK getMenuAuthorityControlPK() {
		return menuAuthorityControlPK;
	}

	public void setMenuAuthorityControlPK(
			MenuAuthorityControlPK menuAuthorityControlPK) {
		this.menuAuthorityControlPK = menuAuthorityControlPK;
	}
	
}
