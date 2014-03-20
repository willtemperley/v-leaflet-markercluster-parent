package org.vaadin.gleaflet.markercluster.client.resources;

import org.peimari.gleaflet.client.resources.LeafletResourceInjector;

import com.google.gwt.core.client.GWT;

public class LeafletMarkerClusterResourceInjector {

	protected static LeafletMarkerClusterClientBundle bundle;

	public static void ensureInjected() {
		if (bundle == null) {
			LeafletResourceInjector.ensureInjected();
			bundle = GWT.create(LeafletMarkerClusterClientBundle.class);
			LeafletMarkerClusterResourceInjector injector = GWT
					.create(LeafletMarkerClusterResourceInjector.class);
			injector.injectResources();
		}
	}
	
	/**
	 * Override this with deferred binding to customize injected stuff
	 */
	protected void injectResources() {
		bundle.css().ensureInjected();
		bundle.defaultCss().ensureInjected();
		injectScript(bundle.clusterScript().getText());
	}

	private static native void injectScript(String script)
	/*-{
	    $wnd.eval(script);
	}-*/;

}
