/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.DAO;

import java.util.ArrayList;

/**
 *
 * @author kavinda
 */
public interface CrudDAO<T, ID> extends SuperDAO {

    public boolean add(T t) throws Exception;
    public T search(ID id) throws Exception;
    public boolean delete(String id)throws Exception;
    public ArrayList<T> getAll()throws Exception;
}
