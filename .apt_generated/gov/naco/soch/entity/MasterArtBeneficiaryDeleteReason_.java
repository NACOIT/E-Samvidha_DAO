package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterArtBeneficiaryDeleteReason.class)
public abstract class MasterArtBeneficiaryDeleteReason_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterArtBeneficiaryDeleteReason, String> code;
	public static volatile SingularAttribute<MasterArtBeneficiaryDeleteReason, Boolean> isDelete;
	public static volatile SetAttribute<MasterArtBeneficiaryDeleteReason, ArtBeneficiary> artBeneficiaries;
	public static volatile SingularAttribute<MasterArtBeneficiaryDeleteReason, String> name;
	public static volatile SingularAttribute<MasterArtBeneficiaryDeleteReason, String> description;
	public static volatile SingularAttribute<MasterArtBeneficiaryDeleteReason, Long> id;
	public static volatile SingularAttribute<MasterArtBeneficiaryDeleteReason, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String ART_BENEFICIARIES = "artBeneficiaries";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

