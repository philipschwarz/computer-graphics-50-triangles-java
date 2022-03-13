import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.stream.Stream;
import javax.swing.JPanel;

public class TrianglesPanel extends JPanel {

  public TrianglesPanel() {
    setBackground(Color.white);
  }

  public void paintComponent(Graphics g){

    super.paintComponent(g);

    Dimension panelSize = getSize();
    int panelWidth = panelSize.width - 1;
    int panelHeight = panelSize.height - 1;
    Point panelCentre = new Point(panelWidth / 2F, panelHeight / 2F);
    Float triangleSide = 0.95F * Math.min(panelWidth, panelHeight);
    Float triangleHeight = (0.5F * triangleSide) * (float)Math.sqrt(3);

    var triangle = Triangle.instance(panelCentre, triangleSide, triangleHeight);

    Stream
      .iterate(triangle, t -> shrinkAndTwist(t))
      .limit(50)
      .forEach(t -> draw(g, t, panelHeight));
  }

  Triangle shrinkAndTwist(Triangle t) {
    return new Triangle(
      combine(t.a(), t.b()),
      combine(t.b(), t.c()),
      combine(t.c(), t.a())
    );
  }

  void draw(Graphics g, Triangle t, int panelHeight) {
    drawLine(g, t.a(), t.b(), panelHeight);
    drawLine(g, t.b(), t.c(), panelHeight);
    drawLine(g, t.c(), t.a(), panelHeight);
  }

  void drawLine(Graphics g, Point a, Point b, int panelHeight) {
    var aCoords = deviceCoords(a, panelHeight);
    var bCoords = deviceCoords(b, panelHeight);
    int ax = aCoords.x, ay = aCoords.y, bx = bCoords.x, by = bCoords.y;
    g.drawLine(ax, ay, bx, by);
  }

  Point combine(Point a, Point b) {
    var q = 0.05F;
    var p = 1 - q;
    return new Point(p * a.x() + q * b.x(), p * a.y() + q * b.y());
  }

  java.awt.Point deviceCoords(Point p, int panelHeight) {
    return new java.awt.Point(Math.round(p.x()), panelHeight - Math.round(p.y()));
  }

}
