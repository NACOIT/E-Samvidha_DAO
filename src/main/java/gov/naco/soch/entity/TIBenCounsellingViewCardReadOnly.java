package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;


@GenericGenerator(name = "benCounsellingSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_counselling_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "tiBenCounsellingViewCardReadOnlyGraph")
//@NamedEntityGraph(name = "tiBenCounsellingViewCardReadOnlyGraph", attributeNodes = { @NamedAttributeNode("tiBenCounsellingType")})
@Entity(name = "TIBenCounsellingViewCardReadOnly")
@Table(name = "ti_ben_counselling")
@Immutable
public class TIBenCounsellingViewCardReadOnly  extends Auditable<Long> implements Serializable,Comparable<TIBenCounsellingViewCardReadOnly>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "benCounsellingTypeSequence")
	private Long id;
	
	@Column(name = "last_counselling_date")
	private LocalDate lastCounsellingDate;
	
	@Column(name = "next_counselling_date")
	private LocalDate nextCounsellingDate;
	

	@OneToMany(mappedBy = "tiBenCounselling", cascade = CascadeType.ALL)
	private Set<TIBenCounsellingTypeReadOnly> tiBenCounsellingType;

	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private TiBeneficiaryViewCardReadOnly beneficiary;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getLastCounsellingDate() {
		return lastCounsellingDate;
	}


	public void setLastCounsellingDate(LocalDate lastCounsellingDate) {
		this.lastCounsellingDate = lastCounsellingDate;
	}


	public LocalDate getNextCounsellingDate() {
		return nextCounsellingDate;
	}


	public void setNextCounsellingDate(LocalDate nextCounsellingDate) {
		this.nextCounsellingDate = nextCounsellingDate;
	}


	public Set<TIBenCounsellingTypeReadOnly> getTiBenCounsellingType() {
		return tiBenCounsellingType;
	}


	public void setTiBenCounsellingType(Set<TIBenCounsellingTypeReadOnly> tiBenCounsellingType) {
		this.tiBenCounsellingType = tiBenCounsellingType;
	}


	public TiBeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}


	public void setBeneficiary(TiBeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}


	@Override
	public int compareTo(TIBenCounsellingViewCardReadOnly o) {
	    return 0;
	}	
}
