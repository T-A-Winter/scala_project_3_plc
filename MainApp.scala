package Assigtnment3PLC22WS

import Assigtnment3PLC22WS.Database

object MainApp {
  def main(args: Array[String]): Unit = {

    val scr = CSVReader.readCSV(args.head).toArray
    val db: Database = new Database(scr)
    println(db.sumUp())
  }
}

object CSVReader {
  def readCSV(filename: String): List[StoreItem] = {
    var items = List[StoreItem]()
    val bufferedSource = io.Source.fromFile(filename)
    for(line <- bufferedSource.getLines.drop(1)) {
      val cols = line.split(",").map(_.trim)
      val item = new StoreItem(cols(2).toInt, cols(4).toString, cols(5).toInt)
      items = items :+ item
      println(cols(2))
    }
    bufferedSource.close
    items
  }
}