package analysis.harmonic;

import org.junit.*;
import tonality.Tonality;
import tonality.Tonality.Mode;
import static jm.constants.Pitches.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ChordDegreeProcessorTests {
    @Test
    public void t_ChordToDegree() {
        // Testing with C Major
        ChordDegreeProcessor cMajor = new ChordDegreeProcessor(new Tonality(C4, Mode.MAJOR, false));
        ArrayList<Integer> firstChord = new ArrayList<>(Arrays.asList(C4, E2, G6)); // Do Mi Sol
        ArrayList<Integer> secondChord = new ArrayList<>(Arrays.asList(D2, F1, A7)); // Re Fa La
        ArrayList<Integer> secondChordSeventh = new ArrayList<>(Arrays.asList(D1, F3, A3, C6)); // Re Fa La Do
        ArrayList<Integer> thirdChord = new ArrayList<>(Arrays.asList(G1, E2, B6)); // Sol Mi Si
        ArrayList<Integer> fourthChord = new ArrayList<>(Arrays.asList(C4, F4, A4)); // Do Fa La
        ArrayList<Integer> fifthChord = new ArrayList<>(Arrays.asList(G3, D2, B4, G1, D5, B6)); // Sol Re Si Sol Re Si
        ArrayList<Integer> fifthChordSeventh = new ArrayList<>(Arrays.asList(G3, D2, B4, G1, D5, F6)); // Sol Re Si Sol Re Fa
        ArrayList<Integer> sixthChord = new ArrayList<>(Arrays.asList(A3, C2, A2, C5, A1, C3, E1)); // La Do
        ArrayList<Integer> seventhChord = new ArrayList<>(Arrays.asList(B6, D2, F1)); // Si Re
        ArrayList<Integer> notADegreeChord = new ArrayList<>(Arrays.asList(C1, D4, F2)); // Do Re Fa

        Assert.assertEquals(new ChordDegree(1, false), cMajor.chordToDegree(firstChord));
        Assert.assertEquals(new ChordDegree(2, false), cMajor.chordToDegree(secondChord));
        Assert.assertEquals(new ChordDegree(2, true), cMajor.chordToDegree(secondChordSeventh));
        Assert.assertEquals(new ChordDegree(3, false), cMajor.chordToDegree(thirdChord));
        Assert.assertEquals(new ChordDegree(4, false), cMajor.chordToDegree(fourthChord));
        Assert.assertEquals(new ChordDegree(5, false), cMajor.chordToDegree(fifthChord));
        Assert.assertEquals(new ChordDegree(5, true), cMajor.chordToDegree(fifthChordSeventh));
        Assert.assertEquals(new ChordDegree(6, false), cMajor.chordToDegree(sixthChord));
        Assert.assertEquals(new ChordDegree(7, false), cMajor.chordToDegree(seventhChord));
        // FIXME: Decide whether it is normal that this chord is the seventh chord of the second degree or if it should be null
        //Assert.assertNull(cMajor.chordToDegree(notADegreeChord));
    }
}
