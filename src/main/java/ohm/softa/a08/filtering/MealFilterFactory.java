package ohm.softa.a08.filtering;

import java.util.*;

public class MealFilterFactory {
	private static final Map<String, MealsFilter> filters = new HashMap<String, MealsFilter>();

	static {
		filters.put("all", new NoFilter());
		filters.put("no pork", new CategoryFilter(false, List.of("Schwein")));
		filters.put("no soy", new NotesFilter(false, List.of("mit Soja")));
		filters.put("vegetarian", new CategoryFilter(true, List.of("vegetarisch", "vegan")));
	}

	public static MealsFilter getStrategy(String key) {
		return filters.getOrDefault(key, filters.get("all"));
	}
}
