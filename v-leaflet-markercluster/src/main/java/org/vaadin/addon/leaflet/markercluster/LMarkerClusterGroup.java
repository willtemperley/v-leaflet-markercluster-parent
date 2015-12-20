package org.vaadin.addon.leaflet.markercluster;

import org.vaadin.addon.leaflet.LFeatureGroup;

import org.vaadin.addon.leaflet.markercluster.client.LeafletMarkerClusterState;

/**
 * 
 */
public class LMarkerClusterGroup extends LFeatureGroup {

    protected LeafletMarkerClusterState getState() {
        return (LeafletMarkerClusterState) super.getState();
    }

    public void setShowCoverageOnHover(Boolean showCoverageOnHover) {
        getState().showCoverageOnHover = showCoverageOnHover;
    }

    public void setZoomToBoundsOnClick(Boolean zoomToBoundsOnClick) {
        getState().zoomToBoundsOnClick = zoomToBoundsOnClick;
    }

    public void setSpiderfyOnMaxZoom(Boolean spiderfyOnMaxZoom) {
        getState().spiderfyOnMaxZoom = spiderfyOnMaxZoom;
    }

    public void setRemoveOutsideVisibleBounds(Boolean removeOutsideVisibleBounds) {
        getState().removeOutsideVisibleBounds = removeOutsideVisibleBounds;
    }

    public void setAnimateAddingMarkers(Boolean animateAddingMarkers) {
        getState().animateAddingMarkers = animateAddingMarkers;
    }

    public void setDisableClusteringAtZoom(Integer zoomLevel) {
        getState().disableClusteringAtZoom = zoomLevel;
    }

    public void setMaxClusterRadius(Integer maxClusterRadius) {
        getState().maxClusterRadius = maxClusterRadius;
    }

    public void setSingleMarkerMode(Boolean singleMarkerMode) {
        getState().singleMarkerMode = singleMarkerMode;
    }

    public void setSpiderfyDistanceMultiplier(Integer spiderfyDistanceMultiplier) {
        getState().spiderfyDistanceMultiplier = spiderfyDistanceMultiplier;
    }

    public void setIconCreateFunctionString(String iconCreateFunctionString) {
        getState().iconCreateFunctionString = iconCreateFunctionString;
    }
	
}
