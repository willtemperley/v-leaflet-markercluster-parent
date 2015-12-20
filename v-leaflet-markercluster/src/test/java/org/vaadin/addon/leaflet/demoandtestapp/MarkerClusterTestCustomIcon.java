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

public class MarkerClusterTestCustomIcon extends AbstractMarkerClusterTest {

	@Override
	public String getDescription() {
		return "MarkerCluster test case with custom icon";
	}

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

	private LMap leafletMap;

	public LMarkerClusterGroup getMarkerClusterGroup(Point p) {
		LMarkerClusterGroup mcg = new LMarkerClusterGroup();

		/*
		This is really horrible. The JS function is injected, using eval() in the GWT code
        I can't see another way to do this.
        There is no way to pass a java function to a Vaadin widget as initial state AFAIK
        Using Vaadin RPC, even if possible, would generate loads of traffic, as the clusters are built client-side0
		 */
        mcg.setIconCreateFunctionString("(function(cluster) {return L.divIcon({ html: '<b>' + cluster.getChildCount() + '</b>' });})");

		Envelope env = new Envelope();
		env.expandToInclude(p.getCoordinate());
		env.expandBy(0.5);

		RandomMarkerFactory rmf = new RandomMarkerFactory(env);
		for (int i = 0; i < 2000; i++) {
			mcg.addComponent(rmf.getRandomMarker());	
		}
		return mcg;

	}

	@Override
	protected void setup() {
		super.setup();


	}
}