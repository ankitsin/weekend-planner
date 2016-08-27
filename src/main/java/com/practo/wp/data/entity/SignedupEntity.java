package com.practo.wp.data.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the signedup database table.
 * 
 */
@Entity
@Table(name="signedup")
@NamedQuery(name="SignedupEntity.findAll", query="SELECT s FROM SignedupEntity s")
public class SignedupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to TripEntity
	@ManyToOne
	@JoinColumn(name="signed_trip")
	private TripEntity trip;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JoinColumn(name="signup_user")
	private UserEntity user;

	public SignedupEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TripEntity getTrip() {
		return this.trip;
	}

	public void setTrip(TripEntity trip) {
		this.trip = trip;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}