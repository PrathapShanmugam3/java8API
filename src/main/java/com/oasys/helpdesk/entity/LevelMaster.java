package com.oasys.helpdesk.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oasys.helpdesk.conf.Trackable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@JsonIgnoreProperties({ "hibernatelazyinitializer", "handler" })
@EqualsAndHashCode(callSuper=false)
@Table(name = "level_master")
public class LevelMaster  extends Trackable {

	private static final long serialVersionUID = -1876912232063693652L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

}