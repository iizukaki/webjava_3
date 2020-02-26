package jp.co.systena.tigerscave.springhellodb.applicaion.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.springhellodb.applicaion.model.Item;


@Service
public class ListService {

@Autowired
private  JdbcTemplate jdbcTemplate;

/**
 * データベースからアイテムデータ一覧を取得する
 *
 * @return
 */
public List<Item> getItemList() {

  //SELECTを使用してテーブルの情報をすべて取得する
  List<Item> list = jdbcTemplate.query("SELECT * FROM items ORDER BY item_id", new BeanPropertyRowMapper<Item>(Item.class));

  return list;

  /*
  //結果はMapのリストとして取得することもできる
  List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM items ORDER BY item_id");

  */
  }

}

