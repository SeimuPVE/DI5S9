package com.polytech.seimu.tp6;

public class GeoIPParser {
    public static final String get(String code, String value) {
        int i;
        String code_tab[] = code.split("<");

        i = 0;

        while(!code_tab[i].startsWith(value))
            i++;

        return code_tab[i + 1].replace("![CDATA[", "").replace("]]>", "");
    }
}
