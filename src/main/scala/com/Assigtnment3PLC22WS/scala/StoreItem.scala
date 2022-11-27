package com.Assigtnment3PLC22WS.scala

import com.Assigtnment3PLC22WS.scala.StoreItem.create

class StoreItem (var id: Int = 0, var name: String, var value: Int) extends Item with Logger {

  id = create()

  def getId(): Int = id

  def getName(): String = name

  def getValue(): Int = value
}

object StoreItem{
  private var counter = 0

  def create(): Int = {
    counter += 1
    counter
  }
}
