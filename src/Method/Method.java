package Method;

import GUI.MainPanels.CanvasPanel;
import Enum.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Method extends ImageBuffer {


    public Method(CanvasPanel canvasPanel) {
        super(canvasPanel);
    }

    public void setPixel(Point pos) {
        ArrayList<Point> base = dataStrokes.get(currentStroke);
        ArrayList<Point> temp = new ArrayList<>();
        for (Point point : base) {
            int x = point.x + pos.x;
            int y = point.y + pos.y;
            temp.add(new Point(x,y));
        }
        canvasPanel.setCanvasData(temp, currentColor);
    }

    public void removePixel(Point pos) {
        ArrayList<Point> base = dataStrokes.get(BrushStroke.SQUARE);
        ArrayList<Point> temp = new ArrayList<>();
        for (Point point : base) {
            int x = point.x + pos.x;
            int y = point.y + pos.y;
            temp.add(new Point(x,y));
        }
        canvasPanel.setCanvasData(temp, Color.WHITE);
    }

    public static void setBrushStroke(BrushStroke type) {
        currentStroke = type;
    }

    public void fillArea(Point pos, BufferedImage canvas) {
        ArrayList<Point> posArr = new ArrayList<>();
        ArrayList<Point> visited = new ArrayList<>();
        posArr.add(new Point(pos.x, pos.y));
        getArea(posArr, visited, canvas, canvas.getRGB(pos.x, pos.y));
        canvasPanel.setCanvasData(posArr, currentColor);
    }


    public void getArea(ArrayList<Point> posArr, ArrayList<Point> visited, BufferedImage canvas, int target) {
        Queue<Quad> queue = new LinkedList<>();
        Point t;
        Quad p;
        queue.add(new Quad(posArr.get(0).x, posArr.get(0).x, posArr.get(0).y, 1));
        queue.add(new Quad(posArr.get(0).x, posArr.get(0).x, posArr.get(0).y - 1, -1));

        while (!queue.isEmpty()) {
            p = queue.peek();
            queue.remove();
            if (visited.contains(new Point(p.x1, p.y))) {
                continue;
            }
            int x = p.x1;
            if (target == canvas.getRGB(x, p.y)) {
                while (target == canvas.getRGB(x - 1, p.y)) {
                    t = new Point(x - 1, p.y);
                    posArr.add(t);
                    visited.add(t);
                    x--;
                }
                visited.remove(visited.size() - 1);
            }

            if (x < p.x1) {
                queue.add(new Quad(x, p.x1 - 1, p.y - p.dy, -p.dy));
            }

            while (p.x1 < p.x2) {
                while (target == canvas.getRGB(p.x1, p.y)) {
                    t = new Point(p.x1, p.y);
                    posArr.add(t);
                    visited.add(t);
                    p.x1++;
                }
                queue.add(new Quad(x, p.x1 - 1, p.y + p.dy, p.dy));

                if (p.x1 - 1 > p.x2) {
                    queue.add(new Quad(p.x2 + 1, p.x1 - 1, p.y - p.dy, -p.dy));
                }

                while (p.x1 < p.x2 && target != canvas.getRGB(p.x1, p.y)) {
                    p.x1++;
                }
                x = p.x1;
            }
        }
    }


}
