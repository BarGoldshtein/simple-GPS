package GIS;

import Geom.Point3D;

public class MetaData implements Meta_data {

	String MAC;
	String SSID;
	String AuthMode;
	long FirstSeen;
	int Channel;
	int RSSI;
	int AccuracyMeters;
	String Type;

	public MetaData(String MAC, String SSID, String AuthMode, String FirstSeen, String Channel, String RSSI,
			String AccuracyMeters, String Type) {

		this.MAC = MAC;
		this.SSID = SSID;
		this.AuthMode = AuthMode;
		this.Channel = Integer.parseInt(Channel);
		this.RSSI = Integer.parseInt(RSSI);
		this.AccuracyMeters = Integer.parseInt(AccuracyMeters);
		this.Type = Type;

		long seenToLong;
		String longOnlyNum = "";
		for (int i = 0; i < FirstSeen.length(); i++) {
			if (FirstSeen.charAt(i) != "/".charAt(0) && FirstSeen.charAt(i) != ":".charAt(0)
					&& FirstSeen.charAt(i) != " ".charAt(0)) {
				longOnlyNum += FirstSeen.charAt(i);
			}
		}
		seenToLong=Long.parseLong(longOnlyNum);
		this.FirstSeen=seenToLong;
	}

	@Override
	public long getUTC() {
		return FirstSeen;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		String str = ("MAC: " + MAC + "SSID: " + SSID + "AuthMode: " + AuthMode + "FirstSeen: " + FirstSeen
				+ "Channel: " + Channel + "RSSI: " + RSSI + "AccuracyMeters: " + AccuracyMeters + "Type: " + Type);
		return str;
	}

	public String getMAC() {
		return MAC;
	}

	public String getSSID() {
		return SSID;
	}

	public String getAuthMode() {
		return AuthMode;
	}

	public long getFirstSeen() {
		return FirstSeen;
	}

	public int getChannel() {
		return Channel;
	}

	public int getRSSI() {
		return RSSI;
	}

	public int getAccuracyMeters() {
		return AccuracyMeters;
	}

	public String getType() {
		return Type;
	}
}
