package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MenuMaster.class)
public abstract class MenuMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MenuMaster, Boolean> isDelete;
	public static volatile SingularAttribute<MenuMaster, String> routeLink;
	public static volatile SingularAttribute<MenuMaster, String> menuName;
	public static volatile SingularAttribute<MenuMaster, Long> id;
	public static volatile SingularAttribute<MenuMaster, Integer> position;
	public static volatile SingularAttribute<MenuMaster, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String ROUTE_LINK = "routeLink";
	public static final String MENU_NAME = "menuName";
	public static final String ID = "id";
	public static final String POSITION = "position";
	public static final String IS_ACTIVE = "isActive";

}

