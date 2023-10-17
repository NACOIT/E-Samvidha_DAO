package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

import gov.naco.soch.entity.Auditable;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.TIBeneficiary;

/**
 * A TIBenChildDetails.
 */
@GenericGenerator(name = "benChildSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_child_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name="TiBenChildDetailsReadOnly")
@Table(name = "ti_ben_child_details")
@Where(clause="is_delete=false")
@Immutable
public class TiBenChildDetailsReadOnly extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benChildSequence")
	private Long id;

	@Column(name = "age")
	private Integer age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private MasterGender genderId;

	@Column(name="facility_id")
	private Long facilityId;
        
	@ManyToOne(fetch = FetchType.LAZY)
	private TiBeneficiaryReadOnly beneficiary;
	
	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name="is_active")
	private Boolean isActive;

	public TiBenChildDetailsReadOnly() {
	    // TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public TiBenChildDetailsReadOnly age(Integer age) {
		this.age = age;
		return this;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public MasterGender getGenderId() {
		return genderId;
	}
	

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}

	public TiBeneficiaryReadOnly getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBeneficiaryReadOnly beneficiary) {
	    this.beneficiary = beneficiary;
	}

	public void setGenderId(MasterGender genderId) {
		this.genderId = genderId;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TiBenChildDetailsReadOnly)) {
			return false;
		}
		return id != null && id.equals(((TiBenChildDetailsReadOnly) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	


}
