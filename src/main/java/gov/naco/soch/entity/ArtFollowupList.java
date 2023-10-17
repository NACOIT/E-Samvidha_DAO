package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the art_followup_list database table.
 * 
 */


@GenericGenerator(name = "art_followup_list", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_followup_list_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_followup_list")
@NamedQuery(name = "ArtFollowupList.findAll", query = "SELECT a FROM ArtFollowupList a")
public class ArtFollowupList extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_followup_list")
	private Long id;

	@Column(name = "year_generated")
	private Integer yearGenerated;

	@Column(name = "month_generated")
	private Integer monthGenerated;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;
	
	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;
	
	@Column(name="art_beneficiary_status_id_captured")
	private Long artBeneficiaryStatusIdCaptured;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYearGenerated() {
		return yearGenerated;
	}

	public void setYearGenerated(Integer yearGenerated) {
		this.yearGenerated = yearGenerated;
	}

	public Integer getMonthGenerated() {
		return monthGenerated;
	}

	public void setMonthGenerated(Integer monthGenerated) {
		this.monthGenerated = monthGenerated;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Long getArtBeneficiaryStatusIdCaptured() {
		return artBeneficiaryStatusIdCaptured;
	}

	public void setArtBeneficiaryStatusIdCaptured(Long artBeneficiaryStatusIdCaptured) {
		this.artBeneficiaryStatusIdCaptured = artBeneficiaryStatusIdCaptured;
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

	@Override
	public String toString() {
		return "ArtFollowupList [id=" + id + ", yearGenerated=" + yearGenerated + ", monthGenerated=" + monthGenerated
				+ ", facility=" + facility + ", beneficiary=" + beneficiary + ", artBeneficiaryStatusIdCaptured="
				+ artBeneficiaryStatusIdCaptured + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}
	
	
}
