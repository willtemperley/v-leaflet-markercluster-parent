package org.vaadin.addon.leaflet.markercluster.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.communication.RpcProxy;
import org.peimari.gleaflet.client.ClickListener;
import org.peimari.gleaflet.client.LayerGroup;
import org.peimari.gleaflet.client.MouseEvent;
import org.vaadin.addon.leaflet.client.LeafletFeatureGroupConnector;
import org.vaadin.addon.leaflet.client.U;
import org.vaadin.addon.leaflet.markercluster.LMarkerClusterGroup;
import org.vaadin.addon.leaflet.markercluster.shared.AnimationEndServerRpc;
import org.vaadin.gleaflet.markercluster.client.AnimationEndListener;
import org.vaadin.gleaflet.markercluster.client.MarkerClusterGroup;

import com.vaadin.shared.ui.Connect;
import org.vaadin.gleaflet.markercluster.client.MarkerClusterGroupOptions;

@Connect(LMarkerClusterGroup.class)
public class LeafletMarkerClusterConnector extends LeafletFeatureGroupConnector {
	
private MarkerClusterGroup markerClusterGroup;

    AnimationEndServerRpc animationEndServerRpc = RpcProxy.create(AnimationEndServerRpc.class, this);
    
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
        clusterClickListener = markerClusterGroup.addClickListener(new ClickListener() {
            @Override
            public void onClick(MouseEvent event) {
                rpc.onClick(U.toPoint(event.getLatLng()),
                        MouseEventDetailsBuilder.buildMouseEventDetails(event.getNativeEvent(), getLeafletMapConnector().getWidget().getElement()));
            }
        });

        markerClusterGroup.removeAnimationEndListener();
        markerClusterGroup.addAnimationEndListener(new AnimationEndListener() {
            @Override
            public void onAnimationEnd() {
                animationEndServerRpc.onAnimationEnd();
            }
        });
    }

}
