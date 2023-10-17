package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the indent_status_master database table.
 * 
 */
@Entity
@Table(name = "indent_status_master")
@NamedQuery(name = "IndentStatusMaster.findAll", query = "SELECT i FROM IndentStatusMaster i")
public class IndentStatusMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String status;

	// bi-directional many-to-one association to Indent
	@OneToMany(mappedBy = "indentStatusMaster")
	private Set<Indent> indents;

	public IndentStatusMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Indent> getIndents() {
		return this.indents;
	}

	public void setIndents(Set<Indent> indents) {
		this.indents = indents;
	}

	public Indent addIndent(Indent indent) {
		getIndents().add(indent);
		indent.setIndentStatusMaster(this);

		return indent;
	}

	public Indent removeIndent(Indent indent) {
		getIndents().remove(indent);
		indent.setIndentStatusMaster(null);

		return indent;
	}

}