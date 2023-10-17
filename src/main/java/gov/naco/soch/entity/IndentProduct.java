package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the indent_product database table.
 * 
 */
@Entity
@GenericGenerator(name = "indent_product", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "indent_product_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "indent_product")
@NamedQuery(name = "IndentProduct.findAll", query = "SELECT i FROM IndentProduct i")
public class IndentProduct extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "indent_product")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Indent
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indent_id")
	private Indent indent;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	// bi-directional many-to-one association to IndentProductSchedule
	@OneToMany(mappedBy = "indentProduct", cascade = CascadeType.ALL)
	private Set<IndentProductSchedule> indentProductSchedules;

	public IndentProduct() {
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

	public Indent getIndent() {
		return this.indent;
	}

	public void setIndent(Indent indent) {
		this.indent = indent;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<IndentProductSchedule> getIndentProductSchedules() {
		return this.indentProductSchedules;
	}

	public void setIndentProductSchedules(Set<IndentProductSchedule> indentProductSchedules) {
		this.indentProductSchedules = indentProductSchedules;
	}

	public IndentProductSchedule addIndentProductSchedule(IndentProductSchedule indentProductSchedule) {
		getIndentProductSchedules().add(indentProductSchedule);
		indentProductSchedule.setIndentProduct(this);

		return indentProductSchedule;
	}

	public IndentProductSchedule removeIndentProductSchedule(IndentProductSchedule indentProductSchedule) {
		getIndentProductSchedules().remove(indentProductSchedule);
		indentProductSchedule.setIndentProduct(null);

		return indentProductSchedule;
	}

}