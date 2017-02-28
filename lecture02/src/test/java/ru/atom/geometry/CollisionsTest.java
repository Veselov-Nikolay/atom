package ru.atom.geometry;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollisionsTest {
    @Test
    public void pointsSelfMatch() {
        Collider point = Geometry.createPoint(100, 100);
        assertThat(point.isColliding(point), is(true));
    }

    @Test
    public void pointsMatch() {
        Collider point1 = Geometry.createPoint(100, 100);
        Collider point2 = Geometry.createPoint(100, 100);
        assertThat(point1.isColliding(point2), is(true));
    }

    @Test
    public void pointsNotMatch1() {
        Collider point1 = Geometry.createPoint(200, 100);
        Collider point2 = Geometry.createPoint(100, 100);
        assertThat(point1.isColliding(point2), is(false));
    }

    @Test
    public void pointsNotMatch2() {
        Collider point1 = Geometry.createPoint(100, 100);
        Collider point2 = Geometry.createPoint(200, 100);
        assertThat(point1.isColliding(point2), is(false));
    }

    @Test
    public void pointInsideBar() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(50, 50);
        assertThat(bar.isColliding(point), is(true));
    }

    @Test
    public void pointOnBorderOfCorner() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(0, 0);
        assertThat(bar.isColliding(point), is(true));
    }

    @Test
    public void pointOnBorderOfBar() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(0, 50);
        assertThat(bar.isColliding(point), is(true));
    }

    @Test
    public void pointOutsideOfBar() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        Collider point = Geometry.createPoint(150, 150);
        assertThat(bar.isColliding(point), is(false));
    }

    @Test
    public void barMatchesSelf() {
        Collider bar = Geometry.createBar(0, 0, 100, 100);
        assertThat(bar.isColliding(bar), is(true));
    }

    @Test
    public void barMatchesBar() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(0, 0, 100, 100);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barIntersectsBar1() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(50, 0, 150, 100);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barIntersectsBar2() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(0, 50, 100, 150);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barIntersectsBar3() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(50, 50, 150, 150);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barIntersectsBarByBorder() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(0, 100, 10, 200);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barIntersectsBarByCorder() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(100, 100, 200, 200);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barIncludesBar() {
        Collider bar1 = Geometry.createBar(0, 0, 200, 200);
        Collider bar2 = Geometry.createBar(50, 50, 150, 150);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barDoesNotIntersectsBar1() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(150, 0, 200, 100);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barDoesNotIntersectsBar2() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(0, 50, 100, 150);
        assertThat(bar1.isColliding(bar2), is(true));
    }

    @Test
    public void barDoesNotIntersectBar3() {
        Collider bar1 = Geometry.createBar(0, 0, 100, 100);
        Collider bar2 = Geometry.createBar(150, 150, 200, 200);
        assertThat(bar1.isColliding(bar2), is(true));
    }
}
