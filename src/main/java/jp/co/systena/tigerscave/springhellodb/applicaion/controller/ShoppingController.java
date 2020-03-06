package jp.co.systena.tigerscave.springhellodb.applicaion.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.springhellodb.applicaion.model.Order;
import jp.co.systena.tigerscave.springhellodb.applicaion.service.ListService;

@Controller // Viewあり。Viewを返却するアノテーション
public class ShoppingController {


  @Autowired
  HttpSession session;// セッション管理
  @Autowired
  private ListService listService; // サービスクラス
  @Autowired
  private  JdbcTemplate jdbcTemplate;//DB

  /**
   * 商品一覧画面表示
   *
   * @param mav the mav
   * @return the model and view
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView list(ModelAndView mav) {


    // 商品一覧取得
    List<Map<String, Object>> itemListMap = listService.getItemList();

    // テンプレートに渡す内容を設定
    mav.addObject("items", itemListMap);

    // Viewのテンプレート名を設定
    mav.setViewName("ListView");

    return mav;
  }


  /**
   * 注文内容をカートに追加する
   *
   * @param mav the mav
   * @param listForm the list form
   * @param bindingResult the binding result
   * @return the model and view
*/
/**
  @RequestMapping(value = "/list", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView order(ModelAndView mav, @Validated ListForm listForm,BindingResult bindingResult) {

    if (bindingResult.getAllErrors().size() > 0) {
      // リクエストパラメータにエラーがある場合は商品一覧画面を表示

      List<Map<String, Object>> itemListMap = listService.getItemList();
      mav.addObject("items", itemListMap);

      // Viewのテンプレート名を設定
      mav.setViewName("ListView");

      return mav;

    }
      // 注文内容をカートに追加
      Cart cart = getCart();
      cart.addOrder(listForm.getItemId(), listForm.getItemCount());

      // データをセッションへ保存
      session.setAttribute("cart", cart);

      return new ModelAndView("redirect:/cart"); // リダイレクト


    }*/






  /**
   * カートの内容を表示する
   *
   * @param mav the mav
   * @return the model and view



  @SuppressWarnings({"unchecked", "unlikely-arg-type"})
  @RequestMapping(value = "/cart", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView cart(ModelAndView mav) {

    // セッションからカートを取得し、テンプレートに渡す
    Cart cart = getCart();
    mav.addObject("orderList", cart.getOrderList());

    // 商品一覧をテンプレートに渡す。※商品名、価格を表示するため
    List<Map<String, Object>> itemListMap = listService.getItemList();
    mav.addObject("items", itemListMap);

    // 合計金額計算
    int totalPrice = 0;
    for (Order order : cart.getOrderList()) {
      if (((Map<String, Object>) itemListMap).containsKey(order.getItemId())) {
        totalPrice += order.getItemCount() * ((Item) itemListMap.get(order.getItemId())).getPrice();
      }
    }
    mav.addObject("totalPrice", totalPrice);

    // Viewのテンプレート名設定
    mav.setViewName("CartView");

    return mav;
  } */
  /**
   * 注文内容削除する
   *
   * @param mav the mav
   * @param deleteForm the delete form
   * @param bindingResult the binding result
   * @return the model and view


  @RequestMapping(value = "/cart", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView deleteOrder(ModelAndView mav, @Validated DeleteForm deleteForm,
      BindingResult bindingResult) {

    if (bindingResult.getAllErrors().size() == 0) {
      //リクエストパラメータにエラーがなければ、削除処理行う

      // カートから商品を削除
      Cart cart = getCart();
      cart.deleteOrder(deleteForm.getItemId());

      // データをセッションへ保存
      session.setAttribute("cart", cart);
    }

    return new ModelAndView("redirect:/cart"); // リダイレクト
  }   */

  /**
   * セッションからカートを取得する
   *
   * @return the cart


  private Cart getCart() {
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }

    return cart;
  }*/

  /**
   * 初期表示用
   *
   * アイテムデータを取得して一覧表示する
   *
   * @param model
   * @return

  @RequestMapping(value = "/itemlist", method = RequestMethod.GET) // URLとのマッピング
  public String index(Model model) {

    model.addAttribute("items", getItemList());

    return "itemlist";
  }*/



  /**
   * 「更新 カートに追加」ボタン押下時の処理
   *
   * 入力された名前と価格をアイテムIDをキーとして更新する
   *
   * @param listForm
   * @param result
   * @param model
   * @return

  @RequestMapping(value = "/cart", method = RequestMethod.POST) // URLとのマッピング
  public String update(@Valid ItemListForm listForm,BindingResult result,Model model) {

    // listFormに画面で入力したデータが入っているので取得する
    List<Item> itemList = listForm.getItemList();
    // ビューに受け渡し用にmodelにセット
    model.addAttribute("items", itemList);
    model.addAttribute("listForm", listForm);


    //画面入力値にエラーがない場合
    if (!result.hasErrors()) {
      if (itemList != null) {
        //画面入力値1行ずつ処理をする
        for (Item item : itemList) {

          //1行分の値でデータベースをUPDATEする
          //item_idをキーに名称と価格を更新する
          //SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
          int updateCount = jdbcTemplate.update(
              "UPDATE items SET item_count = ? WHERE item_id = ?",
              item.getItemCount(),item.getItemId());


        }
      }
    }

    return "cart";

  }*/

  /**
   * 「削除」リンク押下時の処理
   *
   * パラメータで受け取ったアイテムIDのデータを削除する
   *
   * @param itemId
   * @param model
   * @return

  @RequestMapping(value = "/deleteitem", method = RequestMethod.GET) // URLとのマッピング
  public String update(@RequestParam(name = "item_id", required = true) String itemId,Model model) {


    // 本来はここで入力チェックなど


      // パラメータで受けとったアイテムIDのデータを削除する
    // SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
    int deleteCount = jdbcTemplate.update("DELETE FROM Carts WHERE item_id = ?", Integer.parseInt(itemId));


    return "redirect:/Cart";

  } */



  /**
   * 「登録」ボタン押下時の処理
   *
   * 入力されたアイテムID、名前、価格をデータベースに登録する
   *
   * @param form
   * @param result
   * @param model
   * @return
*/
  @RequestMapping(value = "/@{/additem}", method = RequestMethod.POST) // URLとのマッピング
  public String insert(@Valid Order form,BindingResult result,Model model) {

    //画面入力値にエラーがない場合
    if (!result.hasErrors()) {

          //1行分の値をデータベースにINSERTする
          //SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
          int insertCount = jdbcTemplate.update(
                "INSERT INTO Carts VALUES( ?, ? )",
                Integer.parseInt(form.getItemId()),Integer.parseInt(form.getItemCount()));

    }

    return "redirect:/itemList";

  }





  /**
   * 「登録」ボタン押下時の処理
   *
   * 入力されたアイテムID、名前、価格をデータベースに登録する
   *
   * @param form
   * @param result
   * @param model
   * @return

  @RequestMapping(value = "/list", method = RequestMethod.POST) // URLとのマッピング
  public String insert(@Valid ListForm form,BindingResult result,Model model) {

    //画面入力値にエラーがない場合
    if (!result.hasErrors()) {

          //1行分の値をデータベースにINSERTする
          //SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
          int insertCount = jdbcTemplate.update(
                "INSERT INTO Carts VALUES( ?, ? )",
                form.getItemId(),form.getItemCount());
    }
    return "redirect:/Cart";
  } */

  /**
  @RequestMapping(value = "/list", method = RequestMethod.POST) // URLとのマッピング
public ModelAndView order(ModelAndView mav, @Validated ListForm listForm,BindingResult bindingResult) {
 // 注文内容をカートに追加
  Cart cart = getCart();
  cart.addOrder(listForm.getItemId(), listForm.getItemCount());

  // データをセッションへ保存
  session.setAttribute("cart", cart);

  return new ModelAndView("redirect:/cart"); // リダイレクト
}*/







}