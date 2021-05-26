package Method;

import GUI.MainPanels.CanvasPanel;
import Enum.Quad;

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
        canvasPanel.setCanvasData(pos, color, brushRadius);
    }

    public void removePixel(Point pos) {
        canvasPanel.setCanvasData(pos, Color.WHITE, brushRadius);
    }

    public void fillArea(Point pos, BufferedImage canvas) {
        ArrayList<Point> posArr = new ArrayList<>();
        ArrayList<Point> visited = new ArrayList<>();
        posArr.add(new Point(pos.x, pos.y));
        getPosArrB(posArr, visited, canvas, canvas.getRGB(pos.x, pos.y));
        canvasPanel.setCanvasData(posArr, color);
    }

//    public void getPosArr(ArrayList<Point> posArr, ArrayList<Point> visited, BufferedImage canvas, int target) {
//        Queue<Point> queue = new LinkedList<>();
//        Point curr;
//        queue.add(posArr.get(0));
//        while (!queue.isEmpty()) {
//            if (visited.contains(queue.peek())) {
//                queue.remove();
//                continue;
//            }
//            int x = queue.peek().x;
//            int y = queue.peek().y;
//            queue.remove();
//            int lx = x;
//            while (target == canvas.getRGB(lx, y)) {
//                curr = new Point(lx, y);
//                posArr.add(curr);
//                visited.add(curr);
//                lx--;
//            }
//            while (target == canvas.getRGB(x, y)) {
//                curr = new Point(x, y);
//                posArr.add(curr);
//                visited.add(curr);
//                x++;
//            }
//            for (int rx = lx; rx < x; rx++) {
//                if (target == canvas.getRGB(rx, y)) {
//                    queue.add(new Point(rx, y + 1));
//                }
//            }
//            for (int rx = lx; rx < x; rx++) {
//                if (target == canvas.getRGB(rx, y)) {
//                    queue.add(new Point(rx, y - 1));
//                }
//            }
//        }
//    }

    public void getPosArrB(ArrayList<Point> posArr, ArrayList<Point> visited, BufferedImage canvas, int target) {
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
                visited.remove(visited.size()-1);
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
