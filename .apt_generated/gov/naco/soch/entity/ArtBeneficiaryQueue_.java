package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryQueue.class)
public abstract class ArtBeneficiaryQueue_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryQueue, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, UserMaster> assignedToUser;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, Boolean> isVisited;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, LocalDate> visitDate;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryQueue, Facility> facility;

	public static final String ENTRY_USER = "entryUser";
	public static final String ASSIGNED_TO_USER = "assignedToUser";
	public static final String IS_VISITED = "isVisited";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

