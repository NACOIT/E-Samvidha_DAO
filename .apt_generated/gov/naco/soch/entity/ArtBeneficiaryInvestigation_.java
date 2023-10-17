package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryInvestigation.class)
public abstract class ArtBeneficiaryInvestigation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, Long> visitRegisterId;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, MasterInvestigation> masterInvestigation;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, String> investigationValue;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, Facility> facility;
	public static volatile SingularAttribute<ArtBeneficiaryInvestigation, LocalDate> investigationDate;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String VISIT_REGISTER_ID = "visitRegisterId";
	public static final String MASTER_INVESTIGATION = "masterInvestigation";
	public static final String INVESTIGATION_VALUE = "investigationValue";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String INVESTIGATION_DATE = "investigationDate";

}

