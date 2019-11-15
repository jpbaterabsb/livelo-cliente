package com.livelo.application.client.controller.controller;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class CrudRestTest<T,ID> extends AbstractRestTest {

    protected UriComponentsBuilder uriComponentsBuilder;
    private T instance;

    @Before
    public void setUp(){
        uriComponentsBuilder = UriComponentsBuilder.newInstance().path(getPath());
        instance = createObject();
    }


    public void create() throws Exception {
        T postObject = (T) post(uriComponentsBuilder.toUriString(), createObject(), instance.getClass());
        Assert.assertNotNull(postObject);
        Assert.assertNotNull(getId(postObject));

    }


    public void read() throws Exception {
        post(uriComponentsBuilder.toUriString(),createObject(),instance.getClass());
        T[] all = (T[]) get(uriComponentsBuilder.toUriString(),Stream.of(instance).toArray().getClass());
        List<T> allAsList = Arrays.asList(all);
        Assert.assertFalse(allAsList.isEmpty());
    }

    public void update() throws Exception {
        T createdObject = (T)  post(uriComponentsBuilder.toUriString(),createObject(),instance.getClass());
        T updateObject = setObject(createdObject);
        String uri = uriComponentsBuilder.path("/{id}").buildAndExpand(getId(updateObject)).toUriString();
        T putObject = (T) put(uri, updateObject, updateObject.getClass());
        Assert.assertEquals(updateObject,putObject);
    }

    public void delete() throws Exception {
        T createdObject = (T)  post(uriComponentsBuilder.toUriString(),createObject(),instance.getClass());
        String uri = uriComponentsBuilder.path("/{id}").buildAndExpand(getId(createdObject).toString()).toUriString();
        delete(uri,createdObject.getClass());
        T t = (T) get(uri, createdObject.getClass());
        Assert.assertNull(getId(t));

    }

    public void findById() throws Exception {
        T createdObject = (T)  post(uriComponentsBuilder.toUriString(),createObject(),instance.getClass());
        T t = (T) get(uriComponentsBuilder.path("/{id}").buildAndExpand(getId(createdObject)).toUriString(), createdObject.getClass());
        Assert.assertNotNull(t);
    }


    public void findByRequestParam() throws Exception {
        post(uriComponentsBuilder.toUriString(),createObject(),instance.getClass());
        T[] objects = (T[]) get(getUriWithRequestParams().toUriString(), Stream.of(instance).toArray().getClass());
        List<T> allAsList = Arrays.asList(objects);
        Assert.assertFalse(allAsList.isEmpty());
    }


    protected abstract T createObject();

    protected abstract T setObject(T t);

    private ID getId(T t) throws IllegalAccessException {
        return (ID) FieldUtils.readDeclaredField(t,"id",true);
    }

    protected abstract String getPath();
    protected abstract UriComponentsBuilder getUriWithRequestParams();

}
