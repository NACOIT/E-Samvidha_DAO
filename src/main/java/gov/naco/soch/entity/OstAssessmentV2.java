package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@NamedEntityGraph(name = "ostAssessGraphV2", attributeNodes = {
		@NamedAttributeNode(value = "tiOstBeneficiary", subgraph = "benSubGraph"), }, subgraphs = {})
@Entity(name = "OstAssessmentV2")
@Table(name = "ti_ost_assessment")
@Immutable
public class OstAssessmentV2 extends Auditable<Long>
 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "date_of_assessment")
	private LocalDate dateOfAssessment;

	@Column(name = "injecting_route")
	private Boolean injectingRoute;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "next_date_of_assessment")
	private LocalDate nextDateOfAssessment;


	@ManyToOne
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private OstBenSubEntityV2Assessment tiOstBeneficiary;

	public OstAssessmentV2() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(LocalDate dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
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

	public LocalDate getNextDateOfAssessment() {
		return nextDateOfAssessment;
	}

	public void setNextDateOfAssessment(LocalDate nextDateOfAssessment) {
		this.nextDateOfAssessment = nextDateOfAssessment;
	}

	public OstBenSubEntityV2Assessment getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(OstBenSubEntityV2Assessment tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Boolean getInjectingRoute() {
		return injectingRoute;
	}

	public void setInjectingRoute(Boolean injectingRoute) {
		this.injectingRoute = injectingRoute;
	}

}