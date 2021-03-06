/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2010, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.geopkg;

import com.vividsolutions.jts.geom.Envelope;
import java.util.ArrayList;
import java.util.List;

/**
 * Tiles Entry inside a GeoPackage.
 *
 * @author Justin Deoliveira
 * @author Niels Charlier
 */
public class TileEntry extends Entry {

    List<TileMatrix> tileMatricies = new ArrayList();

    Envelope tileMatrixSetBounds;

    public TileEntry() {
        setDataType(DataType.Tile);
    }

    public List<TileMatrix> getTileMatricies() {
        return tileMatricies;
    }

    void setTileMatricies(List<TileMatrix> tileMatricies) {
        this.tileMatricies = tileMatricies;
    }

    void init(TileEntry e) {
        super.init(e);
        setTileMatricies(e.getTileMatricies());
        this.tileMatrixSetBounds =
                e.tileMatrixSetBounds == null ? null : new Envelope(e.tileMatrixSetBounds);
    }

    /**
     * Returns the tile matrix set bounds. The bounds are expressed in the same CRS as the entry,
     * but they might differ in extent (if null, then the tile matrix bounds are supposed to be the
     * same as the entry)
     *
     * @return
     */
    public Envelope getTileMatrixSetBounds() {
        return tileMatrixSetBounds != null ? tileMatrixSetBounds : bounds;
    }

    public void setTileMatrixSetBounds(Envelope tileMatrixSetBounds) {
        this.tileMatrixSetBounds = tileMatrixSetBounds;
    }
}
