package com.Assigtnment3PLC22WS.scala

class Database (private var storedItems: Array[StoreItem]) extends ShoppingCart {

  override def delete(id: Int): Array[StoreItem] = ???

  override def search(name: String): Array[StoreItem] = {

  }

  override def sortByValueAsc(): Array[StoreItem] = ???

  override def sortByValueDesc(): Array[StoreItem] = ???

  override def store(item: StoreItem): Array[StoreItem] = ???

  override def sumUp(): Int = ???
}
