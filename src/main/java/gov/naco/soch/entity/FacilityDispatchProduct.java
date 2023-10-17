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
 * The persistent class for the facility_dispatch_product database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_dispatch_product", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_dispatch_product_facility_dispatch_product_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_dispatch_product")
@NamedQuery(name = "FacilityDispatchProduct.findAll", query = "SELECT f FROM FacilityDispatchProduct f")
public class FacilityDispatchProduct extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_dispatch_product")
	@Column(name = "facility_dispatch_product_id")
	private Integer facilityDispatchProductId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to FacilityDispatch
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	// bi-directional many-to-one association to FacilityDispatchProductBatch
	@OneToMany(mappedBy = "facilityDispatchProduct", cascade = CascadeType.ALL)
	private Set<FacilityDispatchProductBatch> facilityDispatchProductBatches;

	public FacilityDispatchProduct() {
	}

	public Integer getFacilityDispatchProductId() {
		return this.facilityDispatchProductId;
	}

	public void setFacilityDispatchProductId(Integer facilityDispatchProductId) {
		this.facilityDispatchProductId = facilityDispatchProductId;
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

	public FacilityDispatch getFacilityDispatch() {
		return this.facilityDispatch;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<FacilityDispatchProductBatch> getFacilityDispatchProductBatches() {
		return this.facilityDispatchProductBatches;
	}

	public void setFacilityDispatchProductBatches(Set<FacilityDispatchProductBatch> facilityDispatchProductBatches) {
		this.facilityDispatchProductBatches = facilityDispatchProductBatches;
	}

	public FacilityDispatchProductBatch addFacilityDispatchProductBatch(
			FacilityDispatchProductBatch facilityDispatchProductBatch) {
		getFacilityDispatchProductBatches().add(facilityDispatchProductBatch);
		facilityDispatchProductBatch.setFacilityDispatchProduct(this);

		return facilityDispatchProductBatch;
	}

	public FacilityDispatchProductBatch removeFacilityDispatchProductBatch(
			FacilityDispatchProductBatch facilityDispatchProductBatch) {
		getFacilityDispatchProductBatches().remove(facilityDispatchProductBatch);
		facilityDispatchProductBatch.setFacilityDispatchProduct(null);

		return facilityDispatchProductBatch;
	}

}