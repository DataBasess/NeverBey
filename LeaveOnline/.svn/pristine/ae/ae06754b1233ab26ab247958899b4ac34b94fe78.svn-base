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

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;

/**
 * @author Worachet Suparat
 * @author Tanakarn Intanuwat
 */

@Entity
@Table(name = "menus")
@DynamicUpdate
@SelectBeforeUpdate
public class Menu extends AbstractEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="menus_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "menu_order")
	private Integer order;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "picturepath")
	private String picturePath;
	
	@Column(name = "menu_icon")
	private String menuIcon;
	
	@Column(name = "active_flag")
	private boolean activeFlag;
	
	@ManyToOne()
	@JoinColumn(name = "parent_id", referencedColumnName="id",foreignKey = @ForeignKey(name="menus_fk"))
	private Menu parent;
	
	
	/*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "menuauthority",  joinColumns = { 
			@JoinColumn(name = "menu_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id", 
					nullable = false, updatable = false) })
					
				*/	
	
	/*@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="menuauthority",
                joinColumns={@JoinColumn(name="menu_id",referencedColumnName="id")},
                inverseJoinColumns={@JoinColumn(name="authority_id",referencedColumnName="id")}
    )
	
	private Set<Authority> authorities;*/

 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
/*
	public List<Menu> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Menu> childrens) {
		this.childrens = childrens;
	}*/
	

	/*public void addMenu(List<Menu> child) {
		if (!getChildrens().contains(child)) {
			getChildrens().add(child);
		}
	}
	
	public void removeMenu(Menu child) {
		if (getChildrens().contains(child)) {
			getChildrens().remove(child);
		}
	}*/

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
/*	@JsonIgnore
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}*/

	public boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
	/*public Set<Authority> getAuthorities() {
		if (authorities == null) {
			authorities = new HashSet<Authority>();
		}
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	
	
	public void addAuthorities(Authority authority) {
		if (!getAuthorities().contains(authority)) {
			getAuthorities().add(authority);
		}
	}
	
	public void removeAuthorities(Authority authority) {
		if (getAuthorities().contains(authority)) {
			getAuthorities().remove(authority);
		}
	}*/
	
}
