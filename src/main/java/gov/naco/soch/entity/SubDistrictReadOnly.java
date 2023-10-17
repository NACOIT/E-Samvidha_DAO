package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * The persistent class for the subdistrict database table.
 * 
 */
@Entity(name="SubDistrictReadOnly")
@Table(name = "subdistrict")
@Immutable
public class SubDistrictReadOnly implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subdistrict_id")
    private Long subdistrictId;

    @Column(name = "subdistrict_name")
    private String subdistrictName;

    public SubDistrictReadOnly() {
    }

    public Long getSubdistrictId() {
	return this.subdistrictId;
    }

    public void setSubdistrictId(Long subdistrictId) {
	this.subdistrictId = subdistrictId;
    }

    public String getSubdistrictName() {
	return this.subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
	this.subdistrictName = subdistrictName;
    }

}