package com.vtence.molecule;

import java.util.Map;

public interface Request {

    String protocol();

    HttpMethod method();

    String uri();

    String pathInfo();

    String parameter(String name);

    String ip();

    Object attribute(Object key);

    void attribute(Object key, Object value);

    void removeAttribute(Object key);

    Map<Object, Object> attributes();

    Session session();

    <T> T unwrap(Class<T> type);
}
