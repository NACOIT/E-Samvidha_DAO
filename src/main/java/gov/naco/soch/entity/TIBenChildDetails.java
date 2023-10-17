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
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

/**
 * A TIBenChildDetails.
 */
@GenericGenerator(name = "benChildSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_child_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_child_details")
@Where(clause="is_delete=false")
public class TIBenChildDetails extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benChildSequence")
	private Long id;

	@Column(name = "age")
	private Integer age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private MasterGender genderId;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private TIBeneficiary beneficiary;
	
	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name="is_active")
	private Boolean isActive;

	public TIBenChildDetails() {
	 
	}
	
	public TIBenChildDetails(Long id, Integer age, MasterGender genderId, Boolean isDelete, Boolean isActive, Long benChildBenId, Long benChildFacId) {
	    this.id = id;
	    this.age = age;
	    this.genderId = genderId;
	    this.beneficiary= new TIBeneficiary(benChildBenId);
	    this.facility=new Facility(benChildFacId);
	    this.isDelete = isDelete;
	    this.isActive = isActive;
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

	public TIBenChildDetails age(Integer age) {
		this.age = age;
		return this;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public MasterGender getGenderId() {
		return genderId;
	}

	public void setGenderId(MasterGender genderId) {
		this.genderId = genderId;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TIBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public TIBenChildDetails beneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
		return this;
	}

	public void setBeneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
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
		if (!(o instanceof TIBenChildDetails)) {
			return false;
		}
		return id != null && id.equals(((TIBenChildDetails) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "TIBenChildDetails [id=" + id + ", age=" + age +", facility=" + facility
				+ ", beneficiary=" + beneficiary + "]";
	}


}
