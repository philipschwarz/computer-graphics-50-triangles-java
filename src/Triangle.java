public record Triangle(Point a, Point b, Point c) {

  static Triangle instance(Point centre, Float side, Float height) {
    var x = centre.x();
    var y = centre.y();
    var halfSide = 0.5F * side;
    var bottomLeft = new Point(x - halfSide, y - 0.5F * height);
    var bottomRight = new Point(x + halfSide, y - 0.5F * height);
    var top = new Point(x, y + 0.5F * height);
    return new Triangle(bottomLeft,bottomRight,top);
  }

}