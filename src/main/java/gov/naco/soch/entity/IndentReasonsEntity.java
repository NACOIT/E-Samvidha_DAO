/**
 * 
 */
package gov.naco.soch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @date 2020-Jan-01 11:51:19 AM
 */

// Entity class for the indent_reasons_master
@Entity
@Table(name = "indent_reasons_master")
public class IndentReasonsEntity extends Auditable<Long> {

	// Mapping column with properties of entity class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column(name = "indent_reasons_name")
	private String indentReasonsName;

	@Column(name = "is_active")
	private boolean is_active;

	@Column(name = "is_delete")
	private boolean is_delete;

	/**
	 * Default constructor
	 */
	public IndentReasonsEntity() {
		super();
	}

	/**
	 * Constructor with id
	 * 
	 * @param id
	 * @param indentReasonsName
	 * @param isDelete
	 */
	public IndentReasonsEntity(Integer id, String indentReasonsName, boolean is_active, boolean is_delete) {
		super();
		this.id = id;
		this.indentReasonsName = indentReasonsName;
		this.is_active = is_active;
		this.is_delete = is_delete;
	}

	/**
	 * Constructor without id
	 * 
	 * @param indentReasonsName
	 * @param isDelete
	 */
	public IndentReasonsEntity(String indentReasonsName, boolean is_active, boolean is_delete) {
		super();
		this.indentReasonsName = indentReasonsName;
		this.is_active = is_active;
		this.is_delete = is_delete;
	}

	// Getters and setters for mentioned properties
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndentReasonsName() {
		return indentReasonsName;
	}

	public void setIndentReasonsName(String indentReasonsName) {
		this.indentReasonsName = indentReasonsName;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "IndentReasonsEntity [id=" + id + ", indentReasonsName=" + indentReasonsName + ", is_active=" + is_active
				+ ", is_delete=" + is_delete + "]";
	}

}
