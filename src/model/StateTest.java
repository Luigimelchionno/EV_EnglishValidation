package model;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import org.junit.jupiter.api.Test;

public class StateTest {

  //Test Metodi GET

  @Test
  void testGetIdState() {
    State st = new State(00001, "Approved"); 
    assertEquals(00001, st.getIdState());
  }

  @Test
  void testGetDescription() {
    State st = new State(00001, "Approved");
    assertEquals("Approved", st.getDescription());
  }

  //Test Metodi SET

  @Test
  void testsSetIdState() {
    State st = new State(00002, "Approved");
    st.setIdState(00003);
    assertEquals(00003, st.getIdState());
  }

  @Test
  void testSetDescription() {
    State st = new State(00002, "Denied");
    st.setDescription("Approved");
    assertEquals("Approved", st.getDescription()); 
  }
}
