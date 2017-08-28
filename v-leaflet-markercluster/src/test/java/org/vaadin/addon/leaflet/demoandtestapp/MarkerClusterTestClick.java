package org.vaadin.addon.leaflet.demoandtestapp;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonValue;
import org.vaadin.addon.leaflet.LPolygon;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterClickEvent;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterGroup;
import org.vaadin.addon.leaflet.markercluster.MarkerClusterClickListener;

public class MarkerClusterTestClick extends AbstractMarkerClusterTest {

	@Override
	public String getDescription() {
		return "MarkerCluster click sends serialized markers to server";
	}

    @Override
    public LMarkerClusterGroup getMarkerClusterGroup(Point p) {


        LMarkerClusterGroup mcg = super.getMarkerClusterGroup(p);
        mcg.addMarkerClusterClickListener(new MarkerClusterClickListener() {

            @Override
            public void onClusterClick(LMarkerClusterClickEvent markerClusterClickEvent) {


                JsonObject parse = Json.parse(markerClusterClickEvent.getJson());


                JsonArray features = parse.getArray("features");
                Coordinate[] coordinates = new Coordinate[features.length() + 1];
                for (int i = 0; i < features.length(); i++) {

                    JsonObject object = features.getObject(i);
                    JsonArray array = object.getObject("geometry").getArray("coordinates");

                    JsonValue jsonValue = array.get(0);
                    double x = jsonValue.asNumber();
                    JsonValue jsonValue2 = array.get(1);
                    double y = jsonValue2.asNumber();
                    coordinates[i] = new Coordinate(x, y);

                }
                coordinates[coordinates.length - 1] = coordinates[0];

                Polygon lineString = new GeometryFactory().createPolygon(coordinates);


                LPolygon lPolygon = new LPolygon(lineString);
                lPolygon.setFill(true);
                lPolygon.setFillColor("#00FF00");

                leafletMap.addLayer(lPolygon);

            }

        });
        return mcg;
    }
}