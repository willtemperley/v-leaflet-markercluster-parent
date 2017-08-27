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

    @Override
    public LMarkerClusterGroup getMarkerClusterGroup(Point p) {
		/*
		This is not a great way to do this ... the function is injected, using eval()

		FIXME disallow this and allow a custom script to be evaluated.
		 */
        LMarkerClusterGroup mcg = super.getMarkerClusterGroup(p);
        mcg.setIconCreateFunctionString("(function(cluster) {return L.divIcon({ html: '<b>' + cluster.getChildCount() + '</b>' });})");
        return mcg;
    }
}