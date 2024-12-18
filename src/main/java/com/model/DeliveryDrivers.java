package com.model;

import jakarta.persistence.Entity;

	
	import java.util.List;


	import jakarta.persistence.CascadeType;
	
	import jakarta.persistence.OneToMany;

	@Entity
	public class DeliveryDrivers {
		private int driverid;
		private String drivername;
		private String driverphone;
		private String drivervehicle;
		private String driverLocation;
		
		@Override
		public String toString() {
			return "DeliveryDrivers [driver_id=" + driverid + ", driver_name=" + drivername + ", driver_phone="
					+ driverphone + ", driver_vehicle=" + drivervehicle + ", driverLocation=" + driverLocation
					+ ", orders=" + orders + "]";
		}

		public DeliveryDrivers(int driverid, String drivername, String driverphone, String drivervehicle,
				String driverLocation, List<Orders> orders) {
			super();
			this.driverid = driverid;
			this.drivername = drivername;
			this.driverphone = driverphone;
			this.drivervehicle = drivervehicle;
			this.driverLocation = driverLocation;
			this.orders = orders;
		}

		public String getDriverLocation() {
			return driverLocation;
		}

		public void setDriverLocation(String driverLocation) {
			this.driverLocation = driverLocation;
		}

		@OneToMany(mappedBy="deliveryDrivers",cascade=CascadeType.ALL)
		List<Orders> orders;
		
		public DeliveryDrivers() {}

		public int getDriver_id() {
			return driverid;
		}

		public void setDriver_id(int driver_id) {
			this.driverid = driver_id;
		}

		public String getDriver_name() {
			return drivername;
		}

		public void setDriver_name(String driver_name) {
			this.drivername = driver_name;
		}

		public String getDriver_phone() {
			return driverphone;
		}

		public void setDriver_phone(String driver_phone) {
			this.driverphone = driver_phone;
		}

		public String getDriver_vehicle() {
			return drivervehicle;
		}

		
		public void setDriver_vehicle(String driver_vehicle) {
			this.drivervehicle = driver_vehicle;
		}

		public List<Orders> getOrders() {
			return orders;
		}

		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}

		
		
		
	}


