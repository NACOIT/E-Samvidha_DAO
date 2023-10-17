package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the private_dispensation_item database table.
 * 
 */

@Entity
@GenericGenerator(name = "art_private_dispensation_item", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_private_dispensation_item_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "art_private_dispensation_item")
@NamedQuery(name = "ArtPrivateDispensationItem.findAll", query = "SELECT a FROM ArtPrivateDispensationItem a")
public class ArtPrivateDispensationItem extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_private_dispensation_item")
	private Integer id;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "dispense_quantity")
	private Long dispenseQuantity;

	// bi-directional many-to-one association to PrivateDispensation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_private_dispensation_id")
	private ArtPrivateDispensation artPrivateDispensation;

	// bi-directional many-to-one association to FacilityStock
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_stock_id")
	private FacilityStock facilityStock;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	public ArtPrivateDispensationItem() {

	}

	public Integer getId() {
		return id;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public Long getDispenseQuantity() {
		return dispenseQuantity;
	}

	public ArtPrivateDispensation getPrivateDispensation() {
		return artPrivateDispensation;
	}

	public FacilityStock getFacilityStock() {
		return facilityStock;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setDispenseQuantity(Long dispenseQuantity) {
		this.dispenseQuantity = dispenseQuantity;
	}

	public void setPrivateDispensation(ArtPrivateDispensation artPrivateDispensation) {
		this.artPrivateDispensation = artPrivateDispensation;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
