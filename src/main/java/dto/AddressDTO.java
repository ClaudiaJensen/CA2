/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Address;

/**
 *
 * @author Hassuni
 */
public class AddressDTO {
    private String street;
    private String additionalInfo;
    private String cityInfo;
    
    public AddressDTO(Address a){
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
        this.cityInfo = "ZIP code: " + a.getCityInfo().getZip() + "City: " + a.getCityInfo().getCity();
    }
}
