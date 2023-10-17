package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "OstFollowUpVCReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_follow_up_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "OstFollowUpVCReadOnlyGraph")
	@Entity(name = "OstFollowUpVCReadOnly")
	@Table(name = "ti_ost_follow_up")
	@Immutable
public class OstFollowUpVCReadOnly implements Serializable,Comparable<OstFollowUpVCReadOnly>{
	
    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(generator = "OstFollowUpVCReadOnly")
    private Long id;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;
    
    @Column(name = "next_followup_date")
    private LocalDate nextFollowupDate;
    
    @ManyToOne
    @JoinColumn(name = "ti_ost_beneficiary_id")
    private OstBenSubEntityVCReadOnly tiOstBeneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public LocalDate getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(LocalDate nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public OstBenSubEntityVCReadOnly getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBenSubEntityVCReadOnly tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	@Override
	public int compareTo(OstFollowUpVCReadOnly o) {
	    // TODO Auto-generated method stub
	    return 0;
	}
}
