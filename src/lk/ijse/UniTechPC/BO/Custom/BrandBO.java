/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.SuperBO;
import lk.ijse.UniTechPC.DTO.BarndDTO;

/**
 *
 * @author kavinda
 */
public interface BrandBO extends SuperBO {

    public ArrayList<BarndDTO> getAllBr() throws Exception;

    public BarndDTO searchName(String Name)throws Exception;

    public boolean addBrand(BarndDTO dto)throws Exception;

   

   

}
