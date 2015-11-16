package pl.kukla.krzys.restaurant.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.kukla.krzys.restaurant.dao.AdditionDao;
import pl.kukla.krzys.restaurant.dao.DrinkDao;
import pl.kukla.krzys.restaurant.dao.MealDao;
import pl.kukla.krzys.restaurant.dao.impl.AdditionDaoImpl;
import pl.kukla.krzys.restaurant.dao.impl.DrinkDaoImpl;
import pl.kukla.krzys.restaurant.dao.impl.MealDaoImpl;
import pl.kukla.krzys.restaurant.enums.Cuisine;
import pl.kukla.krzys.restaurant.model.AbstractItem;
import pl.kukla.krzys.restaurant.model.Addition;
import pl.kukla.krzys.restaurant.model.Drink;
import pl.kukla.krzys.restaurant.model.Meal;

/**
 * This class represents User Interface for clients
 * This class handles users
 * This class is immutable with private constructor
 * 
 * @author Krzysztof
 *  
 */
public class RestaurantUI {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	// constants
	private static final int NUMBERS_OF_CHOICES = 5;
	private static final String SELECT_ITEM = "Select the item, please? ";
	private static final String INCORRECT_CHOICE = "Incorrect choice, please retry... ";
	private static final String SELECT_CUISINE = "\nSelect the cuisine? ";
	private static final String SELECT_YOU_CHOICE = "Select you choice, please? ";
	private static final String WELCOME = "\nWelcome in restaurant!";
	private static final String THANKS = "Thanks for visited...";
	private static final String TOTAL_COST = "Total cost: ";
	
	private Scanner scanner;
	
	private List<AbstractItem> order;
	
	private final MealDao mealDao;
	private final DrinkDao drinkDao;
	private final AdditionDao additionDao;
	
	private RestaurantUI() {
		order = new ArrayList<AbstractItem>();
		mealDao = new MealDaoImpl();
		drinkDao = new DrinkDaoImpl();
		additionDao = new AdditionDaoImpl();
	}
	
	//main menu 
	private int selectTypeOfItem(int numberOfChoices){
		System.out.println(WELCOME);
		System.out.println("1- Meal  2- Drink  3- Addition  4- End of order, bill please \n5- Exit");
		System.out.println(SELECT_YOU_CHOICE);
		return getChoiceFromScanner(numberOfChoices);
	}
	
	//scanning value from keybord
	private int getChoiceFromScanner(int maxValue){
		int fromScanner = scanner.nextInt();
		if (fromScanner<1 || fromScanner>maxValue) throw new IllegalArgumentException();
		return fromScanner;
	}
	
	//show items selected from main menu
	private void showItemsOfMenu(final int key){
		AbstractItem item=null;
		switch (key) {
			case 1:
				item = mealChoice();
				break;
			case 2:
				item = drinkChoice();
				break;
			case 3:
				item = additionChoice();
				break;
			case 4:
				orderFinished();
				break;
			case 5:
			default:
				System.out.println(THANKS);
				scanner.close();
				System.exit(0);
			}
		if (item!=null) order.add(item);
	}
	
	//show bill and total cost
	private void orderFinished() {
		BigDecimal sum = new BigDecimal("0");
		int number=0;
		for(AbstractItem item: order){
			System.out.println(++number+" "+item.getName()+" "+item.getPrice());
			sum=sum.add(item.getPrice());
		}
		System.out.println(TOTAL_COST+sum);
		order = new ArrayList<AbstractItem>();
	}

	// choice of meal
	private Meal mealChoice() {
		Map<Integer, Meal> items = new HashMap<Integer, Meal>();
		Set<Meal> mealsForCuisine = mealDao.getByCuisine(selectTypeOFCuisine());
		if (!mealsForCuisine.isEmpty()){
			System.out.println("Cuisine "+mealsForCuisine.iterator().next().getCuisine());
		}
		int number = 0;
		for(Meal meal: mealsForCuisine){
			items.put(++number, meal);
			System.out.println(number+"- "+meal);
		}
		System.out.println(SELECT_ITEM);
		int fromScanner = getChoiceFromScanner(number);
		return items.get(fromScanner);
	}
	
	// choice of drink
	private AbstractItem drinkChoice() {
		Map<Integer, Drink> items = new HashMap<Integer, Drink>();
		Set<Drink> drinks = drinkDao.getAll();
		int number = 0;
		for(Drink drink: drinks){
			items.put(++number, drink);
			System.out.println(number+"- "+drink);
		}
		System.out.println(SELECT_ITEM);
		int fromScanner = getChoiceFromScanner(number);
		return items.get(fromScanner);
	}
	
	// choice of addition
	private AbstractItem additionChoice() {
		Map<Integer, Addition> items = new HashMap<Integer, Addition>();
		Set<Addition> additions = additionDao.getAll();
		int number = 0;
		for(Addition addition: additions){
			items.put(++number, addition);
			System.out.println(number+"- "+addition);
		}
		System.out.println(SELECT_ITEM);
		int fromScanner = getChoiceFromScanner(number);
		return items.get(fromScanner);
	}

	//choice of cuisine
	private Cuisine selectTypeOFCuisine(){
		int number=0;
		for (Cuisine c: Cuisine.values()){
			System.out.print(++number +"- "+c+"  ");
		}
		System.out.println(SELECT_CUISINE);
		int fromScanner = getChoiceFromScanner(number);
		return Cuisine.values()[fromScanner-1];
	}
	
	// start application
	private void startApplication(){
		scanner = new Scanner(System.in);
		int selected=0;
		try{
			selected = selectTypeOfItem(NUMBERS_OF_CHOICES);
			showItemsOfMenu(selected);
		}
		catch(RuntimeException e){
			log.error(e);
			System.out.println(INCORRECT_CHOICE+"\n");
		}
		finally{
			if (selected!=NUMBERS_OF_CHOICES) startApplication();
		}
	}
	
	/**
	 * This class begins the application
	 */
	public static void start(){
		new RestaurantUI().startApplication();
	}
}
