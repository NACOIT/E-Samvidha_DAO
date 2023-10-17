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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the private_dispensation database table.
 * 
 */

@Entity
@GenericGenerator(name = "art_private_dispensation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_private_dispensation_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "art_private_dispensation")
@NamedQuery(name = "ArtPrivateDispensation.findAll", query = "SELECT a FROM ArtPrivateDispensation a")
public class ArtPrivateDispensation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_private_dispensation")
	private Long id;

	@Column(name = "private_facility_name")
	private String privateFacilityName;

	@Column(name = "private_beneficiary_name")
	private String beneficiaryName;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "dispense_date")
	private LocalDate dispenseDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to MasterGender
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private MasterGender masterGender;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dispensed_facility_id")
	private Facility facility;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster userMaster;

	// bi-directional many-to-one association to ArtPepDispensationItem
	@OneToMany(mappedBy = "artPrivateDispensation", cascade = CascadeType.ALL)
	private Set<ArtPrivateDispensationItem> artPrivateDispensationItems;

	public ArtPrivateDispensation() {

	}

	public Long getId() {
		return id;
	}

	public String getPrivateFacilityName() {
		return privateFacilityName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getContactNo() {
		return contactNo;
	}

	public LocalDate getDispenseDate() {
		return dispenseDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public MasterGender getMasterGender() {
		return masterGender;
	}

	public Facility getFacility() {
		return facility;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrivateFacilityName(String privateFacilityName) {
		this.privateFacilityName = privateFacilityName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setDispenseDate(LocalDate dispenseDate) {
		this.dispenseDate = dispenseDate;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public Set<ArtPrivateDispensationItem> getPrivateDispensationItems() {
		return artPrivateDispensationItems;
	}

	public void setPrivateDispensationItems(Set<ArtPrivateDispensationItem> artPrivateDispensationItems) {
		this.artPrivateDispensationItems = artPrivateDispensationItems;
	}

	public ArtPrivateDispensationItem addPrivateDispensationItem(ArtPrivateDispensationItem artPrivateDispensationItem) {
		getPrivateDispensationItems().add(artPrivateDispensationItem);
		artPrivateDispensationItem.setPrivateDispensation(this);
		return artPrivateDispensationItem;
	}

	public ArtPrivateDispensationItem removePrivateDispensationItem(ArtPrivateDispensationItem artPrivateDispensationItem) {
		getPrivateDispensationItems().remove(artPrivateDispensationItem);
		artPrivateDispensationItem.setPrivateDispensation(null);
		return artPrivateDispensationItem;
	}

}
