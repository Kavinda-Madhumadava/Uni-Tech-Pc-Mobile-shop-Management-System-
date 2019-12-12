/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.SuperBO;
import lk.ijse.UniTechPC.DTO.FinishedDTO;

/**
 *
 * @author kavinda
 */
public interface FinishedBO extends SuperBO{

    public boolean addFin(FinishedDTO dto) throws Exception;

    public ArrayList<FinishedDTO> getAllItems()throws Exception;
    
}
