package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class UserRequest implements Serializable {
	
	@NotNull(message ="JANコードを入力してください")
	@Min(value =20, message ="20文字以内で入力してください")
	private Long jan;
	
	@NotEmpty(message ="メーカー名を入力してください")
	@Size(max = 100,message ="100文字以内で入力してください")
	private String manufacturer;
	
	@NotEmpty(message ="商品名を入力してください")
	@Size(max = 100,message ="100文字以内で入力してください")
	private String name;
	
	@NotNull(message ="賞味期間を入力してください")
	@Min(value =20, message ="20文字以内で入力してください")
	private Long expiration;
	
	
	
	
}
