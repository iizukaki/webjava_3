package jp.co.systena.tigerscave.springhellodb.applicaion.model;

public class Item {


  private String itemId;
  private String name;
  private String price;

  public Item(String itemId, String name, String price) {
    this.itemId = itemId;
    this.name = name;
    this.price = price;
  }


  public  String getItemId() {
    return itemId;
  }
  public void setItemId(String itemId) {
    this.itemId = itemId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }

}
