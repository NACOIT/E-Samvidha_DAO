package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtDispensation.class)
public abstract class ArtDispensation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtDispensation, UserMaster> userMaster;
	public static volatile SetAttribute<ArtDispensation, ArtDispensationItem> artDispensationItems;
	public static volatile SingularAttribute<ArtDispensation, ArtBeneficiaryDueList> artBeneficiaryDueList;
	public static volatile SingularAttribute<ArtDispensation, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtDispensation, Boolean> isDelete;
	public static volatile SingularAttribute<ArtDispensation, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtDispensation, LocalDate> dispenseDate;
	public static volatile SingularAttribute<ArtDispensation, Long> id;
	public static volatile SingularAttribute<ArtDispensation, Boolean> isActive;
	public static volatile SingularAttribute<ArtDispensation, Facility> facility;
	public static volatile SingularAttribute<ArtDispensation, MasterModeOfDispensation> masterModeOfDispensation;
	public static volatile SingularAttribute<ArtDispensation, Boolean> isTransit;

	public static final String USER_MASTER = "userMaster";
	public static final String ART_DISPENSATION_ITEMS = "artDispensationItems";
	public static final String ART_BENEFICIARY_DUE_LIST = "artBeneficiaryDueList";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String DISPENSE_DATE = "dispenseDate";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String MASTER_MODE_OF_DISPENSATION = "masterModeOfDispensation";
	public static final String IS_TRANSIT = "isTransit";

}

