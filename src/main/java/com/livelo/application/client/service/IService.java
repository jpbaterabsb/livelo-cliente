package com.livelo.application.client.service;

import java.util.List;
import java.util.Map;

public interface IService<T, ID> {

   T findById(ID id);

   List<T> findAll();

   void deleteById(ID id);

   T save(T t);

   T update(T t, ID id);

   void deleteAll();

   List<T> findByObject(Map<String, Object> params);

   T updatePartial(Map<String, Object> params,ID id);

}
