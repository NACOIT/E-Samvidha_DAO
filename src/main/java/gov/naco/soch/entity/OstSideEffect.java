package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterOstSideEffect;

@Entity(name = "OstSideEffect")
@Table(name = "ti_ost_followup_side_effect_mapping")
@Immutable
public class OstSideEffect implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "followup_id")
    private OstFollowUp tiostFollowUp;

    @ManyToOne
    @JoinColumn(name = "side_effect_id")
    private MasterOstSideEffect sideEffect;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    public OstSideEffect() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public OstFollowUp getTiostFollowUp() {
	return tiostFollowUp;
    }

    public void setTiostFollowUp(OstFollowUp tiostFollowUp) {
	this.tiostFollowUp = tiostFollowUp;
    }

    public MasterOstSideEffect getSideEffect() {
	return sideEffect;
    }

    public void setSideEffect(MasterOstSideEffect sideEffect) {
	this.sideEffect = sideEffect;
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
