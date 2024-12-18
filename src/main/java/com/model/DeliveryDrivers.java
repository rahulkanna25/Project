package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
	
	import jakarta.persistence.OneToMany;

	@Entity
	public class DeliveryDrivers {
		@Id
		@GeneratedValue
		private int driverid;
		private String driverName;
		private String driverPhone;
		private String driverVehicle;
		private String driverLocation;
		
		@Override
		public String toString() {
			return "DeliveryDrivers [driver_id=" + driverid + ", driver_name=" + driverName + ", driver_phone="
					+ driverPhone + ", driver_vehicle=" + driverVehicle + ", driverLocation=" + driverLocation
					+ ", orders=" +  "]";
		}

		public DeliveryDrivers(int driverid, String drivername, String driverphone, String drivervehicle,
				String driverLocation) {
			super();
			this.driverid = driverid;
			this.driverName = drivername;
			this.driverPhone = driverphone;
			this.driverVehicle = drivervehicle;
			this.driverLocation = driverLocation;
			
		}

		public String getDriverLocation() {
			return driverLocation;
		}

		public void setDriverLocation(String driverLocation) {
			this.driverLocation = driverLocation;
		}

		
		
		public DeliveryDrivers() {}

		public int getDriver_id() {
			return driverid;
		}

		public void setDriver_id(int driver_id) {
			this.driverid = driver_id;
		}

		public String getDriver_name() {
			return driverName;
		}

		public void setDriver_name(String driver_name) {
			this.driverName = driver_name;
		}

		public String getDriver_phone() {
			return driverPhone;
		}

		public void setDriver_phone(String driver_phone) {
			this.driverPhone = driver_phone;
		}

		public String getDriver_vehicle() {
			return driverVehicle;
		}

		
		public void setDriver_vehicle(String driver_vehicle) {
			this.driverVehicle = driver_vehicle;
		}

		

		
		
		
	}


