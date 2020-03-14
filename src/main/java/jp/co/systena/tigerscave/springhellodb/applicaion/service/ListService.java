package jp.co.systena.tigerscave.springhellodb.applicaion.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * The Class ListService.
 */
@Service
public class ListService {

@Autowired
JdbcTemplate jdbcTemplate;

/**
 * データベースからアイテムデータ一覧を取得する
 *
 * @return 商品一覧
 */
  public List<Map<String, Object>> getItemList() {

    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM items ORDER BY item_id");

    return list;


  /*
   *
   //SELECTを使用してテーブルの情報をすべて取得する
    *
  public Map<String, Item> getItemList() {

  List<Item> list = jdbcTemplate.query("SELECT * FROM items ORDER BY item_id", new BeanPropertyRowMapper<Item>(Item.class));
  Map<String, Item> itemListMap = new LinkedHashMap<String, Item>();

  list.forEach(d -> itemListMap.put(d.getItemId(), d));
    *
    *
  List<Item> list = jdbcTemplate.query("SELECT * FROM items ORDER BY item_id", new BeanPropertyRowMapper<Item>(Item.class));
  Map<Integer, Item> itemListMap = new LinkedHashMap<Integer, Item>();

  list.forEach(d -> itemListMap.put(d.getItemId(), d));




public List<Map<String, Object>> getItemList() {
  List<Map<String, Object>> itemListMap = jdbcTemplate.queryForList("SELECT * FROM items ORDER BY item_id");
  return itemListMap;


jdbcTemplate.queryForList("SELECT * FROM items ORDER BY item_id");
  */
  }

}

