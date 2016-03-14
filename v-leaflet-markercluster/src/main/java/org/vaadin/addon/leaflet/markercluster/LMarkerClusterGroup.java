package org.vaadin.addon.leaflet.markercluster;

import com.vaadin.shared.MouseEventDetails;
import org.vaadin.addon.leaflet.LFeatureGroup;

import org.vaadin.addon.leaflet.LeafletClickEvent;
import org.vaadin.addon.leaflet.LeafletClickListener;
import org.vaadin.addon.leaflet.markercluster.client.LeafletMarkerClusterState;
import org.vaadin.addon.leaflet.markercluster.shared.AnimationEndServerRpc;
import org.vaadin.addon.leaflet.shared.ClickServerRpc;
import org.vaadin.addon.leaflet.shared.Point;

/**
 * 
 */
public class LMarkerClusterGroup extends LFeatureGroup {
	
	public LMarkerClusterGroup() {
        registerRpc(new ClickServerRpc() {
            @Override
            public void onClick(Point p, MouseEventDetails d) {
                fireEvent(new LeafletClickEvent(LMarkerClusterGroup.this, p, d));
            }
        });
        registerRpc(new AnimationEndServerRpc() {
            @Override
            public void onAnimationEnd() {
                fireEvent(new LeafletAnimationEndEvent(LMarkerClusterGroup.this));
            }
        });
    }

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
    
    public void addClickListener(LeafletClickListener listener) {
        addListener(LeafletClickEvent.class, listener,
                LeafletClickListener.METHOD);
    }

    public void addAnimationEndListener(LeafletAnimationEndListener listener) {
        addListener("onAnimationEnd", LeafletAnimationEndEvent.class, listener, LeafletAnimationEndListener.METHOD);
    }
	
}
