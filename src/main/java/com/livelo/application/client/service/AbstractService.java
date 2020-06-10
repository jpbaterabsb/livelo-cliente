package com.livelo.application.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public abstract class AbstractService<T, ID> implements IService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Override
    public T findById(final ID id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(final ID id) {
        this.repository.deleteById(id);
    }

    @Override
    public T save(final T t) {
        return this.repository.save(t);
    }


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Override
    public T update(T t, ID id) {
        this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bad request"));
        return this.repository.save(t);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }


    @Override
    public T updatePartial(final Map<String, Object> params, final ID id) {
        T t = findById(id);
        params.forEach((k, v) -> {
            Field field = Optional.ofNullable(ReflectionUtils.findField(t.getClass(), k))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "field not found"));
            field.setAccessible(true);
            ReflectionUtils.setField(field, t, v);
        });
        return this.repository.save(t);
    }

    @Override
    public List<T> findByObject(final Map<String, Object> params) {
        final Example<T> example = getExample(params);
        return this.repository.findAll(example);
    }

    protected Example<T> getExample(final Map<String, Object> params) {
        final T filtros = getObjectWithParams(params);
        return Example.of(filtros,
                ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
    }

    private T getClassObject() {
        try {
            return (T) ((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]).newInstance();
        } catch (InstantiationException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private T getObjectWithParams(final Map<String, Object> params) {
        try {
            final T object = getClassObject();
            final BeanInfo bi = Introspector.getBeanInfo(Objects.requireNonNull(object, "class must not be null")
                    .getClass());
            final PropertyDescriptor pds[] = bi.getPropertyDescriptors();


            params.forEach((key, value) -> {
                for (PropertyDescriptor property : pds) {
                    if (property.getName().equals(key)) {
                        try {
                            property.getWriteMethod().invoke(object, value);
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            return object;
        } catch (IntrospectionException e1) {
            e1.printStackTrace();
        }
        return null;
    }

}

