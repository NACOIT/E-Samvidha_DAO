package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;


@GenericGenerator(name = "beneficiary_transit_facility", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_transit_facility_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_transit_facility")
@NamedQuery(name = "BeneficiaryTransitFacility.findAll", query = "SELECT t FROM BeneficiaryTransitFacility t")
@Where(clause="is_delete=false")
public class BeneficiaryTransitFacility extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "beneficiary_transit_facility")
	private Long id;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;
	
	
	public BeneficiaryTransitFacility() {

	}
	
	public BeneficiaryTransitFacility(Long tfId, Boolean tfIsActive, Boolean tfIsDelete, Long tfOstBenId,
		Long tfFacId) {
	    this.id=tfId;
	    this.isActive=tfIsActive;
	    this.isDelete=tfIsDelete;
	    this.tiOstBeneficiary=new TiOstBeneficiary(tfOstBenId);
	    this.facility=new Facility(tfFacId);
	    
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
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

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

}
