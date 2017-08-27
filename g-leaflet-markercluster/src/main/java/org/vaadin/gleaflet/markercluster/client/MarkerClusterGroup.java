package org.vaadin.gleaflet.markercluster.client;

import com.google.gwt.core.client.JavaScriptObject;
import org.peimari.gleaflet.client.ClickListener;
import org.peimari.gleaflet.client.LayerGroup;
import org.peimari.gleaflet.client.Marker;
import org.vaadin.gleaflet.markercluster.client.resources.LeafletMarkerClusterResourceInjector;

/**
 * @author Will Temperley
 */
public class MarkerClusterGroup extends LayerGroup {

    static {
        LeafletMarkerClusterResourceInjector.ensureInjected();
    }

    protected MarkerClusterGroup() {
    }

    public static native MarkerClusterGroup create(MarkerClusterGroupOptions options)
    /*-{
        return new $wnd.L.MarkerClusterGroup(options);
    }-*/;

    public static native void addLayer(Marker marker)
	/*-{
        this.addLayer(marker)
    }-*/;

    public native final JavaScriptObject addClusterClickListener(ClusterClickListener listener)
	/*-{
        var fn = $entry(function (e) {
            listener.@org.vaadin.gleaflet.markercluster.client.ClusterClickListener::onClick(Lorg/peimari/gleaflet/client/MouseEvent; Lorg/vaadin/gleaflet/markercluster/client/MarkerCluster;)(e, e.layer);
        });
        fn.prototype['gname'] = "clusterclick";
        this.on(fn.prototype['gname'], fn);
        return fn;
    }-*/;

    public native final void removeAnimationEndListener()
	/*-{
        this.off("animationend");
    }-*/;

    public native final void addAnimationEndListener(AnimationEndListener listener)
	/*-{
        var fn = $entry(function (e) {
            listener.@org.vaadin.gleaflet.markercluster.client.AnimationEndListener::onAnimationEnd()();
        });
        fn.prototype['gname'] = "animationend";
        this.on(fn.prototype['gname'], fn);
    }-*/;

}
