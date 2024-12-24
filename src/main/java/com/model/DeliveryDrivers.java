package com.model;

<<<<<<< HEAD
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



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


=======
import jakarta.persistence.*;

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
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
