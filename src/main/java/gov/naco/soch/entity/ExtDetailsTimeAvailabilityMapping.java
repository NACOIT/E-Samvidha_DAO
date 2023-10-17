package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;


@GenericGenerator(name = "ti_ext_details_time_availability_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ext_details_time_availability_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="ti_ext_details_time_availability_mapping")
@Where(clause="is_delete=false")
public class ExtDetailsTimeAvailabilityMapping  extends Auditable<Long> implements Serializable {
 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ti_ext_details_time_availability_mapping")
	private Long id;
	
	//bi-directional many-to-one association to TIBeneficiaryExtDetails
	@ManyToOne
	@JoinColumn(name="ti_ben_ext_details_id")
	private TIBeneficiaryExtDetails tiBeneficiaryExtDetails;
	
	//bi-directional many-to-one association to MasterBenificiaryTimeAvailability
	@ManyToOne
	@JoinColumn(name="master_beneficiary_time_availability_id")
	private MasterBenificiaryTimeAvailability masterBenificiaryTimeAvailability;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;


	public ExtDetailsTimeAvailabilityMapping() {
	
	}
	
	public ExtDetailsTimeAvailabilityMapping(Long timeAvailId, Boolean timeAvailisActive, Boolean timeAvailisDelete,
		Long timeAvailExtId, Long masterTimeId, String masterTimeName) {
	   
	    this.id=timeAvailId;
	    this.isActive=timeAvailisActive;
	    this.isDelete=timeAvailisDelete;
	    this.tiBeneficiaryExtDetails=new  TIBeneficiaryExtDetails(timeAvailExtId);
	    this.masterBenificiaryTimeAvailability= new MasterBenificiaryTimeAvailability(masterTimeId,masterTimeName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TIBeneficiaryExtDetails getTiBeneficiaryExtDetails() {
		return tiBeneficiaryExtDetails;
	}

	public void setTiBeneficiaryExtDetails(TIBeneficiaryExtDetails tiBeneficiaryExtDetails) {
		this.tiBeneficiaryExtDetails = tiBeneficiaryExtDetails;
	}

	public MasterBenificiaryTimeAvailability getMasterBenificiaryTimeAvailability() {
		return masterBenificiaryTimeAvailability;
	}

	public void setMasterBenificiaryTimeAvailability(MasterBenificiaryTimeAvailability masterBenificiaryTimeAvailability) {
		this.masterBenificiaryTimeAvailability = masterBenificiaryTimeAvailability;
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
	
}
