package Assigtnment3PLC22WS

import Assigtnment3PLC22WS.Database


object MainApp {
  def main(args: Array[String]): Unit = {

    val db: Database = new Database()
    val scr: List[StoreItem] = CSVReader.readCSV("C:\\Users\\Tobi\\IdeaProjects\\Assignment_3\\src\\main\\scala\\Assigtnment3PLC22WS\\data.csv")
    scr.foreach(item => db.store(item))

    println("--- SUM UP ---")
    println(db.sumUp())
    println("--- FILTERED BY ASUS ---")
    var searched_1: Array[StoreItem] = db.findByName("ASUS",scr.toArray)
    searched_1.foreach(item => println(item.getName()))
    println(searched_1.size)
    println("--- FILTERED BY Lenovo ---")
    var searched_2: Array[StoreItem] = db.findByName("Lenovo", scr.toArray)
    searched_2.foreach(item => println(item.getName()))
    println(searched_2.size)
    println("--- FILTERED BY HP ---")
    var searched_3: Array[StoreItem] = db.findByName("HP", scr.toArray)
    searched_3.foreach(item => println(item.getName()))
    println(searched_3.size)
    println("--- SORTED ITEMS ---")
    var sordetList: Array[StoreItem] = db.sortByValueDesc()
    sordetList.foreach(item => println(item.getName() +" "+ item.getValue()))
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