package ru.atom.enums;

/**
 * Created by sergey on 2/28/17.
 */
public enum Gender {
    Male,
    Female,
    Other;

    public boolean isLegalCouple(Country country, Gender partner) {
        switch (country) {
            case Russia:
                return this != partner
                        && this != Other
                        && partner != Other;
            case Netherlands:
            case USA:
                return true;
            default:
                return false;
        }
    }
}