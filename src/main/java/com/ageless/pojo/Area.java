package com.ageless.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ʒ
 * 
 * @author JW
 * 
 */
@Data
public class Area implements Serializable {

	private Integer areaId; // Id
	private String areaName;// ����
	private Integer prioity;// Ȩ��
	private Date createTime;// ����ʱ��
	private Date lastEditTime; // ����ʱ��




}
