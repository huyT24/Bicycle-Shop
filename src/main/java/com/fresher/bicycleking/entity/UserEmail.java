package com.fresher.bicycleking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_email")
public class UserEmail {
	@Id
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "email_account", nullable = true, unique = true)
	private String emailAccount;

	@Column(name = "email_client_id", unique = true)
	private String emailClientId;

	@Column(name = "email_client_secret", unique = true)
	private String emailClientSecret;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
}
