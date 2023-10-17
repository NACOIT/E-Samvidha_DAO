package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "art_resource_directory")
public class ArtResourceDirectoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_resource_directory")
	private Long id;

	@Column(name = "service_centre")
	private String serviceCentre;

	@Column(name = "service_type")
	private String serviceType;

	@Column(name = "present_address")
	private String presentAddress;

	@Column(name = "in_charge_person")
	private String inChargePerson;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "landline_number")
	private String landlineNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_time")
	private LocalDateTime createdTime;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_time")
	private LocalDateTime modifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceCentre() {
		return serviceCentre;
	}

	public void setServiceCentre(String serviceCentre) {
		this.serviceCentre = serviceCentre;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getInChargePerson() {
		return inChargePerson;
	}

	public void setInChargePerson(String inChargePerson) {
		this.inChargePerson = inChargePerson;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime localDateTime) {
		this.createdTime = localDateTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime localDateTime) {
		this.modifiedTime = localDateTime;
	}

	public ArtResourceDirectoryEntity() {
		super();
	}

}
