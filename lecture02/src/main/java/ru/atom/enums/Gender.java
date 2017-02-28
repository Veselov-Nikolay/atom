package ru.atom.enums;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by sergey on 2/28/17.
 */
public enum Gender {
    Male,
    Female,
    Other;

    public boolean isLegalCouple(Country country, Gender partner) {
        throw new NotImplementedException();
    }
}