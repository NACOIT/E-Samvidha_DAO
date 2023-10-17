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
@GenericGenerator(name = "registration_certificate", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "registration_certificate_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "registration_certificate")
@NamedQuery(name="NgoDocumentsEntity.findAll", query="SELECT p FROM NgoDocumentsEntity p")
public class NgoDocumentsEntity extends Auditable<Long>  implements Serializable  {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
			return serialVersionUID;
		}

	@Id
	@GeneratedValue(generator = "registration_certificate")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name="remarks")
	private String remarks;
	
	@Column(name="facility_id")
	private long facilityId;
	
	@Column(name="sacs_id")
	private long sacsId;
	
	@Column(name="financial_year")
	private String financialYear;
	
	@Column(name="valid_till")
	private String societyValiditydate;	
	
	@Column(name="file_type")
	private String fileType;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name="status")
	private long status;
	
	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
	
	
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

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String fileStorageLocation) {
		this.filePath = fileStorageLocation;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getSocietyValiditydate() {
		return societyValiditydate;
	}

	public void setSocietyValiditydate(String societyValiditydate) {
		this.societyValiditydate = societyValiditydate;
	}

	public long getSacsId() {
		return sacsId;
	}

	public void setSacsId(long sacsId) {
		this.sacsId = sacsId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	
	
}
