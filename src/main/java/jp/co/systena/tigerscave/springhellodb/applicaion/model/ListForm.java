package jp.co.systena.tigerscave.springhellodb.applicaion.model;

import javax.validation.constraints.Min;

/**
 * The Class ListForm.
 */
public class ListForm {

  /** 商品ID */
  private int item_id;

  /** 個数 */
  @Min(1) //設定できる最小値を定義
  private int num;

  public int getItemId() {
    return item_id;
  }

  public void setItemId(int item_id) {
    this.item_id = item_id;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

}
