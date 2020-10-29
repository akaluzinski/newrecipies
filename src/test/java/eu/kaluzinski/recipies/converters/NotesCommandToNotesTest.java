package eu.kaluzinski.recipies.converters;



import eu.kaluzinski.recipies.commands.NotesCommand;
import eu.kaluzinski.recipies.model.Notes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    public void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void shouldNotConvertNull () {
        assertNull(converter.convert(null));
    }

    @Test
    public void shouldConvertEmptyObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void shouldConvertNotes() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }

}
