package lib;

import java.awt.*;

public class ColorArray {
    private int[] translate;
    private Color[][] image;
    private Rectangle bounds;

    public ColorArray(Rectangle bnds, int[] translate){
        this.bounds = bnds;
        this.translate = translate;

        image = new Color[bounds.width][bounds.height];
        for (int i = 0; i < bounds.width; i++){
            for (int j = 0; j < bounds.height; j++){
                image[i][j] = Color.BLACK;
            }
        }
    }

    public void paint(double x, double y, Color c){
        image[(int)(x*Core.scaling)+translate[0]][(int)(y*Core.scaling)+translate[1]] = c;
    }

    boolean didIWasExecute = false;
    public void renderImage(Graphics2D g){
        for (int i = 0; i < bounds.width; i++){
            for (int j = 0; j < bounds.height; j++){
                    g.setColor(image[i][j]);
                    g.drawRect(i,j,1,1);
                }
            }
        }
    }


