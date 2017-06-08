/* *********************************************************************** *
 * project: simsocsys
 *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2016 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : gregor dot laemmel at gmail dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */


import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;



/**
 * Created by laemmel on 24/04/16.
 */
public class VehicleInfo {

    private final int x;
    private final int y;
    

    private final double phi;


    private final int radius;
	private final float colourR;
	private final float colourG;
	private final float colourB;
	private PVector forceTarget;
	private PVector forceVehicles;
	private PVector forceWalls;
	
    
    public VehicleInfo(double x, double y, double phi, double radius, double colourR, double colourG, double colourB, 
    		PVector forceTarget, PVector forceVehicles, PVector forceWalls) {
        this.x = (int) (Simulation.SCALE * x);
        this.y = (int) (Simulation.SCALE * y);
        this.phi = phi;
        this.radius = (int) (Simulation.SCALE * radius);
        this.colourR = (float) colourR;
        this.colourG = (float) colourG;
        this.colourB = (float) colourB;
        this.forceTarget = forceTarget;
        this.forceVehicles = forceVehicles;
        this.forceWalls = forceWalls;		

    }
    

    public void draw(PApplet p) {
        p.pushMatrix();

        p.translate(x, y);

        p.rotate((float) (phi));

        p.fill(255, 64, 64, 200);
//        p.stroke(255,0,0);
     
        p.ellipseMode(PConstants.CENTER);
        p.fill(255, 0, 0);
        p.ellipse(radius / 2, -radius / 2, 2, 2);
        p.fill(255, 0, 0);
        p.ellipse(radius / 2, radius / 2, 2, 2);
        p.fill(colourR,colourG,colourB);
        p.ellipse(radius / 4, 0, radius, radius);
        p.ellipse(radius / 4, 0, 7, 7);
        p.popMatrix();
               
        p.line((float)x,(float)y ,((float)x + forceTarget.x),(float)y + forceTarget.y);
        
        
    }
}
