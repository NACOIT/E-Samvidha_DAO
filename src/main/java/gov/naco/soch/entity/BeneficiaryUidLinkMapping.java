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

@Entity
@GenericGenerator(name = "beneficiary_uid_link_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_uid_link_mapping_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "beneficiary_uid_link_mapping")
@NamedQuery(name = "BeneficiaryUidLinkMapping.findAll", query = "SELECT a FROM BeneficiaryUidLinkMapping a")
public class BeneficiaryUidLinkMapping extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary_uid_link_mapping")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "base_beneficiary_id")
	private Beneficiary baseBeneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid_link_beneficiary_id")
	private Beneficiary linkBeneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "base_facility_id")
	private Facility baseFacility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid_link_facility_id")
	private Facility linkFacility;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Beneficiary getBaseBeneficiary() {
		return baseBeneficiary;
	}

	public void setBaseBeneficiary(Beneficiary baseBeneficiary) {
		this.baseBeneficiary = baseBeneficiary;
	}

	public Beneficiary getLinkBeneficiary() {
		return linkBeneficiary;
	}

	public void setLinkBeneficiary(Beneficiary linkBeneficiary) {
		this.linkBeneficiary = linkBeneficiary;
	}

	public Facility getBaseFacility() {
		return baseFacility;
	}

	public void setBaseFacility(Facility baseFacility) {
		this.baseFacility = baseFacility;
	}

	public Facility getLinkFacility() {
		return linkFacility;
	}

	public void setLinkFacility(Facility linkFacility) {
		this.linkFacility = linkFacility;
	}

}
