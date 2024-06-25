package com.fresher.bicycleking.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fresher.bicycleking.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_name", nullable = true, unique = true)
	private String username;

	@Column(name = "user_password", nullable = true)
	private String password;
	
	@Column(name = "user_full_name", nullable = true)
	private String fullname;

	@Column(name = "user_birthday", nullable = true)
	private Date birthday;

	@Column(name = "user_gender", nullable = true)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "profile_pictrue", nullable = true)
	private String profilePicture;

	@Column(name = "user_address", nullable = true)
	private String address;

	@Column(name = "user_phone_number", nullable = true)
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Role> roles;
	
	@OneToOne(mappedBy = "user", cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	@PrimaryKeyJoinColumn
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private UserEmail userEmail;

	@OneToOne(mappedBy = "user", cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	@PrimaryKeyJoinColumn
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private UserFacebook userFacebook;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.MERGE })
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Order> orders;
}
