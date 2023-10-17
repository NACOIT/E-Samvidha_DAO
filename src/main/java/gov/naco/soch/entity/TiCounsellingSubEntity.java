package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.TiBenCounsellingType;

@NamedEntityGraph(name = "counsellingGraph", attributeNodes = { @NamedAttributeNode("tiBenCounsellingType")})
@Entity(name = "TiCounsellingSubEntity")
@Table(name = "ti_ben_counselling")
@Immutable
public class TiCounsellingSubEntity implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
        @Id
	private Long id;

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
	
	@Column(name="facility_id")
	private Long facilityId;
	
	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private TiBenSubEntity beneficiary;
	
	@OneToMany(mappedBy = "tiBenCounselling")
	private Set<TiBenCounsellingType> tiBenCounsellingType;
    
         public TiCounsellingSubEntity() {
	    
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public Integer getDurationOfCounselling() {
	    return durationOfCounselling;
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

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}

	public TiBenSubEntity getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBenSubEntity beneficiary) {
	    this.beneficiary = beneficiary;
	}

	public Set<TiBenCounsellingType> getTiBenCounsellingType() {
	    return tiBenCounsellingType;
	}

	public void setTiBenCounsellingType(Set<TiBenCounsellingType> tiBenCounsellingType) {
	    this.tiBenCounsellingType = tiBenCounsellingType;
	}
         
         

}
