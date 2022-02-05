package getphos.spring.spring_boot_web.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Setter
@Getter
public class Singer implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@Version
	private int version;

	@NotBlank(message="{validation.firstname.NotBlank.message}")
	@Size(min=2, max=60, message="{validation.firstname.Size.message}")
	private String firstName;

	@NotBlank(message="{validation.lastname.NotBlank.message}")
	@Size(min=1, max=40, message="{validation.lastname.Size.message}")
	private String lastName;

	@NotNull(message="{validation.birthDate.NotBlank.message}")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private String description;

	@Basic(fetch= FetchType.LAZY)
	@Lob
	private byte[] photo;

	@Override
	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate
				+ ", Description: " + description;
	}
}
