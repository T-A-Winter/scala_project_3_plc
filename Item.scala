package Assigtnment3PLC22WS

trait Item {
  var id : Int
  var name : String
  var value : Int

  def getId(): Int
  def getName(): String
  def getValue(): Int

}
