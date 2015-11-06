package org.vaadin.gleaflet.markercluster.client;

import com.google.gwt.core.client.JavaScriptObject;

public class MarkerClusterGroupOptions extends JavaScriptObject {

    protected MarkerClusterGroupOptions() {
    }

    public static native MarkerClusterGroupOptions create()
    /*-{
        return {};
    }-*/;

    public native final void setShowCoverageOnHover(boolean showCoverageOnHover)
    /*-{
        this.showCoverageOnHover = showCoverageOnHover;
    }-*/;

    public native final void setZoomToBoundsOnClick(boolean zoomToBoundsOnClick)
    /*-{
        this.zoomToBoundsOnClick = zoomToBoundsOnClick;
    }-*/;

    public native final void setSpiderfyOnMaxZoom(boolean spiderfyOnMaxZoom)
    /*-{
        this.spiderfyOnMaxZoom = spiderfyOnMaxZoom;
    }-*/;

    public native final void setRemoveOutsideVisibleBounds(boolean removeOutsideVisibleBounds)
    /*-{
        this.removeOutsideVisibleBounds = removeOutsideVisibleBounds;
    }-*/;

    public native final void setAnimateAddingMarkers(boolean animateAddingMarkers)
    /*-{
        this.animateAddingMarkers = animateAddingMarkers;
    }-*/;

    public native final void setDisableClusteringAtZoom(int zoomLevel)
    /*-{
        this.disableClusteringAtZoom = zoomLevel;
    }-*/;

    public native final void setMaxClusterRadius(int maxClusterRadius)
    /*-{
        this.maxClusterRadius = maxClusterRadius;
    }-*/;

    public native final void setSingleMarkerMode(boolean singleMarkerMode)
    /*-{
        this.singleMarkerMode = singleMarkerMode;
    }-*/;

    public native final void setSpiderfyDistanceMultiplier(int spiderfyDistanceMultiplier)
    /*-{
        this.spiderfyDistanceMultiplier = spiderfyDistanceMultiplier;
    }-*/;
}
