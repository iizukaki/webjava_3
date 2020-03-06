package jp.co.systena.tigerscave.springhellodb.applicaion.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * The Class ListForm.
 */
public class ListForm {
  @Valid
  private List<Item> itemList;

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  /** 商品ID */
  private int item_id;

  /** 個数 */
  @Min(1) //設定できる最小値を定義
  private int item_count;

  public int getItemId() {
    return item_id;
  }

  public void setItemId(int item_id) {
    this.item_id = item_id;
  }

  public int getItemCount() {
    return item_count;
  }

  public void setItemCount(int item_count) {
    this.item_count = item_count;
  }

}
