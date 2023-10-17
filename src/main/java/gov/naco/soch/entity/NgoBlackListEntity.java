package gov.naco.soch.entity;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;

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

/**
 * The persistent class for the approve_reject_details database table.
 * 
 */
@GenericGenerator(name = "ngo_blacklist_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ngo_blacklist_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ngo_blacklist_details")
@NamedQuery(name="NgoBlackListEntity.findAll", query="SELECT p FROM NgoBlackListEntity p")
public class NgoBlackListEntity extends Auditable<Long>  implements Serializable  {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
			return serialVersionUID;
		}

	@Id
	@GeneratedValue(generator = "ngo_blacklist_details")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="blacklist_date")
	private LocalDate blackListDate;
		
	@Column(name="facility_id")
	private long facilityId;
	
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}
	
	public LocalDate getBlackListDate() {
		return blackListDate;
	}

	public void setBlackListDate(LocalDate blackListDate) {
		this.blackListDate = blackListDate;
	}
	
}
