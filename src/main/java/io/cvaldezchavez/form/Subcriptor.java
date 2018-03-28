package io.cvaldezchavez.form;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "subcriptor")
public class Subcriptor implements Serializable {

	private static final long serialVersionUID = -4848780240095885296L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	@Column(name = "birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	@Year(1989)
	private Date birthday;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Subcriptor [name=" + name + ", email=" + email + ", age=" + age + ", phone=" + phone + ", gender="
		        + gender + ", birthday=" + birthday + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subcriptor other = (Subcriptor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
}
