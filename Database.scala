package Assigtnment3PLC22WS

class Database (private var storedItems: Array[StoreItem]) extends ShoppingCart {

  override def delete(id: Int): Array[StoreItem] = ???

  override def search(name: String): Array[StoreItem] = {
    val searchedItem: Array[StoreItem] =
      storedItems.filter(item => item.getName().equals(name))

    searchedItem.foreach(item => item.logAction("found", item.getName()))

    if (searchedItem.length <= 0)
      println(s"$name : not found")
    searchedItem
  }

  override def sortByValueAsc(): Array[StoreItem] = {
    storedItems.sorted
  }

  override def sortByValueDesc(): Array[StoreItem] = {
    storedItems.sorted.reverse
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    storedItems :+ item
    item.logAction(s"stored", item.getName())
    storedItems
  }

  override def sumUp(): Int = {
    val sum = storedItems.toSeq.map(item => item.getValue()).sum
    sum
  }

}