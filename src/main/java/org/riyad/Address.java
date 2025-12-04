package org.riyad;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public static boolean isPostalCodeValid(String postalCode) {
        if(postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for(int i = 0; i < postalCode.length(); i++) {
            char c = postalCode.charAt(i);

            if(i % 2 == 0 && !Character.isLetter(c)) {
                return false;
            }
            if(i % 2 == 1 && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public Address(Integer streetNo, String street, Province province, String city, String postalCode) {
        if(isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.province = province;
            this.city = city;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.province = null;
            this.city = null;
            this.postalCode = null;
        }
    }

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
