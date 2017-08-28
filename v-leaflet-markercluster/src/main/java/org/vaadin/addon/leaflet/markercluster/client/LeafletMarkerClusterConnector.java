package org.vaadin.addon.leaflet.markercluster.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.vaadin.client.communication.RpcProxy;
import org.peimari.gleaflet.client.*;
import org.vaadin.addon.leaflet.client.LeafletFeatureGroupConnector;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterGroup;
import org.vaadin.addon.leaflet.markercluster.shared.AnimationEndServerRpc;
import org.vaadin.addon.leaflet.markercluster.shared.MarkerClusterClickRpc;
import org.vaadin.gleaflet.markercluster.client.*;

import com.vaadin.shared.ui.Connect;

@Connect(LMarkerClusterGroup.class)
public class LeafletMarkerClusterConnector extends LeafletFeatureGroupConnector {
	
	private MarkerClusterGroup markerClusterGroup;

    private AnimationEndServerRpc animationEndServerRpc = RpcProxy.create(AnimationEndServerRpc.class, this);

    private MarkerClusterClickRpc markerClusterClickRpc = RpcProxy.create(MarkerClusterClickRpc.class, this);

    private JavaScriptObject clusterClickListener;

    public LeafletMarkerClusterState getState() {
        return (LeafletMarkerClusterState) super.getState();
    }

	@Override
	protected LayerGroup createLayerGroup() {
	MarkerClusterGroupOptions o = createOptions();
		return markerClusterGroup = MarkerClusterGroup.create(o);
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
    
    @Override
    public void update() {
		super.update();

        if (clusterClickListener != null) {
            markerClusterGroup.removeListener(clusterClickListener);
            clusterClickListener = null;
        }

        /*
        Serialize MarkerCluster to GeoJSON
         */
        clusterClickListener = markerClusterGroup.addClusterClickListener((event, cluster) -> {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"type\":\"FeatureCollection\",\"features\":[");
            JsArray<Marker> childMarkers = cluster.getAllChildMarkers();
            for (int i = 0; i < childMarkers.length(); i++) {
                Marker marker = childMarkers.get(i);
                String s = marker.toGeoJSONString();
                stringBuilder.append(s);
                if (i < childMarkers.length() - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]}");
            markerClusterClickRpc.onClusterClick(stringBuilder.toString());
        });

        markerClusterGroup.removeAnimationEndListener();
        markerClusterGroup.addAnimationEndListener(
                () -> animationEndServerRpc.onAnimationEnd()
        );
    }

}
