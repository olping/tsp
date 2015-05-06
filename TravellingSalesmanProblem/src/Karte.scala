/**
 * Created by olping on 5/6/15.
 */

package TravellingSalesmanProblem

object Karte {

  import scala.math._


  case class P(val x:Int, val y:Int) {

    require(x>=0 && y>=0)


    def distance(that:P):Double =
      sqrt( pow(this.x-that.x, 2) + pow(this.y-that.y, 2) )


    override def toString = "( "+x+" | "+y+" )"

  }

}
