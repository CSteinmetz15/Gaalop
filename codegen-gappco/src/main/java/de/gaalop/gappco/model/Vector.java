/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gaalop.gappco.model;

import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author steinmetz
 */
public class Vector extends LinkedList<RegisterEntryLink> {
    
    public String name;

    public Vector(String name) {
        this.name = name;
    }

    public int getStage() {
        int stage = 0;
        for (RegisterEntryLink link: this) 
            for (RegisterEntryMeaning m: link.entry)
                stage = Math.max(stage, m.stage);
        return stage;
    }

    @Override
    public String toString() {
        return "[" + StringUtils.join(this, ", ") + "]";
    }
 
}
