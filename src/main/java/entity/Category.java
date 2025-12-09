package entity;/*
 *@title Category
 *@description
 *@author pika
 *@version 1.0
 *@create 2025/12/6 09:10
 */

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * @author pika
 * @date 2025/12/6
 * @description
 */
@Setter
@Getter
public class Category {
	private Integer id;
	private String categoryName;
	private LocalDateTime createTime;

	// MyBatis 要求无参 contractor
	public Category() {
	}
}
