package io.cvaldezchavez.form;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import io.cvaldezchavez.validator.Phone;
import io.cvaldezchavez.validator.Year;


@Entity
@Table(name = "subcriber")
public class Subcritor implements Serializable {

	private static final long serialVersionUID = -4848780240095885296L;

	@Column(name = "id")
	@Id
	private Integer id;
	
	@Column(name = "name")
	@Size(min = 2, max = 30)
	private String name;
	
	@Column(name = "email")
	@Email
	@NotEmpty
	private String email;
	
	@Column(name = "age")
	@Max(110)
	@Min(13)
	@NotNull
	private Integer age;
	
	@Column(name = "phone")
	@Phone
	@Size(min = 10)
	private String phone;
	
	@Column(name = "gender")
	@NotNull
	private Gender gender;
	
	@Column(name = "birtday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	@Year(1989)
	private Date birtday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirtday() {
		return birtday;
	}

	public void setBirtday(Date birtday) {
		this.birtday = birtday;
	}

	@Override
	public String toString() {
		return "Subcritor [name=" + name + ", email=" + email + ", age=" + age + ", phone=" + phone + ", gender="
		        + gender + ", birtday=" + birtday + "]";
	}
	
	
	
}
