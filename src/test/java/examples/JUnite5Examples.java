package examples;


import org.junit.jupiter.api.*;

public class JUnite5Examples {

    @BeforeAll
    static void setUp() {
        System.out.println("_____setUp");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("_______beforeEach");
    }

    @Test
    void firstTest() {
        System.out.println("_________firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("_________secondTest");
    }

    @AfterEach
    void afterEach() {
        System.out.println("_______afterEach");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("_____tearDown");
    }
}
