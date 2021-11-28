package lib.core;

import lib.DrawPanel;
import lib.informatics4kids.Picture;
import lib.informatics4kids.PictureViewer;
import lib.masking.Faltung;
import lib.masking.examples.Sobel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DumpThePic {

    public BufferedImage awtImage;
    public Graphics g;
    public Picture picture;
    public PictureViewer pw;
    public Faltung faltung;

    public void dump(DrawPanel panel){
        awtImage = new BufferedImage(panel.getWidth(),panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        g = awtImage.getGraphics();
        panel.printAll(g);

        picture = new Picture();
        picture.setImage(awtImage);
    }

    public void transform(Sobel.SobelType sobelType){
        faltung.setPicture(picture);
        picture = faltung.transform(sobelType);
    }

    public void transform(){
        faltung.setPicture(picture);
        picture = faltung.transform();
    }

    public void setFaltung(Faltung faltung){
        this.faltung = faltung;
    }

    public void display() {
        pw = new PictureViewer(picture.getPicture());

        pw.show();
    }
}
