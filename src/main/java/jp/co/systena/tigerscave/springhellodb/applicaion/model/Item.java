package jp.co.systena.tigerscave.springhellodb.applicaion.model;

import javax.validation.constraints.Pattern;

public class Item {

  @Pattern(regexp="^[0-9]*$")
  private int item_id;
  private String item_name;
  @Pattern(regexp="^[0-9]*$")
  private int price;


  public @Pattern(regexp = "^[0-9]*$") int getItemId() {
    return item_id;
  }
  public void setItemId(@Pattern(regexp = "^[0-9]*$") int item_id) {
    this.item_id = item_id;
  }
  public String getItemName() {
    return item_name;
  }
  public void setItemName(String item_name) {
    this.item_name = item_name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(@Pattern(regexp = "^[0-9]*$") int price) {
    this.price = price;
  }

}
