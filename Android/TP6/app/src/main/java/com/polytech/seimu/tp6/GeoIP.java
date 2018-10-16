package com.polytech.seimu.tp6;

public class GeoIP {
    Integer ReturnCode;
    String IP;
    String ReturnCodeDetails;
    String CountryName;
    String CountryCode;
    String Organization;

    public GeoIP(Integer returnCode, String IP, String returnCodeDetails, String countryName, String countryCode, String organisation) {
        ReturnCode = returnCode;
        this.IP = IP;
        ReturnCodeDetails = returnCodeDetails;
        CountryName = countryName;
        CountryCode = countryCode;
        Organization = organisation;
    }

    @Override
    public String toString() {
        return  "IP = " + IP + '\n' +
                "CountryName = " + CountryName + '\n' +
                "CountryCode = " + CountryCode + '\n' +
                "Organization = " + Organization + '\n' +
                '\n' +
                "ReturnCode = " + ReturnCode + '\n' +
                "ReturnCodeDetails = " + ReturnCodeDetails;
    }
}
