package System.Restaurant;

import System.Restaurant.Model.Dish;
import System.Restaurant.Model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestaurantApplicationTests {

	private Menu menu;

	@BeforeEach
	void setUp(){
		Map<Dish,Integer> todayPrices = new HashMap<>();
		todayPrices.put(new Dish("pork", false, 800, Dish.Type.MEAT), 20);
		todayPrices.put(new Dish("chicken", false, 400, Dish.Type.MEAT), 19);
		todayPrices.put(new Dish("salmon", false, 300, Dish.Type.SEA_FOOD), 15);
		todayPrices.put(new Dish("shrimps", false, 300, Dish.Type.SEA_FOOD), 15);
		todayPrices.put(new Dish("french fries", true, 530, Dish.Type.VEGETABLES), 7);
		todayPrices.put(new Dish("sauerkraut", true, 100, Dish.Type.VEGETABLES), 4);

		menu = new Menu();
		menu.publishMenu(todayPrices);
	}
	@Test
	@DisplayName("Get price of the dish")
	void getPrice(){
		//given
		Dish dish = new Dish("salomon",false,300,Dish.Type.SEA_FOOD);

		//when
		Integer price = menu.getPrice(dish);

		//then
		Integer expectedPrice =15;
		assertThat(price).isEqualTo(expectedPrice);
	}
}
