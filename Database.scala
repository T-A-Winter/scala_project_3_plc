package Assigtnment3PLC22WS

class Database () extends ShoppingCart {

  private var storedItems = Array[StoreItem]()


  def getStoredItems() :Array[StoreItem] = storedItems
  //exam example
  def higherThan(value :Int) : Array[StoreItem] = {
    val filteredItems = storedItems.filter(_.getValue() > value)
    val sortedItems = filteredItems.sortBy(_.getValue())
    sortedItems.map(i => i.logAction(s"higherThan call", i.getName()))
    sortedItems
  }

  //exam example
  def filterByName(name: String, items: Array[StoreItem]): Array[StoreItem] = {
    val filterdItems = items.filter(_.getName() == name)
    filterdItems
  }

  override def delete(id: Int): Array[StoreItem] = {
    var found:Boolean = false
    storedItems.foreach(item => {
      if(item.getId() == id){
        found = true
        item.logAction(s"delete", item.getId().toString)
      }
    })
    if(!found){
      println("delete: item not found")
    }
    storedItems = storedItems.filter(item => item.getId() != id)
    storedItems
  }

  override def search(name: String): Array[StoreItem] = {
    val searchedItem: Array[StoreItem] =
      storedItems.filter(item => item.getName().contains(name))

    searchedItem.map(item => item.logAction("found", item.getName()))

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
    storedItems.sortWith((item1, item2) => item1.getValue() <= item2.getValue())
  }

  override def sortByValueDesc(): Array[StoreItem] = {
    storedItems.sortWith((item1, item2) => item1.getValue() <= item2.getValue()).reverse
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