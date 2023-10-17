package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Regimen.class)
public abstract class Regimen_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Regimen, ArtDispensationItem> artDispensationItems;
	public static volatile SingularAttribute<Regimen, MasterData> masterData1;
	public static volatile SetAttribute<Regimen, RegimenConstituent> regimenConstituents;
	public static volatile SingularAttribute<Regimen, MasterData> masterData2;
	public static volatile SingularAttribute<Regimen, String> regimenName;
	public static volatile SingularAttribute<Regimen, Boolean> isDelete;
	public static volatile SingularAttribute<Regimen, Long> id;
	public static volatile SetAttribute<Regimen, ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;
	public static volatile SingularAttribute<Regimen, Boolean> isActive;
	public static volatile SetAttribute<Regimen, DispensationItem> dispensationItems;

	public static final String ART_DISPENSATION_ITEMS = "artDispensationItems";
	public static final String MASTER_DATA1 = "masterData1";
	public static final String REGIMEN_CONSTITUENTS = "regimenConstituents";
	public static final String MASTER_DATA2 = "masterData2";
	public static final String REGIMEN_NAME = "regimenName";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String ART_BENEFICIARY_CLINICAL_DETAILS = "artBeneficiaryClinicalDetails";
	public static final String IS_ACTIVE = "isActive";
	public static final String DISPENSATION_ITEMS = "dispensationItems";

}

