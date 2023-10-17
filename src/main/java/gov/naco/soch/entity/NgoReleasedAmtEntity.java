package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Date;

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
 * The persistent class for the gb_details database table.
 * 
 */
@GenericGenerator(name = "ngo_soe_released_fund", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ngo_soe_released_fund_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ngo_soe_released_fund")
@NamedQuery(name="NgoReleasedAmtEntity.findAll", query="SELECT p FROM NgoReleasedAmtEntity p")
public class NgoReleasedAmtEntity extends Auditable<Long>  implements Serializable  {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
			return serialVersionUID;
		}

	@Id
	@GeneratedValue(generator = "ngo_soe_released_fund")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "facility_id")
	private Long facilityId;
	
	@Column(name="project_id")
	private Long projectId;

	@Column(name="financial_year")
	private String financialYear;
	
	@Column(name="soe_released_amount")
	private String releasedAmount;

	@Column(name="soe_released_date")
	private Date releaseDate;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="status")
	private Integer status;
		
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

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getReleasedAmount() {
		return releasedAmount;
	}

	public void setReleasedAmount(String releasedAmount) {
		this.releasedAmount = releasedAmount;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
