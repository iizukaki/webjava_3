package jp.co.systena.tigerscave.springhellodb.applicaion.model;

/**
 * The Class Cart.
 */
/*

public class Cart {

  @Autowired
  private  JdbcTemplate jdbcTemplate;

  private List<Order> orderList = jdbcTemplate.query("SELECT * FROM Cart ORDER BY item_id", new BeanPropertyRowMapper<Order>(Order.class));

  public List<Order> getOrderList() {
    return orderList;
  }
*/
  /**
   * 注文内容を追加する
   * 商品がすでに存在すれば個数を追加する。存在しなければ注文内容を作成し追加する
   *
   * @param item_id the item id
   * @param num the num
   */

/*public void addOrder(int item_id, int item_count) {

    Order addOrder = null;
    for(Order order : this.orderList) {

      if(order.getItemId() == item_id) {
        //個数追加する商品をnewOrderに格納
        addOrder = order;
      }

    }

    if(addOrder == null) {
      //注文内容追加
      Order order = new Order(item_id, item_count);
      this.orderList.add(order);
    } else {
      //すでに存在する注文に個数追加
      int newitem_count = addOrder.getItemCount() + item_count;
      addOrder.setItemCount(newitem_count);
    }

  }

  /**
   * 注文内容削除する
   *
   * @param item_id the item id
   */
  /*public void deleteOrder(int item_id) {

    Order deleteOrder = null;
    for(Order order : this.orderList) {

      if(order.getItemId() == item_id) {
        //削除する商品をdeleteOrderに格納
        deleteOrder = order;
      }

    }

    if(deleteOrder != null) {
      //注文内容削除
      this.orderList.remove(deleteOrder);
    }
  }

}*/
