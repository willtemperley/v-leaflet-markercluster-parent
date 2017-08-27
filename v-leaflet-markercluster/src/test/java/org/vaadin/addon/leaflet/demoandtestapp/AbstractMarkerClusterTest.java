package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.Component;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.shape.random.RandomPointsBuilder;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.demoandtestapp.util.AbstractTest;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterGroup;

/**
 * Provides a base map to play with
 *
 * Created by will on 20/12/15.
 */
public abstract class AbstractMarkerClusterTest extends AbstractTest {

    protected LMap leafletMap = new LMap();

    private class RandomMarkerFactory extends RandomPointsBuilder {

        private Envelope env;

        public RandomMarkerFactory(Envelope env) {
            this.env = env;
        }


        public LMarker getRandomMarker() {

            Coordinate c = createRandomCoord(env);
            GeometryFactory gf = new GeometryFactory();

            Point p = gf.createPoint(c);

            return new LMarker(p);
        }
    }

	@Override
	public Component getTestComponent() {


		Point p = new GeometryFactory().createPoint(new Coordinate(8.622, 45.819));

		leafletMap.setCenter(p);
		leafletMap.setZoomLevel(11);
		leafletMap.setMaxZoom(19);

        LTileLayer bl = new LTileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png");
        bl.setAttributionString("&copy; <a href='http://osm.org/copyright'>OpenStreetMap</a> contributors");

		bl.setMaxZoom(18);
		bl.setDetectRetina(true);
		leafletMap.addBaseLayer(bl, "Ispra");


		leafletMap.addComponent(getMarkerClusterGroup(p));

		return leafletMap;

	}


    public LMarkerClusterGroup getMarkerClusterGroup(Point p) {
        LMarkerClusterGroup mcg = new LMarkerClusterGroup();


        Envelope env = new Envelope();
        env.expandToInclude(p.getCoordinate());
        env.expandBy(0.5);

        RandomMarkerFactory rmf = new RandomMarkerFactory(env);
        for (int i = 0; i < 2000; i++) {
            mcg.addComponent(rmf.getRandomMarker());
        }
        return mcg;

    }

}
