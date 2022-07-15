package System.Restaurant.Model;


import java.util.HashMap;
import java.util.Map;

public class Menu {
  Map<Dish,Integer> todayPrices;

  public Menu(){ todayPrices = new HashMap<>();}
  public void publishMenu(Map<Dish,Integer> menu){
    todayPrices.clear();
    todayPrices.putAll(menu);
  }

  public Integer getPrice(Dish dish){
    Integer found = null;
    for(Dish e:todayPrices.keySet()){
      if(e.getName().equals(dish.getName())){
        found = todayPrices.get(e);
        break;
      }
    }
    return found;
  }


}
