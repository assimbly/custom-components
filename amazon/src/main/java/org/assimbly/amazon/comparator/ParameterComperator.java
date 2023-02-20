package org.assimbly.amazon.comparator;

import org.apache.http.NameValuePair;

import java.util.Comparator;

public class ParameterComperator implements Comparator<NameValuePair> {

    @Override
    public int compare(NameValuePair p1, NameValuePair p2) {
        return p1.getName().compareTo(p2.getName());
    }

    @Override
    public Comparator<NameValuePair> reversed() {
        return null;
    }
}
