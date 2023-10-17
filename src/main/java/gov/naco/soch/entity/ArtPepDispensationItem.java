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
 * The persistent class for the art_pep_dispensation_item database table.
 * 
 */

@Entity
@GenericGenerator(name = "art_pep_dispensation_item", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_pep_dispensation_item_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "art_pep_dispensation_item")
@NamedQuery(name = "ArtPepDispensationItem.findAll", query = "SELECT a FROM ArtPepDispensationItem a")
public class ArtPepDispensationItem extends Auditable<Long>  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_pep_dispensation_item")
	private Integer id;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "dispense_quantity")
	private Long dispenseQuantity;

	// bi-directional many-to-one association to ArtPepDispensation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_pep_dispensation_id")
	private ArtPepDispensation artPepDispensation;

	// bi-directional many-to-one association to FacilityStock
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_stock_id")
	private FacilityStock facilityStock;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	public ArtPepDispensationItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}


	public Long getDispenseQuantity() {
		return this.dispenseQuantity;
	}

	public void setDispenseQuantity(Long dispenseQuantity) {
		this.dispenseQuantity = dispenseQuantity;
	}



	public ArtPepDispensation getArtPepDispensation() {
		return this.artPepDispensation;
	}

	public void setArtPepDispensation(ArtPepDispensation artPepDispensation) {
		this.artPepDispensation = artPepDispensation;
	}

	public FacilityStock getFacilityStock() {
		return this.facilityStock;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}