package org.vaadin.addon.leaflet.demoandtestapp;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.shape.random.RandomPointsBuilder;
import org.vaadin.addon.leaflet.LMarker;
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


    @Override
    public LMarkerClusterGroup getMarkerClusterGroup(Point p) {
		/*
		This is really horrible ... the function is injected, using eval()
        I can't see another way to do this.
        There is no way to pass a java function to a Vaadin widget.
		 */
        LMarkerClusterGroup mcg = super.getMarkerClusterGroup(p);
        mcg.setIconCreateFunctionString("(function(cluster) {return L.divIcon({ html: '<b>' + cluster.getChildCount() + '</b>' });})");
        return mcg;
    }
}