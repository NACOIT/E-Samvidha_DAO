package gov.naco.soch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the menu_master database table.
 * 
 */
@Entity
@Table(name = "menu_master")
@NamedQuery(name = "MenuMaster.findAll", query = "SELECT m FROM MenuMaster m")
public class MenuMaster extends Auditable<Long> {

	@Id
	@Column(unique = true, nullable = false, length = 99)
	private Long id;

	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "route_link")
	private String routeLink;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name = "position")
	private Integer position;

	public MenuMaster() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getRouteLink() {
		return routeLink;
	}

	public void setRouteLink(String routeLink) {
		this.routeLink = routeLink;
	}
	
	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}