package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

/**
 * A TIBenScrDetails.
 */
@GenericGenerator(name = "benScreenSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_scr_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "BenRefScrDetails")
@Table(name = "ti_ben_scr_details")
@Immutable
public class BenRefScrDetails extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benScreenSequence")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "infection_id")
	private MasterInfectionType infection;

	@OneToOne(mappedBy = "tiBenScrDetails", cascade = CascadeType.ALL)
	private BeneficiaryReferralOutRefReadOnly beneficiaryReferral;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterInfectionType getInfection() {
		return infection;
	}

	public void setInfection(MasterInfectionType infection) {
		this.infection = infection;
	}

	}
