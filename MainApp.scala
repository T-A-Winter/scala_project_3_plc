package Assigtnment3PLC22WS

import Assigtnment3PLC22WS.Database


object MainApp {
  def main(args: Array[String]): Unit = {

    val db: Database = new Database()
    val scr: List[StoreItem] = CSVReader.readCSV("data.csv")
    scr.foreach(item => db.store(item))

    println("- - - SUM UP - - -")
    println(db.sumUp())
    println("- - - FILTERED BY ASUS - - -")
    var searched: Array[StoreItem] = db.findByName("ASUS")
    searched.foreach(item => println(item.getName()))
  }
}

object CSVReader {
  def readCSV(filename: String): List[StoreItem] = {
    var items = List[StoreItem]()
    val bufferedSource = io.Source.fromFile(filename)
    for(line <- bufferedSource.getLines.drop(1)) {
      val cols = line.split(",").map(_.trim)
      val item = new StoreItem(cols(0).toInt, cols(1), cols(2).toInt)
      items = items :+ item
    }
    bufferedSource.close
    items
  }
}