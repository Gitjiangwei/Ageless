package com.ageless.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ����
 * 
 * @author JW
 * 
 */
@Data
public class Shop {

	private Long shopId; // id
	private Long ownerId;// ��˭����
	private Long shopCategoryId; // �������id
	private String shopName; // ��������
	private String shopDesc;// ��������
	private String shopAddr;// ���̵�ַ
	private String phone;// ��ϵ��ʽ
	private String shopImg;// ��������ͼ
	private Double longitude;
	private Double latitude;
	private Integer priority;// ����Ȩ��
	private Date createTime;// ����ʱ��
	private Date lastEditTime;// ����ʱ��
	private Integer enableStatus;// ����״̬ -1�������ã�0������У�1������ʹ��
	private String advice;// ��������Ա���������



}
