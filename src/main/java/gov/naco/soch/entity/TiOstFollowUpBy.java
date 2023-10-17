package gov.naco.soch.entity;

import java.io.Serializable;

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

@GenericGenerator(name = "tiOstFollowUpBy", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_follow_up_by_id_seq"),
		 @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_follow_up_by")
@NamedQuery(name = "TiOstFollowUpBy.findAll", query = "SELECT t FROM TiOstFollowUpBy t")
public class TiOstFollowUpBy extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstFollowUpBy")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "followup_id")
	private TiOstFollowUp tiostFollowUp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "follow_up_by_id")
	private MasterFollowUpBy followUpBy;

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

	public TiOstFollowUp getTiostFollowUp() {
		return tiostFollowUp;
	}

	public void setTiostFollowUp(TiOstFollowUp tiostFollowUp) {
		this.tiostFollowUp = tiostFollowUp;
	}

	public MasterFollowUpBy getFollowUpBy() {
		return followUpBy;
	}

	public void setFollowUpBy(MasterFollowUpBy followUpBy) {
		this.followUpBy = followUpBy;
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

}
