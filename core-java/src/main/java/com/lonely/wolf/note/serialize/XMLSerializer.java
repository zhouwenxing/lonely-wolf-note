package com.lonely.wolf.note.serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/1
 * @since jdk1.8
 */
public class XMLSerializer implements ISerializer {
    XStream xStream=new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T)xStream.fromXML(new String(data));
    }
}
