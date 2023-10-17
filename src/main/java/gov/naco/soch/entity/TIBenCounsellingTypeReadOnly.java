package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benCounsellingTypeSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_counselling_type_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity(name = "TIBenCounsellingTypeReadOnly")
@Table(name = "ti_ben_counselling_type")
@NamedQuery(name = "TIBenCounsellingTypeReadOnly.findAll", query = "SELECT t FROM TIBenCounsellingTypeReadOnly t")
public class TIBenCounsellingTypeReadOnly extends Auditable<Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benCounsellingTypeSequence")
	private Long id;


	@ManyToOne
	@JoinColumn(name = "counselling_id")
	private TIBenCounsellingViewCardReadOnly tiBenCounselling;
	
	@ManyToOne
	@JoinColumn(name = "master_counselling_type_id")
	private MasterCounsellingType masterCounsellingType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TIBenCounsellingViewCardReadOnly getTiBenCounselling() {
		return tiBenCounselling;
	}

	public void setTiBenCounselling(TIBenCounsellingViewCardReadOnly tiBenCounselling) {
		this.tiBenCounselling = tiBenCounselling;
	}

	public MasterCounsellingType getMasterCounsellingType() {
		return masterCounsellingType;
	}

	public void setMasterCounsellingType(MasterCounsellingType masterCounsellingType) {
		this.masterCounsellingType = masterCounsellingType;
	}
}
