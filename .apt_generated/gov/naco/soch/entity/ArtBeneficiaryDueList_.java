package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryDueList.class)
public abstract class ArtBeneficiaryDueList_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryDueList, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, Boolean> isVisited;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, LocalDate> visitedDate;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, Integer> id;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, LocalDate> expectedVisitDate;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryDueList, Facility> facility;

	public static final String ENTRY_USER = "entryUser";
	public static final String IS_VISITED = "isVisited";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String VISITED_DATE = "visitedDate";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String EXPECTED_VISIT_DATE = "expectedVisitDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

