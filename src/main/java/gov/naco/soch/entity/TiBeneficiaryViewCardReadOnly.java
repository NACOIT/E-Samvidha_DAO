package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "tiBeneficiaryViewCardReadOnlyGraph", attributeNodes = {
		@NamedAttributeNode("tiCounselling"),@NamedAttributeNode("tiScreening"),@NamedAttributeNode("tiAssessment")})

@Entity(name = "TiBeneficiaryViewCardReadOnly")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBeneficiaryViewCardReadOnly extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benSequence")
	private Long id;

	@OneToMany(mappedBy = "beneficiary")
	@BatchSize(size = 30)
	@OrderBy("id DESC")
	private SortedSet<TIBenCounsellingViewCardReadOnly> tiCounselling= new TreeSet<>();
	
	@OneToMany(mappedBy = "beneficiary")
	@BatchSize(size = 30)
	@OrderBy("id DESC")
	private Set<TIBenScrDetailsViewCardReadOnly>  tiScreening = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "beneficiary")
	@BatchSize(size = 30)
	@OrderBy("id DESC")
	private SortedSet<TIBenRVAssessmentViewCardReadOnly> tiAssessment = new TreeSet<>();
 
	
    @OneToOne
    private BeneficiaryViewCardReadOnly beneficiary;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterTiClientStatus status;
    
    @ManyToOne
    private FacilityReadOnly facility;
    
    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
    TypologyMasterVCReadOnly hrgPrimary;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SortedSet<TIBenCounsellingViewCardReadOnly> getTiCounselling() {
		return tiCounselling;
	}

	public void setTiCounselling(SortedSet<TIBenCounsellingViewCardReadOnly> tiCounselling) {
		this.tiCounselling = tiCounselling;
	}

	public Set<TIBenScrDetailsViewCardReadOnly> getTiScreening() {
		return tiScreening;
	}

	public void setTiScreening(Set<TIBenScrDetailsViewCardReadOnly> tiScreening) {
		this.tiScreening = tiScreening;
	}

	public SortedSet<TIBenRVAssessmentViewCardReadOnly> getTiAssessment() {
		return tiAssessment;
	}

	public void setTiAssessment(SortedSet<TIBenRVAssessmentViewCardReadOnly> tiAssessment) {
		this.tiAssessment = tiAssessment;
	}

	public BeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterTiClientStatus getStatus() {
		return status;
	}

	public void setStatus(MasterTiClientStatus status) {
		this.status = status;
	}

	public FacilityReadOnly getFacility() {
		return facility;
	}

	public void setFacility(FacilityReadOnly facility) {
		this.facility = facility;
	}

	public TypologyMasterVCReadOnly getHrgPrimary() {
		return hrgPrimary;
	}

	public void setHrgPrimary(TypologyMasterVCReadOnly hrgPrimary) {
		this.hrgPrimary = hrgPrimary;
	}

}
