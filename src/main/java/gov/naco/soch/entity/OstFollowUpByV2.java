package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterFollowUpBy;

@Entity(name="OstFollowUpByV2")
@Table(name = "ti_ost_follow_up_by")
@Immutable
public class OstFollowUpByV2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "followup_id")
	private OstFollowUpV2 tiostFollowUp;

	@ManyToOne
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
	
	public OstFollowUpV2 getTiostFollowUp() {
	    return tiostFollowUp;
	}

	public void setTiostFollowUp(OstFollowUpV2 tiostFollowUp) {
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