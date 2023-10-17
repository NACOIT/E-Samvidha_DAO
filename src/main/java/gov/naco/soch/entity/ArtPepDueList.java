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


@GenericGenerator(name = "artPepDueListSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_pep_due_list_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_pep_due_list")
@NamedQuery(name = "ArtPepDueList.findAll", query = "SELECT a FROM ArtPepDueList a")
public class ArtPepDueList extends Auditable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "artPepDueListSequence")
	private Long id;
	

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_visited")
	private Boolean isVisited;

	@Column(name = "visited_date")
	private LocalDate visitedDate;

	@Column(name = "expected_visit_date")
	private LocalDate expectedVisitDate;
	
	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;
	
	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	// bi-directional many-to-one association to ArtPep
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pep_id")
	private ArtPep artPep;

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

	public Boolean getIsVisited() {
		return isVisited;
	}

	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}

	public LocalDate getVisitedDate() {
		return visitedDate;
	}

	public void setVisitedDate(LocalDate visitedDate) {
		this.visitedDate = visitedDate;
	}

	public LocalDate getExpectedVisitDate() {
		return expectedVisitDate;
	}

	public void setExpectedVisitDate(LocalDate expectedVisitDate) {
		this.expectedVisitDate = expectedVisitDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public UserMaster getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public ArtPep getArtPep() {
		return artPep;
	}

	public void setArtPep(ArtPep artPep) {
		this.artPep = artPep;
	}
	
	

}
