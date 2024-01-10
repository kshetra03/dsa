package leetcode;

import javax.xml.validation.TypeInfoProvider;
import java.util.*;

// https://leetcode.com/problems/design-a-food-rating-system/description/
public class FoodRatingSystem {

    private Map<String, Integer> foodRatingMap;
    private Map<String, TreeMap<Integer, PriorityQueue<String>>> cuisineRatingMap;

    public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        cuisineRatingMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodRatingMap.put(food, rating);

            cuisineRatingMap.computeIfAbsent(cuisine, k -> new TreeMap<>());
            cuisineRatingMap.get(cuisine).computeIfAbsent(rating, k -> new PriorityQueue<>()).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        final String cuisine = getCuisine(food);
        final int oldRating = foodRatingMap.get(food);

        // remove the existing entry in the cuisineMap for the oldRating
        cuisineRatingMap.get(cuisine).get(oldRating).remove(food);
        if (cuisineRatingMap.get(cuisine).get(oldRating).size() == 0) {
            cuisineRatingMap.get(cuisine).remove(oldRating);
        }

        foodRatingMap.put(food, newRating);

        cuisineRatingMap.get(cuisine).computeIfAbsent(newRating, v -> new PriorityQueue<>()).add(food);
    }

    public String highestRated(String cuisine) {
        Integer highestRating = cuisineRatingMap.get(cuisine).lastKey();
        PriorityQueue<String> highestRatedFoodList = cuisineRatingMap.get(cuisine).get(highestRating);
        return highestRatedFoodList.peek();
    }

    private String getCuisine(final String food) {
        for (Map.Entry<String, TreeMap<Integer, PriorityQueue<String>>> entry: cuisineRatingMap.entrySet()) {
            if (entry.getValue()
                    .values()
                    .stream()
                    .flatMap(PriorityQueue::stream)
                    .toList()
                    .contains(food)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FoodRatingSystem foodRatings = new FoodRatingSystem(
                new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"},
                new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"},
                new int[]{2,6,18,6,5}
        );

        System.out.println(" --------------- ");

        foodRatings.changeRating("qnvseohnoe", 11);

        System.out.println(foodRatings.highestRated("fajbervsj"));

        foodRatings.changeRating("emgqdbo",3);
        foodRatings.changeRating("jmvfxjohq",9);
        foodRatings.changeRating("emgqdbo",14);

        System.out.println(foodRatings.highestRated("fajbervsj"));
        System.out.println(foodRatings.highestRated("snaxol"));

    }
}
