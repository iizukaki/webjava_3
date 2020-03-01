package jp.co.systena.tigerscave.springhellodb.applicaion.model;

import javax.validation.constraints.Pattern;

public class Item {

  @Pattern(regexp="^[0-9]*$")
  private String item_id;
  public String getItemId() {
    return item_id;
  }
  public void setItemId(String item_id) {
    this.item_id = item_id;
  }
  public String getItemName() {
    return item_name;
  }
  public void setItemName(String item_name) {
    this.item_name = item_name;
  }
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }
  private String item_name;
  @Pattern(regexp="^[0-9]*$")
  private String price;
}
