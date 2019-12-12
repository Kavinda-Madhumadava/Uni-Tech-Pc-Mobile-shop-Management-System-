/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.UniTechPC.BO.Custom.Impl;

import java.util.ArrayList;
import lk.ijse.UniTechPC.BO.Custom.BrandBO;
import lk.ijse.UniTechPC.DAO.Custom.BrandDAO;
import lk.ijse.UniTechPC.DAO.DAOFactory;
import lk.ijse.UniTechPC.DTO.BarndDTO;
import lk.ijse.UniTechPC.Entity.Brand;

/**
 *
 * @author kavinda
 */
public class BrandBOImpl implements BrandBO {

    BrandDAO brandDAO = (BrandDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFactoryTypes.BRAND);

    @Override
    public ArrayList<BarndDTO> getAllBr() throws Exception {
        ArrayList<Brand> all = brandDAO.getAll();

        ArrayList<BarndDTO> allBrand = new ArrayList<>();
        for (Brand b : all) {
            allBrand.add(new BarndDTO(b.getBrandID(), b.getBrnadName()));

        }
        return allBrand;

    }

    @Override
    public BarndDTO searchName(String Name) throws Exception {
        Brand brand=brandDAO.search(Name);
        return new BarndDTO(brand.getBrandID(),brand.getBrnadName());
    }

    @Override
    public boolean addBrand(BarndDTO dto) throws Exception {
        return brandDAO.add(new Brand(dto.getBrandID(),dto.getBrandName()));
    }

   
    

}
