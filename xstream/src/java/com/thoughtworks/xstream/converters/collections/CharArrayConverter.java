package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CharArrayConverter implements Converter {

    public boolean canConvert(Class type) {
        return type.isArray() && type.getComponentType().equals(char.class);
    }

    public void toXML(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        char[] chars = (char[]) source;
        writer.writeText(new String(chars));
    }

    public Object fromXML(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return reader.text().toCharArray();
    }
}
