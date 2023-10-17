package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the machine database table.
 * 
 */
@Entity
@Table(name = "dashboard_indicator_estimate_details")
@NamedQuery(name = "DashboardIndicatorEstimateDetails.findAll", query = "SELECT m FROM DashboardIndicatorEstimateDetails m")
public class DashboardIndicatorEstimateDetails extends Auditable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_indicator_id")
	private MasterDashboardIndicator dashboardIndicatorId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_geographical_level_id")
	private MasterDashboardGeographicalLevel dashboardGeographicalLevelId;
	
	private String countryName;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
	private State stateId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
	private District districtId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "age_group_id")
	private MasterAgeGroup ageGroupId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_typology_id")
	private MasterDashboardTypology dashboardtypologyId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_gender_id")
	private MasterDashboardGender dashboardGenderId;
	
	private String reportedYear;
	
	private Long estimateValue;
	
	private Long lowRange;
	
	private Long highRange;
	
	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
		
	public DashboardIndicatorEstimateDetails() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public MasterDashboardIndicator getDashboardIndicatorId() {
		return dashboardIndicatorId;
	}

	public void setDashboardIndicatorId(MasterDashboardIndicator dashboardIndicatorId) {
		this.dashboardIndicatorId = dashboardIndicatorId;
	}

	public MasterDashboardGeographicalLevel getDashboardGeographicalLevelId() {
		return dashboardGeographicalLevelId;
	}

	public void setDashboardGeographicalLevelId(MasterDashboardGeographicalLevel dashboardGeographicalLevelId) {
		this.dashboardGeographicalLevelId = dashboardGeographicalLevelId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public District getDistrictId() {
		return districtId;
	}

	public void setDistrictId(District districtId) {
		this.districtId = districtId;
	}

	public MasterAgeGroup getAgeGroupId() {
		return ageGroupId;
	}

	public void setAgeGroupId(MasterAgeGroup ageGroupId) {
		this.ageGroupId = ageGroupId;
	}

	public MasterDashboardTypology getDashboardtypologyId() {
		return dashboardtypologyId;
	}

	public void setDashboardtypologyId(MasterDashboardTypology dashboardtypologyId) {
		this.dashboardtypologyId = dashboardtypologyId;
	}

	public MasterDashboardGender getDashboardGenderId() {
		return dashboardGenderId;
	}

	public void setDashboardGenderId(MasterDashboardGender dashboardGenderId) {
		this.dashboardGenderId = dashboardGenderId;
	}

	public String getReportedYear() {
		return reportedYear;
	}

	public void setReportedYear(String reportedYear) {
		this.reportedYear = reportedYear;
	}

	public Long getEstimateValue() {
		return estimateValue;
	}

	public void setEstimateValue(Long estimateValue) {
		this.estimateValue = estimateValue;
	}

	public Long getLowRange() {
		return lowRange;
	}

	public void setLowRange(Long lowRange) {
		this.lowRange = lowRange;
	}

	public Long getHighRange() {
		return highRange;
	}

	public void setHighRange(Long highRange) {
		this.highRange = highRange;
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
