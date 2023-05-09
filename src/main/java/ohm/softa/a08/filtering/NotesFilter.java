package ohm.softa.a08.filtering;

import ohm.softa.a08.model.Meal;

import java.util.List;

public class NotesFilter extends FilterBase {

	private final boolean include;

	private final List<String> notes;

	public NotesFilter(boolean include, List<String> notes) {
		this.include = include;
		this.notes = notes;
	}


	@Override
	protected boolean include(Meal m) {
		if (include) {
			return notes.stream().anyMatch(e -> m.getNotes().contains(e));
		}
		return notes.stream().noneMatch(e -> m.getNotes().contains(e));
	}
}
