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
public class CopyInstruction {
    
    public RegisterEntryLink from;
    public RegisterEntry to;

    public CopyInstruction(RegisterEntryLink from, RegisterEntry to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return to.toString() + " = "+ from.toString();
    }
    
    public int getStage() {
        return from.entry.getStage();
    }
}
