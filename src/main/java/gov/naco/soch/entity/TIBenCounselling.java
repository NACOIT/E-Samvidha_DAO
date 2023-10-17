package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * A TIBenCounselling.
 */
@GenericGenerator(name = "benCounsellingSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_counselling_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "tiBenCounsellingGraph", attributeNodes = { @NamedAttributeNode("tiBenCounsellingType")})
@Entity
@Table(name = "ti_ben_counselling")
public class TIBenCounselling extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benCounsellingSequence")
	private Long id;

//	@Column(name = "current_health_status")
//	private String currentHealthStatus;

	@Column(name = "duration_of_counselling")
	private Integer durationOfCounselling;

	@Column(name = "no_of_condoms_distributed")
	private Integer noOfCondomsDistributed;

	@Column(name = "last_counselling_date")
	private LocalDate lastCounsellingDate;

	@Column(name = "counselling_date")
	private LocalDate counsellingDate;

	@Column(name = "next_counselling_date")
	private LocalDate nextCounsellingDate;
	
	@Column(name = "remarks")
	private String remarks;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDelete;
	
	@Column(name="is_early")
	private Boolean isEarly;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private TIBeneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@OneToMany(mappedBy = "tiBenCounselling", cascade = CascadeType.ALL)
	private Set<TiBenCounsellingType> tiBenCounsellingType;
	

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	
	@Column(name="is_csm")
	private Boolean csm;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getCurrentHealthStatus() {
//		return currentHealthStatus;
//	}
//
//	public TIBenCounselling currentHealthStatus(String currentHealthStatus) {
//		this.currentHealthStatus = currentHealthStatus;
//		return this;
//	}
//
//	public void setCurrentHealthStatus(String currentHealthStatus) {
//		this.currentHealthStatus = currentHealthStatus;
//	}

	public Integer getDurationOfCounselling() {
		return durationOfCounselling;
	}

	public TIBenCounselling durationOfCounselling(Integer durationOfCounselling) {
		this.durationOfCounselling = durationOfCounselling;
		return this;
	}

	public void setDurationOfCounselling(Integer durationOfCounselling) {
		this.durationOfCounselling = durationOfCounselling;
	}

	public Integer getNoOfCondomsDistributed() {
		return noOfCondomsDistributed;
	}

	public void setNoOfCondomsDistributed(Integer noOfCondomsDistributed) {
		this.noOfCondomsDistributed = noOfCondomsDistributed;
	}
	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Set<TiBenCounsellingType> getTiBenCounsellingType() {
		return tiBenCounsellingType;
	}

	public void setTiBenCounsellingType(Set<TiBenCounsellingType> tiBenCounsellingType) {
		this.tiBenCounsellingType = tiBenCounsellingType;
		if (tiBenCounsellingType != null) {
			for (TiBenCounsellingType counsellingType : tiBenCounsellingType) {
				this.tiBenCounsellingType.add(addTiBenCounsellingType(counsellingType));
			}
		}
	}

	public TiBenCounsellingType addTiBenCounsellingType(TiBenCounsellingType tiBenCounsellingType) {
		getTiBenCounsellingType().add(tiBenCounsellingType);
		tiBenCounsellingType.setTiBenCounselling(this);
		return tiBenCounsellingType;
	}

	public TiBenCounsellingType removeTiBenCounsellingType(TiBenCounsellingType tiBenCounsellingType) {
		getTiBenCounsellingType().remove(tiBenCounsellingType);
		tiBenCounsellingType.setTiBenCounselling(null);
		return tiBenCounsellingType;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public LocalDate getLastCounsellingDate() {
		return lastCounsellingDate;
	}

	public void setLastCounsellingDate(LocalDate lastCounsellingDate) {
		this.lastCounsellingDate = lastCounsellingDate;
	}

	public LocalDate getCounsellingDate() {
		return counsellingDate;
	}

	public void setCounsellingDate(LocalDate counsellingDate) {
		this.counsellingDate = counsellingDate;
	}

	public LocalDate getNextCounsellingDate() {
		return nextCounsellingDate;
	}

	public void setNextCounsellingDate(LocalDate nextCounsellingDate) {
		this.nextCounsellingDate = nextCounsellingDate;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public TIBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
	}
	
	public Boolean getCsm() {
		return csm;
	}

	public void setCsm(Boolean csm) {
		this.csm = csm;
	}
	
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters
	// and setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TIBenCounselling)) {
			return false;
		}
		return id != null && id.equals(((TIBenCounselling) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "TIBenCounselling{" + "id=" + getId() + ", currentHealthStatus='" + ", durationOfCounselling=" + getDurationOfCounselling() + ", noOfCondomsDistributed="
				+ getNoOfCondomsDistributed() + ", lastCounsellingDate='" + getLastCounsellingDate() + "'"
				+ ", counsellingDate='" + getCounsellingDate() + "'" + ", nextCounsellingDate='"
				+ getNextCounsellingDate() + "'" + ", isActive='" + isIsActive() + "'" + ", isDelete='" + isIsDelete()
				+ "'" + ", createdBy=" + getCreatedBy() + ", createdTime='" + getCreatedTime() + "'" + ", modifiedBy="
				+ getModifiedBy() + ", modifiedTime='" + getModifiedTime() + "'" + "}";
	}
}
