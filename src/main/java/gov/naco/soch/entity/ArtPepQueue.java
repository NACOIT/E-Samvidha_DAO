package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the art_pep_queue database table.
 * 
 */
@GenericGenerator(name = "art_pep_queue", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_pep_queue_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_pep_queue")
@NamedQuery(name = "ArtPepQueue.findAll", query = "SELECT a FROM ArtPepQueue a")
public class ArtPepQueue extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_pep_queue")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_visited")
	private Boolean isVisited;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to")
	private UserMaster assignedTo;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	// bi-directional many-to-one association to ArtPep
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pep_id")
	private ArtPep artPep;

	public ArtPepQueue() {
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

	public Boolean getIsVisited() {
		return this.isVisited;
	}

	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}

	public LocalDate getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(LocalDate localDate) {
		this.visitDate = localDate;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public UserMaster getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserMaster assignedTo) {
		this.assignedTo = assignedTo;
	}

	public UserMaster getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public ArtPep getArtPep() {
		return this.artPep;
	}

	public void setArtPep(ArtPep artPep) {
		this.artPep = artPep;
	}

}