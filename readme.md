# Leaflet.markercluster wrappers for Vaadin & GWT

This project provides Java API for both client (GWT, with "g-" prefix) and server (Vaadin) side for the popular Leaflet add-on.

Realeases can be downloaded form [https://vaadin.com/directory](https://vaadin.com/directory)

### Vaadin API for Leaflet: [V-Leaflet](https://github.com/mstahv/v-leaflet)

During development you might need to have development version of v-leaflet, g-leaflet and possibly g-leaflet-draw as well.

### The original Leaflet add-on library: [ Leaflet.markercluster](https://github.com/Leaflet/Leaflet.markercluster)

### The core slippy map library: [LeafletJS](http://leafletjs.com)

Run this in the v-leaflet-markercluster module dir to get the test server going:

`mvn -e exec:java -Dexec.mainClass="org.vaadin.addon.leaflet.demoandtestapp.util.TServer" -Dexec.classpathScope=test`

