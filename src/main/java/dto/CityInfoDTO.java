/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.CityInfo;

/**
 *
 * @author Hassuni
 */
public class CityInfoDTO {
    private int id;
    private Integer zip;
    private String city;
    
    
    public CityInfoDTO(CityInfo c){
        this.id = c.getId();
        this.zip = c.getZip();
        this.city = c.getCity();
    }
}
