import com.company.CvTriangles;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// This program draws 50 triangles inside each other.
public class FiftyConcentricTriangles extends Frame {

  public static void main(String[] args) {
    new FiftyConcentricTriangles();
  }

  FiftyConcentricTriangles() {
    super("Triangles: 50 triangles inside each other");
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setSize(600, 400);
    add("Center", new TrianglesPanel());
    setVisible(true);
  }
}
