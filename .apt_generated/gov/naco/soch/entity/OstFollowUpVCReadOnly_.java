package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstFollowUpVCReadOnly.class)
public abstract class OstFollowUpVCReadOnly_ {

	public static volatile SingularAttribute<OstFollowUpVCReadOnly, LocalDate> followUpDate;
	public static volatile SingularAttribute<OstFollowUpVCReadOnly, OstBenSubEntityVCReadOnly> tiOstBeneficiary;
	public static volatile SingularAttribute<OstFollowUpVCReadOnly, LocalDate> nextFollowupDate;
	public static volatile SingularAttribute<OstFollowUpVCReadOnly, Long> id;

	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String NEXT_FOLLOWUP_DATE = "nextFollowupDate";
	public static final String ID = "id";

}

