package jp.co.systena.tigerscave.springhellodb.applicaion.model;

import javax.validation.constraints.Pattern;

/**
 * The Class Order.
 */
public class Order {
  @Pattern(regexp="^[0-9]*$")
  private String item_id;
  private String item_name;
  @Pattern(regexp="^[0-9]*$")
  private int price;
  private String item_count;

  public @Pattern(regexp = "^[0-9]*$") @Pattern(regexp = "^[0-9]*$") String getItemId() {
    return item_id;
  }
  public void setItemId(@Pattern(regexp = "^[0-9]*$") @Pattern(regexp = "^[0-9]*$") String item_id) {
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
  /** 個数 */
  public String getItemCount() {
    return item_count;
  }
  public void setItemCount(String item_count) {
    this.item_count = item_count;
  }

}
