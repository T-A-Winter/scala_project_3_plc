package Assigtnment3PLC22WS

class Database () extends ShoppingCart {

  private var storedItems = Array[StoreItem]()


  def getStoredItems() :Array[StoreItem] = storedItems

  override def delete(id: Int): Array[StoreItem] = {
    ???
  }

  override def search(name: String): Array[StoreItem] = {
    val searchedItem: Array[StoreItem] =
      storedItems.filter(item => item.getName().contains(name))

    searchedItem.foreach(item => item.logAction("found", item.getName()))

    if (searchedItem.length <= 0)
      println(s"$name : not found")
    searchedItem
  }

  def findByName(name:String, list: Array[StoreItem]): Array[StoreItem] = {
    val searchedItem: Array[StoreItem] =
      list.filter(item => item.getName().contains(name))
    searchedItem.sortBy(_.getValue())
  }

  override def sortByValueAsc(): Array[StoreItem] = {
    storedItems.sorted
  }

  override def sortByValueDesc(): Array[StoreItem] = {
    storedItems.sorted.reverse
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    storedItems =  storedItems :+ item
    item.logAction(s"stored", item.getName())
    storedItems
  }

  override def sumUp(): Int = {
    val sum = storedItems.map(item => item.getValue()).sum
    sum
  }

}