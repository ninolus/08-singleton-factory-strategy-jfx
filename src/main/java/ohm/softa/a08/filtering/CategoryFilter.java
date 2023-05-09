package ohm.softa.a08.filtering;

import ohm.softa.a08.model.Meal;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class CategoryFilter extends FilterBase {
	private final boolean include;
	private final List<String> categories;

	public CategoryFilter(boolean include, List<String> categories) {
		this.include = include;
		this.categories = categories;
	}

	@Override
	protected boolean include(Meal m) {
		if (include) {
			return categories.stream().anyMatch(e -> e.equalsIgnoreCase(m.getCategory()));
		}
		return categories.stream().noneMatch(e -> e.equalsIgnoreCase(m.getCategory()));
	}
}
