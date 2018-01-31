package com.bstek.dorado.sample.standardlesson.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * sl_menu:
 */
@Entity
@Table(name = "sl_menu")
public class SlMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * MENU_ID:
	 */
	private int menuId;

	/**
	 * MENU_NAME:
	 */
	private String menuName;

	/**
	 * REMARKS:
	 */
	private String remarks;

	/**
	 * ICON:
	 */
	private String icon;

	/**
	 * SHOW_ORDER:
	 */
	private String showOrder;

	/**
	 * URL:
	 */
	private String url;

	/**
	 * sl_menu:
	 */
	private SlMenu slMenu;

	/**
	 * sl_menu:
	 */
	private Set<SlMenu> slMenuSet = new HashSet<SlMenu>(0);

	public SlMenu() {
		super();
	}

	public SlMenu(int menuId, String menuName, String remarks, String icon,
			String showOrder, String url, SlMenu slMenu, Set<SlMenu> slMenuSet) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.remarks = remarks;
		this.icon = icon;
		this.showOrder = showOrder;
		this.url = url;
		this.slMenu = slMenu;
		this.slMenuSet = slMenuSet;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MENU_ID", nullable = false)
	public int getMenuId() {
		return menuId;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "MENU_NAME", length = 60, nullable = false)
	public String getMenuName() {
		return menuName;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "REMARKS", length = 120)
	public String getRemarks() {
		return remarks;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "ICON", length = 120)
	public String getIcon() {
		return icon;
	}

	public void setShowOrder(String showOrder) {
		this.showOrder = showOrder;
	}

	@Column(name = "SHOW_ORDER", length = 45)
	public String getShowOrder() {
		return showOrder;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "URL", length = 120)
	public String getUrl() {
		return url;
	}

	public void setSlMenu(SlMenu slMenu) {
		this.slMenu = slMenu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public SlMenu getSlMenu() {
		return slMenu;
	}

	public void setSlMenuSet(Set<SlMenu> slMenuSet) {
		this.slMenuSet = slMenuSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "slMenu")
	public Set<SlMenu> getSlMenuSet() {
		return slMenuSet;
	}

	public String toString() {
		return "SlMenu [menuId=" + menuId + ",menuName=" + menuName
				+ ",remarks=" + remarks + ",icon=" + icon + ",showOrder="
				+ showOrder + ",url=" + url + ",slMenu=" + slMenu
				+ ",slMenuSet=" + slMenuSet + "]";
	}

}
