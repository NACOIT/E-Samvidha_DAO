package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryDueListMiniMapper.class)
public abstract class ArtBeneficiaryDueListMiniMapper_ {

	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, Boolean> isVisited;
	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, BeneficiaryMiniProfile> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, Integer> id;
	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, LocalDate> expectedVisitDate;
	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryDueListMiniMapper, FacilityMiniProfile> facility;

	public static final String IS_VISITED = "isVisited";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String EXPECTED_VISIT_DATE = "expectedVisitDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

