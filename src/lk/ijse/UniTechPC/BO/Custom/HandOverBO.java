/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom;

import lk.ijse.UniTechPC.BO.SuperBO;
import lk.ijse.UniTechPC.DTO.HandOverDTO;

/**
 *
 * @author kavinda
 */
public interface HandOverBO extends SuperBO{

    public boolean addHand(HandOverDTO dto)throws Exception;
    
}
