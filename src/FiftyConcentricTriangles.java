import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FiftyConcentricTriangles {

  public static void main(String[] args) {
    // Create the frame/panel on the event dispatching thread.
    SwingUtilities.invokeLater(
      () -> new FiftyConcentricTriangles().drawTriangles()
    );
  }

  void drawTriangles() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    var frame = new JFrame("Triangles: 50 triangles inside each other");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.add(new TrianglesPanel());
    frame.setVisible(true);
  }
}
