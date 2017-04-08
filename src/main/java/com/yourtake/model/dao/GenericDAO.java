/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao;

import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author MumbaiZone
 * @param <T>
 */
public interface GenericDAO <T>{
    
    public T create(T object);
         public List<T> read(String criteria,T object);
     public T update(T object);
     public boolean delete(T object);
     public SessionFactory getSessionFactory();
     public void setSessionFactory(SessionFactory factory);
    
    
}
