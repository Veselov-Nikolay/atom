package ru.atom.geometry;

public interface Collider {
    default boolean isColliding(Collider other) {
        return false;
    }
}