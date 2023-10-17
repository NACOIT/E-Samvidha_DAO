package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_social_welfare database table.
 * 
 */
@Entity
@Table(name="master_social_welfare")
@NamedQuery(name="MasterSocialWelfare.findAll", query="SELECT m FROM MasterSocialWelfare m")
public class MasterSocialWelfare extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String code;

	private String description;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	
	private String name;

	@Column(name="state_id")
	private Integer stateId;

	//bi-directional many-to-one association to BeneficiarySocialWelfareScheme
//	@OneToMany(mappedBy="masterSocialWelfare")
//	private Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemes;

	public MasterSocialWelfare() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	

//	public Set<BeneficiarySocialWelfareScheme> getBeneficiarySocialWelfareSchemes() {
//		return this.beneficiarySocialWelfareSchemes;
//	}
//
//	public void setBeneficiarySocialWelfareSchemes(Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemes) {
//		this.beneficiarySocialWelfareSchemes = beneficiarySocialWelfareSchemes;
//	}
//
//	public BeneficiarySocialWelfareScheme addBeneficiarySocialWelfareScheme(BeneficiarySocialWelfareScheme beneficiarySocialWelfareScheme) {
//		getBeneficiarySocialWelfareSchemes().add(beneficiarySocialWelfareScheme);
//		beneficiarySocialWelfareScheme.setMasterSocialWelfare(this);
//
//		return beneficiarySocialWelfareScheme;
//	}
//
//	public BeneficiarySocialWelfareScheme removeBeneficiarySocialWelfareScheme(BeneficiarySocialWelfareScheme beneficiarySocialWelfareScheme) {
//		getBeneficiarySocialWelfareSchemes().remove(beneficiarySocialWelfareScheme);
//		beneficiarySocialWelfareScheme.setMasterSocialWelfare(null);
//
//		return beneficiarySocialWelfareScheme;
//	}

}