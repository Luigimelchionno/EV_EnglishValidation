package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import controller.ServletCommon;
import controller.ServletStudent;
import interfacce.UserInterface;
import model.Request;
import model.Student;

public class ServletStudentTest extends Mockito {
  private ServletStudent servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @Before
  public void setUp() {
    servlet = new ServletStudent();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void addNewStudentFailNameNull() throws ServletException, IOException  {
    request.addParameter("name", "");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void addNewStudentFailNameOver() throws ServletException, IOException  {
    request.addParameter("name", "aaaaaaaaaaaaaaaaaaaaa");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailFlag() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "10");
    servlet.doPost(request, response);
  }
  
  @Test
  public void addNewStudentFailSurnameNull() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "");
    request.addParameter("email", "g.c@unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailSurnameOver() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "aaaaaaaaaaaaaaaaaaaaa");
    request.addParameter("email", "g.c@unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailEmail() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "@unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailEmail2() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailEmail3() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "aaaa@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailEmail4() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "a.@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentFailSex() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@studenti.unisa.it");
    request.addParameter("sex", "L");
    request.addParameter("password", "pass");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentSexF() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@studenti.unisa.it");
    request.addParameter("sex", "F");
    request.addParameter("password", "pass");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudentSexM() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "pass");
    request.addParameter("flag", "1");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void addNewStudent() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void addNewStudent1() throws ServletException, IOException  {
    String Ab = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd = new SecureRandom();
    StringBuilder sb = new StringBuilder(10);
    // Crea una stringa random per l'email di lunghezza 10
    for (int i = 0; i < 10; i++) {
      sb.append(Ab.charAt(rnd.nextInt(Ab.length()))); 
    }
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", sb.toString() + "." + "@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
  } 

  
  @Test
  public void testFirstFormYearFail() throws ServletException, IOException {  
    request.addParameter("year", "");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A2");
    request.addParameter("requestedCfu", "6");
    request.addParameter("serial", "512104365");
    request.addParameter("idEnte", "1");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }

  @Test
  public void testFirstFormSerialFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "1000000000");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A2");
    request.addParameter("requestedCfu", "6");
    request.addParameter("idEnte", "1");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormIdEnteFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "0");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A2");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormExpiryDateFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A2");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormReleaseDateFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A2");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormCertificateSerialFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "");
    request.addParameter("level", "A2");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormLevelFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormLevelFail2() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A1234");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstFormRequestedCfuFail() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A1");
    request.addParameter("requestedCfu", "13");
    request.addParameter("flag", "2");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testFirstForm() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A1");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("g.c@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    servlet.doPost(request, response);
  }
  
  @Test
  public void testFirstFormEmpty() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A1");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "2");
    UserInterface user = new Student("l.l@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    servlet.doPost(request, response);
  }
  
  @Test
  public void testFirstFormFailFlag() throws ServletException, IOException {  
    request.addParameter("year", "2018");
    request.addParameter("serial", "512103579");
    request.addParameter("idEnte", "1");
    request.addParameter("expiryDate", "2020-02-14");
    request.addParameter("releaseDate", "2015-02-14");
    request.addParameter("certificateSerial", "A00000001");
    request.addParameter("level", "A1");
    request.addParameter("requestedCfu", "6");
    request.addParameter("flag", "10");
    UserInterface user = new Student("b.b@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    servlet.doPost(request, response);
  }
  
  @Test
  public void testAttachedDbFilenamesLenght() throws ServletException, IOException {
    String[] file = new String[1];
    file[0] = "allegato1.docx";
    request.addParameter("filenames[]", file);
    request.addParameter("idRequest", "1");
    request.getSession().setAttribute("idRequest", 1);
    UserInterface user = new Student("prova00@unisa.it", "Paolo", "Beningno", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "3");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }

  @Test
  public void testAttachedDbFilenamesFail() throws ServletException, IOException {
    String[] file = new String[2];
    file[0] = "allegato1.docx";
    file[1] = "allegato2.docx";
    request.addParameter("filenames[]", file);
    request.addParameter("idRequest", "1");
    request.getSession().setAttribute("idRequest", 1);
    UserInterface user = new Student("prova00@unisa.it", "Paolo", "Beningno", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "3");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testAttachedDbFilenamesFail2() throws ServletException, IOException {
    String[] file = new String[2];
    file[0] = "allegato1.pdf";
    file[1] = "allegato2.docx";
    request.addParameter("filenames[]", file);
    request.addParameter("idRequest", "1");
    request.getSession().setAttribute("idRequest", 1);
    UserInterface user = new Student("prova00@unisa.it", "Paolo", "Beningno", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "3");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void testAttachedDb() throws ServletException, IOException {
    String[] file = new String[2];
    file[0] = "allegato1.pdf";
    file[1] = "allegato2.pdf";
    request.addParameter("filenames[]", file);
    request.addParameter("idRequest", "104");
    request.getSession().setAttribute("idRequest", 104);
    UserInterface user = new Student("g.c@studenti.unisa.it", "Giuseppe", 
        "Cirino", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testAttachedDbEmpty() throws ServletException, IOException {
    String[] file = new String[2];
    file[0] = "allegato1.pdf";
    file[1] = "allegato2.pdf";
    request.addParameter("filenames[]", file);
    request.addParameter("idRequest", "888");
    request.getSession().setAttribute("idRequest", 888);
    UserInterface user = new Student("p.p@studenti.unisa.it", "Giuseppe", 
        "Cirino", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testDoGet() throws ServletException, IOException  {
    request.addParameter("name", "Giuseppe");
    request.addParameter("surname", "Cirino");
    request.addParameter("email", "g.c@studenti.unisa.it");
    request.addParameter("sex", "M");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doGet(request, response);
    assertEquals("json", response.getContentType());
  }
}