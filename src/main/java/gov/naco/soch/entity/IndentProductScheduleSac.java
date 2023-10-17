package gov.naco.soch.entity;

import java.io.Serializable;
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
 * The persistent class for the indent_product_schedule_sacs database table.
 * 
 */
@Entity
@GenericGenerator(name = "indent_product_schedule_sacs", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "indent_product_schedule_sacs_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "indent_product_schedule_sacs")
@NamedQuery(name = "IndentProductScheduleSac.findAll", query = "SELECT i FROM IndentProductScheduleSac i")
public class IndentProductScheduleSac extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "indent_product_schedule_sacs")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to IndentProductSceduleSacsLot
	@OneToMany(mappedBy = "indentProductScheduleSac", cascade = CascadeType.ALL)
	private Set<IndentProductScheduleSacsLot> indentProductSceduleSacsLots;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_facility")
	private Facility facility;

	// bi-directional many-to-one association to IndentProductSchedule
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indent_product_schedule_id")
	private IndentProductSchedule indentProductSchedule;

	public IndentProductScheduleSac() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set<IndentProductScheduleSacsLot> getIndentProductSceduleSacsLots() {
		return this.indentProductSceduleSacsLots;
	}

	public void setIndentProductSceduleSacsLots(Set<IndentProductScheduleSacsLot> indentProductSceduleSacsLots) {
		this.indentProductSceduleSacsLots = indentProductSceduleSacsLots;
	}

	public IndentProductScheduleSacsLot addIndentProductSceduleSacsLot(
			IndentProductScheduleSacsLot indentProductSceduleSacsLot) {
		getIndentProductSceduleSacsLots().add(indentProductSceduleSacsLot);
		indentProductSceduleSacsLot.setIndentProductScheduleSac(this);

		return indentProductSceduleSacsLot;
	}

	public IndentProductScheduleSacsLot removeIndentProductSceduleSacsLot(
			IndentProductScheduleSacsLot indentProductSceduleSacsLot) {
		getIndentProductSceduleSacsLots().remove(indentProductSceduleSacsLot);
		indentProductSceduleSacsLot.setIndentProductScheduleSac(null);

		return indentProductSceduleSacsLot;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public IndentProductSchedule getIndentProductSchedule() {
		return this.indentProductSchedule;
	}

	public void setIndentProductSchedule(IndentProductSchedule indentProductSchedule) {
		this.indentProductSchedule = indentProductSchedule;
	}

}