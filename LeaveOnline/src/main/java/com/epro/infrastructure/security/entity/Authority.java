package com.epro.infrastructure.security.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.epro.infrastructure.hibernate4.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nattawut Verarattakul
 * @customize Worachet Suparat
 * @customize Tanakarn Intanuwat
 */
@Entity
@Table(name = "authorities")
public class Authority  extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -5013482862266135366L;

	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="authorities_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "id")
	private Integer authorityId;

	@Column(name = "authority")
	private String authority;
	
	@Column(name = "active_flag")
	private String activeFlag;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
	private Set<User> user;
	
	
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
	private Set<Menu> menus = new HashSet<Menu>();*/
	
	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@JsonIgnore
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
/*	@JsonIgnore
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}*/

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*
	public Set<Menu> getMenues() {
		if (menues == null) {
			menues = new HashSet<Menu>();
		}
		return menues;
	}

	public void setMenues(Set<Menu> menues) {
		this.menues = menues;
	}
	
	public void addMenu(Menu menu) {
		if (!getMenues().contains(menu)) {
			getMenues().add(menu);
		}
	}
	
	public void remove(Menu menu) {
		if (getMenues().contains(menu)) {
			getMenues().remove(menu);
		}
	}*/
/*
	public Set<Menu> getMenues() {
		return menues;
	}

	public void setMenues(Set<Menu> menues) {
		this.menues = menues;
	}
		*/
}
