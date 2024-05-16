/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gaalop.gappco.model;

/**
 *
 * @author steinmetz
 */
public class RegisterEntryLink {
    
    public RegisterEntry entry;
    public byte prefactor;

    public RegisterEntryLink(RegisterEntry entry, byte prefactor) {
        this.entry = entry;
        this.prefactor = prefactor;
    }

    @Override
    public String toString() {
        return (prefactor==1 ? "" : "-") + entry.toString();
    }

}
