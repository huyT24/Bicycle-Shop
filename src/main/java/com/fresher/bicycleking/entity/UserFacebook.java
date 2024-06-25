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
@Setter
@Getter
@Entity
@Table(name = "user_facebook")
public class UserFacebook {
	@Id
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "facebook_client_id")
	private String facebookClientId;
	
	@Column(name = "facebook_client_secret")
	private String facebookClientSecret;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
}
