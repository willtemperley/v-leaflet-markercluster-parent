package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.Component;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.demoandtestapp.util.AbstractTest;

/**
 * Provides a base map to play with
 *
 * Created by will on 20/12/15.
 */
public abstract class AbstractMarkerClusterTest extends AbstractTest {
	@Override
	public Component getTestComponent() {

		LMap leafletMap = new LMap();

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

	public abstract Component getMarkerClusterGroup(Point p);

}
