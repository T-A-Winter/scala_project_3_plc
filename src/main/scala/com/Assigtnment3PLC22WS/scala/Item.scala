package com.Assigtnment3PLC22WS.scala

trait Item {
  var id : Int
  var name : String
  var value : Int

  def getId(): Int
  def getName(): String
  def getValue(): Int

}
