package Assigtnment3PLC22WS

class StoreItem (var id: Int = 0, var name: String, var value: Int) extends Item with Logger with Ordered[StoreItem]{

  id = StoreItem.create()

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