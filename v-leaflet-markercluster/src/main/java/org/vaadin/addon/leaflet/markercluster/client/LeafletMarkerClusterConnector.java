package org.vaadin.addon.leaflet.markercluster.client;

import org.peimari.gleaflet.client.LayerGroup;
import org.vaadin.addon.leaflet.client.LeafletFeatureGroupConnector;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterGroup;
import org.vaadin.gleaflet.markercluster.client.MarkerClusterGroup;

import com.vaadin.shared.ui.Connect;
import org.vaadin.gleaflet.markercluster.client.MarkerClusterGroupOptions;

@Connect(LMarkerClusterGroup.class)
public class LeafletMarkerClusterConnector extends LeafletFeatureGroupConnector {

    public LeafletMarkerClusterState getState() {
        return (LeafletMarkerClusterState) super.getState();
    }

	@Override
	protected LayerGroup createLayerGroup() {
        MarkerClusterGroupOptions o = createOptions();
		return MarkerClusterGroup.create(o);
	}

    protected MarkerClusterGroupOptions createOptions() {
        MarkerClusterGroupOptions o = MarkerClusterGroupOptions.create();
        LeafletMarkerClusterState s = getState();

        if (s.showCoverageOnHover != null) {
            o.setShowCoverageOnHover(s.showCoverageOnHover);
        }
        if (s.zoomToBoundsOnClick != null) {
            o.setZoomToBoundsOnClick(s.zoomToBoundsOnClick);
        }
        if (s.spiderfyOnMaxZoom != null) {
            o.setSpiderfyOnMaxZoom(s.spiderfyOnMaxZoom);
        }
        if (s.removeOutsideVisibleBounds != null) {
            o.setRemoveOutsideVisibleBounds(s.removeOutsideVisibleBounds);
        }
        if (s.animateAddingMarkers != null) {
            o.setAnimateAddingMarkers(s.animateAddingMarkers);
        }
        if (s.disableClusteringAtZoom != null) {
            o.setDisableClusteringAtZoom(s.disableClusteringAtZoom);
        }
        if (s.maxClusterRadius != null) {
            o.setMaxClusterRadius(s.maxClusterRadius);
        }
        if (s.singleMarkerMode != null) {
            o.setSingleMarkerMode(s.singleMarkerMode);
        }
        if (s.spiderfyDistanceMultiplier != null) {
            o.setSpiderfyDistanceMultiplier(s.spiderfyDistanceMultiplier);
        }
        if (s.iconCreateFunctionString != null) {
            o.setIconCreateFunction(s.iconCreateFunctionString);
        }

        return o;
    }

}
