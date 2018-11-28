package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		try {
			if (isValid_GPS_Point(gps)) {
				double xVal;
				double yVal;
				double zVal;
				double ER = 6321000;
				double lon_norm = Math.cos((gps.x() * Math.PI) / 180);

				double SinX = local_vector_in_meter.x() / ER;
				double diff_radX = Math.asin(SinX);
				double diff_X = (diff_radX * 180) / Math.PI;
				xVal = diff_X + gps.x();

				double SinY = (local_vector_in_meter.y() / ER) / lon_norm;
				double diff_radY = Math.asin(SinY);
				double diff_Y = (diff_radY * 180) / Math.PI;
				yVal = diff_Y + gps.y();

				zVal = gps.z() + local_vector_in_meter.z();

				Point3D temp = new Point3D(xVal, yVal, zVal);
				return temp;
			} else {
				throw new Exception("the GPS point is not a valid piont");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double dist = 0;
		try {
			if (isValid_GPS_Point(gps0) && isValid_GPS_Point(gps1)) {
				if (!gps0.equals(gps1)) {
					double ER = 6321000;
					double lon_norm = Math.cos((gps0.x() * Math.PI) / 180);

					double diffX = gps1.x() - gps0.x();
					double diffRadX = (diffX * Math.PI) / 180;
					double distMX = Math.sin(diffRadX) * ER;

					double diffY = gps1.y() - gps0.y();
					double diffRadY = (diffY * Math.PI) / 180;
					double distMY = Math.sin(diffRadY) * ER * lon_norm;

					double distMZ = gps1.z() - gps0.z();

					double distCalc = distMX * distMX + distMY * distMY + distMZ * distMZ;
					dist = Math.sqrt(distCalc);

				}
			} else {
				throw new Exception("one of the GPS points is not valid");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return dist;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		try {

			if (isValid_GPS_Point(gps0) && isValid_GPS_Point(gps1)) {
				double ER = 6321000;
				double lon_norm = Math.cos((gps0.x() * Math.PI) / 180);

				double diffX = gps1.x() - gps0.x();
				double diffRadX = (diffX * Math.PI) / 180;
				double distMX = Math.sin(diffRadX) * ER;

				double diffY = gps1.y() - gps0.y();
				double diffRadY = (diffY * Math.PI) / 180;
				double distMY = Math.sin(diffRadY) * ER * lon_norm;

				double distMZ = gps1.z() - gps0.z();

				Point3D vector = new Point3D(distMX, distMY, distMZ);
				return vector;
			} else {
				throw new Exception("one of the GPS point is not valid");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double[] AED = new double[3];

		try {
			if (isValid_GPS_Point(gps0) && isValid_GPS_Point(gps1)) {
				AED[2] = distance3d(gps0, gps1);

				double distMZ = Math.abs(gps1.z() - gps0.z());
				double eleCalc = distMZ / AED[2];

				if (gps0.z() > gps1.z()) {
					AED[1] = -Math.asin(eleCalc);
				} else if (gps0.z() < gps0.z()) {
					AED[1] = Math.asin(eleCalc);
				} else {
					AED[1] = 0;
				}

				double gps0XRad = Math.toRadians(gps0.x());
				double gps0YRad = Math.toRadians(gps0.y());

				double gps1XRad = Math.toRadians(gps1.x());
				double gps1YRad = Math.toRadians(gps1.y());

				double disY = gps1YRad - gps0YRad;

				double dphi = Math.log(Math.tan(gps1XRad / 2 + Math.PI / 4) / Math.tan(gps0XRad / 2 + Math.PI / 4));

				if (Math.abs(disY) > Math.PI) {
					if (disY > 0) {
						disY = -(2 * Math.PI - disY);
					} else {
						disY = (2 * Math.PI + disY);
					}
				}

				double Azi = (Math.toDegrees((Math.atan2(disY, dphi))) + 360) % 360;

				AED[0] = Azi;
				System.out.println(AED[0]);
				return AED;
			} else {
				throw new Exception("one of the GPS point is not vaild");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return AED;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if (p.x() < -180 || p.x() > 180) {
			return false;
		}

		if (p.y() < -90 || p.y() > 90) {
			return false;

		}

		if (p.z() < -450) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

	}
}
