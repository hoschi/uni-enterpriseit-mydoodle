package de.uniluebeck.itm;

import javax.xml.bind.annotation.adapters.XmlAdapter;
public final class AnyTypeAdapter extends XmlAdapter<Object, Object> {
    /**
     * Noop. Just returns the object given as the argument.
     */
    public Object unmarshal(Object v) {
        return v;
    }

    /**
     * Noop. Just returns the object given as the argument.
     */
    public Object marshal(Object v) {
        return v;
    }
}
