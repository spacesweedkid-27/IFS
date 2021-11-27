package lib;

import java.awt.*;

public class ColorArray {
    private Color[][] image;
    private Rectangle bounds;

    public ColorArray(Rectangle bnds){
        this.bounds = bnds;

        image = new Color[bounds.width][bounds.height];
        for (int i = 0; i < bounds.width; i++){
            for (int j = 0; j < bounds.height; j++){
                image[i][j] = Color.WHITE;
            }
        }
    }

    private void drawPoint(double[] points, Graphics2D g) {
        g.drawRect( (int) (points[0]*Core.scaling), (int) (points[1]*Core.scaling), 1, 1);
    }

    public void paint(int x, int y, Color c){
        image[x][y] = c;
    }

    public void renderImage(Graphics2D g, int[] translate){

        for (int i = 0; i < bounds.width; i++){
            for (int j = 0; j < bounds.height; j++){
                g.setColor(image[i][j]);
                drawPoint(new double[]{i,j},g);
            }
        }
    }

}
