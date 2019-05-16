import java.io.{File, PrintWriter}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Solution {
  def main(args: Array[String]): Unit = {
    val writer = new PrintWriter(new File("output.txt"))
    var theaterCounter = 0
    Source.fromFile("Problem2_input.txt").getLines().drop(1).grouped(2).foreach(inputData => {
      val numberOfShows = inputData.head.split(" ").head.toInt
      val familyList = ListBuffer(inputData.last.split(" ").map(_.toInt): _ *)
      var totalFamilyMembers = 0
      for (i <- 1 to numberOfShows) {
        var theaterCapacity = inputData.head.split(" ")(1).toInt
          var familyCounter = 0
          for (k <- 0 until familyList.size if familyList(0) <= theaterCapacity){
            theaterCapacity = theaterCapacity - familyList(0)
            totalFamilyMembers = totalFamilyMembers + familyList(0)
            familyList += familyList(0)
            familyList.remove(0)
          }
      }
      theaterCounter += 1
      writer.write(s"Theater-$theaterCounter: ${totalFamilyMembers * 10}\n")
    })
    writer.close()
  }
}
