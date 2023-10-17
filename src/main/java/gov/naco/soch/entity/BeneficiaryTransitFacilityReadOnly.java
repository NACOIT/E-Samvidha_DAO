package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

import gov.naco.soch.entity.OstBenSubEntity;


@GenericGenerator(name = "beneficiary_transit_facility", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_transit_facility_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name="BeneficiaryTransitFacilityReadOnly")
@Table(name = "beneficiary_transit_facility")
@Where(clause="is_delete=false")
@Immutable
public class BeneficiaryTransitFacilityReadOnly extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "beneficiary_transit_facility")
	private Long id;

	@Column(name = "status")
	private String status;

        @Column(name="facility_id")
	private Long facilityId;

//	@ManyToOne
//	@JoinColumn(name = "ti_ost_beneficiary_id")
//	private OstBeneficiaryReadOnly tiOstBeneficiary;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
//	@ManyToOne
//	@JoinColumn(name = "beneficiary_id")
//	private Beneficiary beneficiary;
	
	
	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBenSubEntity tiOstBeneficiary;
	
	public BeneficiaryTransitFacilityReadOnly() {
	   
	}

	public Long getFacilityId() {
	    return facilityId;
	}



	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}



	public OstBenSubEntity getTiOstBeneficiary() {
	    return tiOstBeneficiary;
	}



	public void setTiOstBeneficiary(OstBenSubEntity tiOstBeneficiary) {
	    this.tiOstBeneficiary = tiOstBeneficiary;
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

//	public Beneficiary getBeneficiary() {
//		return beneficiary;
//	}
//
//	public void setBeneficiary(Beneficiary beneficiary) {
//		this.beneficiary = beneficiary;
//	}

}
