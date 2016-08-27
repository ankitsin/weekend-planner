package com.practo.wp.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the destination database table.
 * 
 */
@Entity
@Table(name="destination")
@NamedQuery(name="DestinationEntity.findAll", query="SELECT d FROM DestinationEntity d")
public class DestinationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="destination_id")
	private int destinationId;

	private int distance;

	private String location;

	private String type;

	//bi-directional many-to-one association to TripEntity
	@OneToMany(mappedBy="destination")
	private List<TripEntity> trips;

	public DestinationEntity() {
	}

	public int getDestinationId() {
		return this.destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TripEntity> getTrips() {
		return this.trips;
	}

	public void setTrips(List<TripEntity> trips) {
		this.trips = trips;
	}

	public TripEntity addTrip(TripEntity trip) {
		getTrips().add(trip);
		trip.setDestination(this);

		return trip;
	}

	public TripEntity removeTrip(TripEntity trip) {
		getTrips().remove(trip);
		trip.setDestination(null);

		return trip;
	}

}