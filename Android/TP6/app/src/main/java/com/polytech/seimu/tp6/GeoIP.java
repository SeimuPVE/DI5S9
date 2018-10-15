package com.polytech.seimu.tp6;

public class GeoIP {
    Integer ReturnCode;
    String IP;
    String ReturnCodeDetails;
    String CountryName;
    String CountryCode;

    public GeoIP(Integer returnCode, String IP, String returnCodeDetails, String countryName, String countryCode) {
        ReturnCode = returnCode;
        this.IP = IP;
        ReturnCodeDetails = returnCodeDetails;
        CountryName = countryName;
        CountryCode = countryCode;
    }

    @Override
    public String toString() {
        return "GeoIP {" + '\n' +
                "ReturnCode = " + ReturnCode + '\n' +
                ", IP = '" + IP + '\'' + '\n' +
                ", ReturnCodeDetails = '" + ReturnCodeDetails + '\'' + '\n' +
                ", CountryName = '" + CountryName + '\'' + '\n' +
                ", CountryCode = '" + CountryCode + '\'' + '\n' +
                '}';
    }
}
