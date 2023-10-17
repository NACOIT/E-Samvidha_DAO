package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "hotspotBenSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_beneficiary_hotspot_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_beneficiary_hotspot_mapping")
@Immutable
public class TiBeneficiaryHotSpotReadOnly extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "hotspotBenSequence")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDelete;

	@ManyToOne
	@JoinColumn(name = "ti_beneficiary_id")
	private TiBeneficiaryReadOnly tiBeneficiary;

	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBeneficiaryReadOnly tiOstBeneficiary;

	@ManyToOne
	@JoinColumn(name = "hotspot_id")
	private TIHotspot hotspot;

	public TiBeneficiaryHotSpotReadOnly() {
	}
	
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

	public TiBeneficiaryReadOnly getTiBeneficiary() {
	    return tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiaryReadOnly tiBeneficiary) {
	    this.tiBeneficiary = tiBeneficiary;
	}

	public OstBeneficiaryReadOnly getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBeneficiaryReadOnly tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public TIHotspot getHotspot() {
		return hotspot;
	}

	public void setHotspot(TIHotspot hotspot) {
		this.hotspot = hotspot;
	}

}
