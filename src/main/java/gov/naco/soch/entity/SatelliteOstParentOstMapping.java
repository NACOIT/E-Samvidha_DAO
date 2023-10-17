package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "facility_satelliteost_parentost_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_satelliteost_parentost_mapping_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "facility_satelliteost_parentost_mapping")
@NamedQuery(name = "SatelliteOstParentOstMapping.findAll", query = "SELECT s FROM SatelliteOstParentOstMapping s")
public class SatelliteOstParentOstMapping extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_satelliteost_parentost_mapping")
	@Column(unique = true, nullable = false)
	private Long id;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "satellite_ost_id")
	private Facility satelliteOst;

	// bi-directional many-to-one association to Lab
	@ManyToOne
	@JoinColumn(name = "parent_ost_id")
	private Facility parentOst;

	@Column(name = "mapping_date")
	private LocalDateTime mappingDate;

	@Column(name = "mapping_status_flag")
	private Boolean mappingStatusFlag;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facility getSatelliteOst() {
		return satelliteOst;
	}

	public void setSatelliteOst(Facility satelliteOst) {
		this.satelliteOst = satelliteOst;
	}

	public Facility getParentOst() {
		return parentOst;
	}

	public void setParentOst(Facility parentOst) {
		this.parentOst = parentOst;
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

	public LocalDateTime getMappingDate() {
		return mappingDate;
	}

	public void setMappingDate(LocalDateTime mappingDate) {
		this.mappingDate = mappingDate;
	}

	public Boolean getMappingStatusFlag() {
		return mappingStatusFlag;
	}

	public void setMappingStatusFlag(Boolean mappingStatusFlag) {
		this.mappingStatusFlag = mappingStatusFlag;
	}

}
