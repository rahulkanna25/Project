package com.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity
;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deliverydrivers")
public class DeliveryDrivers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_id")
    private int driverId;

    @Column(name = "driver_name", nullable = false)
    private String driverName;

    @Column(name = "driver_phone", length = 20)
    private String driverPhone;

    @Column(name = "driver_vehicle")
    private String driverVehicle;
    
    @Column(name ="driver_location")
    private String driverLocation;

    public String getDriverLocation() {
		return driverLocation;
	}

	public DeliveryDrivers() {}

    public DeliveryDrivers(int driverId, String driverName, String driverPhone, String driverVehicle) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.driverVehicle = driverVehicle;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) { // Fixing parameter type
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(String driverVehicle) {
        this.driverVehicle = driverVehicle;
    }

	public void setDriverLocation(String driverLocation) {
		// TODO Auto-generated method stub
		
	}
}
