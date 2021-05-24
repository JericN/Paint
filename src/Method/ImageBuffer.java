package Method;

import GUI.CanvasPanels.CanvasPanel;
import GUI.ToolPanels.ColorChangerPanel;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBuffer extends Variables{
    public ImageBuffer(CanvasPanel cp) {
        super(cp);
        colorWheel();
    }
    public void colorWheel(){
        BufferedImage in = null;
        try {
            in = ImageIO.read(new File("img/ColorWheel.png"));
        } catch (IOException e) {
            System.out.println("ERROR: 101");
        }
        global.colorWheel = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(0.666, 0.666);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        assert in != null;
        global.colorWheel = scaleOp.filter(in, global.colorWheel);
        ColorChangerPanel.img = global.colorWheel;
    }
}
