package Assigtnment3PLC22WS

class StoreItem (private var _id :Int, private var _name: String, private var _value: Int) extends Item with Logger with Ordered[StoreItem]{
  def id: Int = _id
  def name: String = _name
  def value: Int = _value

  def id_=(newId: Int): Unit = _id = newId
  def name_=(newName: String): Unit = _name = newName
  def value_=(newValue: Int): Unit = _value = newValue

  def getId(): Int = id
  def getName(): String = name
  def getValue(): Int = value

  override def compare(that: StoreItem): Int = {
    getValue() compare that.getValue()
  }
}

object StoreItem{
  private var counter = 0

  def create(): Int = {
    counter += 1
    counter
  }
}