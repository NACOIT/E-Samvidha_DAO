package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenScrDetailsViewCardReadOnly.class)
public abstract class TIBenScrDetailsViewCardReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, ZonedDateTime> dateOfScreening;
	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, MasterSyphilisStatus> screeningStatusSyphilis;
	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, TiBeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, MasterHivScreeningStatus> screeningStatusHiv;
	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, Long> id;
	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, MasterTbScreeningStatus> tbStatus;
	public static volatile SingularAttribute<TIBenScrDetailsViewCardReadOnly, LocalDate> nextDateOfScreening;

	public static final String DATE_OF_SCREENING = "dateOfScreening";
	public static final String SCREENING_STATUS_SYPHILIS = "screeningStatusSyphilis";
	public static final String BENEFICIARY = "beneficiary";
	public static final String SCREENING_STATUS_HIV = "screeningStatusHiv";
	public static final String ID = "id";
	public static final String TB_STATUS = "tbStatus";
	public static final String NEXT_DATE_OF_SCREENING = "nextDateOfScreening";

}

