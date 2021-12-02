package lib;

import lib.core.Core;

import java.awt.*;

public class ColorArray {
    private int[] translate;
    private Color[][] image;
    private Rectangle bounds;
    private double fac;

    private Color mix(Color color1, Color color2, double fac){
        try {
            return new Color((int) (((-fac + 1) * color1.getRed() + fac * color2.getRed())), (int) (((-fac + 1) * color1.getGreen() + fac * color2.getGreen())), (int) (((-fac + 1) * color1.getBlue() + fac * color2.getBlue())));
        } catch (NullPointerException e){
            return Color.GRAY;
        }
        }


    public void setFac(double fac) {
    	this.fac = fac;
    }

    public ColorArray(Rectangle bnds, int[] translate){
        this.bounds = bnds;
        this.translate = translate;

        image = new Color[bounds.width][bounds.height];
        for (int i = 0; i < bounds.width; i++){
            for (int j = 0; j < bounds.height; j++){
                image[i][j] = Color.WHITE;
            }
        }
    }

    public void paint(double x, double y, Color c){
        try {
            image[(int) (x * Core.scaling) + translate[0]][(int) (y * Core.scaling) + translate[1]] = mix(c,image[(int) (x * Core.scaling) + translate[0]][(int) (y * Core.scaling) + translate[1]],fac);
        } catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public void renderImage(Graphics2D g){
        for (int i = 0; i < bounds.width; i++){
            for (int j = 0; j < bounds.height; j++){
                    g.setColor(image[i][j]);
                    g.drawRect(i,j,0,0);
                }
            }
        }
    }


