package gov.naco.soch.entity;

import java.io.Serializable;
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
 * The persistent class for the transporter_sacs_mapping database table.
 * 
 */
@GenericGenerator(name = "transporter_sacs_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "transporter_sacs_mapping_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "transporter_sacs_mapping")
@NamedQuery(name = "TransporterSacsMapping.findAll", query = "SELECT t FROM TransporterSacsMapping t")
public class TransporterSacsMapping extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "transporter_sacs_mapping")
	private Long id;

	@Column(name = "mapping_date")
	private LocalDate mappingDate;

	@Column(name = "mapping_status_flag")
	private Boolean mappingStatusFlag;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporter_id")
	private Facility transporter;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacs_id")
	private Facility sacs;

	public Long getId() {
		return id;
	}

	public LocalDate getMappingDate() {
		return mappingDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Facility getTransporter() {
		return transporter;
	}

	public Facility getSacs() {
		return sacs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMappingDate(LocalDate mappingDate) {
		this.mappingDate = mappingDate;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setTransporter(Facility transporter) {
		this.transporter = transporter;
	}

	public void setSacs(Facility sacs) {
		this.sacs = sacs;
	}

	public Boolean getMappingStatusFlag() {
		return mappingStatusFlag;
	}

	public void setMappingStatusFlag(Boolean mappingStatusFlag) {
		this.mappingStatusFlag = mappingStatusFlag;
	}

}
