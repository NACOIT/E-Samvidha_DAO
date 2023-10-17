package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstPrescriptionVCReadOnly.class)
public abstract class OstPrescriptionVCReadOnly_ {

	public static volatile SingularAttribute<OstPrescriptionVCReadOnly, MasterDrug> product;
	public static volatile SingularAttribute<OstPrescriptionVCReadOnly, Double> dosageQty;
	public static volatile SingularAttribute<OstPrescriptionVCReadOnly, OstBenSubEntityVCReadOnly> tiOstBeneficiary;
	public static volatile SingularAttribute<OstPrescriptionVCReadOnly, LocalDate> ostPrescriptionDate;
	public static volatile SingularAttribute<OstPrescriptionVCReadOnly, Long> id;

	public static final String PRODUCT = "product";
	public static final String DOSAGE_QTY = "dosageQty";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String OST_PRESCRIPTION_DATE = "ostPrescriptionDate";
	public static final String ID = "id";

}

