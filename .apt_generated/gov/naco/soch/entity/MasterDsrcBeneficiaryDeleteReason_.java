package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterDsrcBeneficiaryDeleteReason.class)
public abstract class MasterDsrcBeneficiaryDeleteReason_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterDsrcBeneficiaryDeleteReason, String> code;
	public static volatile SingularAttribute<MasterDsrcBeneficiaryDeleteReason, Boolean> isDelete;
	public static volatile SingularAttribute<MasterDsrcBeneficiaryDeleteReason, String> name;
	public static volatile SingularAttribute<MasterDsrcBeneficiaryDeleteReason, String> description;
	public static volatile SingularAttribute<MasterDsrcBeneficiaryDeleteReason, Long> id;
	public static volatile SingularAttribute<MasterDsrcBeneficiaryDeleteReason, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

