
import TravellingSalesmanProblem.Karte._
import scala.util.Random.nextInt

object test {

  def makePs(x: Int, y: Int, n: Int): Array[P] = {
    var a: Array[P] = new Array(n)

    def randx = nextInt(x + 1) // 0 through x
    def randy = nextInt(y + 1) // 0 through y

    // fill array
    for (i <- 0 until n)
      a(i) = P(randx, randy)

    a
  }

  def tripLength(a: Array[P]): Double = {
    var length: Double = 0

    // distance: first -> ... -> last
    for (i <- 0 until a.length - 1)
      length += a(i) distance a(i + 1)

    // distance: last -> first
    length += (a(0) distance a(a.length - 1))

    length
  }

  def sortNearest(a: Array[P]): Array[P] = {
    var l: Array[P] = Array()
    l :+= a(0)

    while (l.length < a.length) {
      var dist: Double = -1
      var index = -1

      for (i <- 1 until a.length if !l.contains(a(i)))
        if (l(l.length - 1).distance(a(i)) < dist || dist < 0) {
          dist = l(l.length - 1) distance a(i)
          index = i
        }
      l :+= a(index)
    }

    l
  }


  val z = makePs(100, 100, 5)
  tripLength(z)

  val zNearest = sortNearest(z)
  tripLength(zNearest)

}