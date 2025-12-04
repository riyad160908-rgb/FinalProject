package org.riyad;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;






    public enum Province {
        QC,
        ON,
        SK,
        NS,
        NB,
        BC,
        AB,
        MB,
        PE,
        NL,
    }
}
