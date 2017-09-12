package com.epro.infrastructure.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;

/**
 * @author Worachet Suparat
 * @author Tanakarn Intanuwat
 * @customize Tinnaphob Nunwongsa
 */
@Entity
@Table(name = "menu_authorities")
public class MenuAuthority extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -5013482862266135366L;

	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="menu_authorities_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "menu_authority_id")
	private Integer menuAuthorityId;
	
	@ManyToOne()
	@JoinColumn(name="menus_id", referencedColumnName="id", foreignKey = @ForeignKey(name="menu_authorities_fk2"))
	private Menu menus;
	
	@ManyToOne()
	@JoinColumn(name="authority_id", referencedColumnName="id", foreignKey = @ForeignKey(name="menu_authorities_fk1"))
	private Authority authorities;

	public Integer getMenuAuthorityId() {
		return menuAuthorityId;
	}

	public void setMenuAuthorityId(Integer menuAuthorityId) {
		this.menuAuthorityId = menuAuthorityId;
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
	}

	
}
