package com.petclinic.entity.postgres;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.petclinic.entity.NamedEntity;

@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {

}
