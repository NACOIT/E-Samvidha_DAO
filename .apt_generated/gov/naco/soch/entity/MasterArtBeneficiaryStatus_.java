package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterArtBeneficiaryStatus.class)
public abstract class MasterArtBeneficiaryStatus_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterArtBeneficiaryStatus, String> code;
	public static volatile SingularAttribute<MasterArtBeneficiaryStatus, Boolean> isDelete;
	public static volatile SetAttribute<MasterArtBeneficiaryStatus, ArtBeneficiary> artBeneficiaries;
	public static volatile SingularAttribute<MasterArtBeneficiaryStatus, String> name;
	public static volatile SingularAttribute<MasterArtBeneficiaryStatus, String> description;
	public static volatile SingularAttribute<MasterArtBeneficiaryStatus, Long> id;
	public static volatile SingularAttribute<MasterArtBeneficiaryStatus, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String ART_BENEFICIARIES = "artBeneficiaries";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

