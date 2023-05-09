package ohm.softa.a08.filtering;

import ohm.softa.a08.model.Meal;

import java.util.List;
import java.util.stream.Collectors;

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
			return notes.stream().map(String::toLowerCase).anyMatch(note -> m.getNotes().stream().map(String::toLowerCase).collect(Collectors.toList()).contains(note));

		}
		return notes.stream().map(String::toLowerCase).noneMatch(note -> m.getNotes().stream().map(String::toLowerCase).collect(Collectors.toList()).contains(note));
	}
}
