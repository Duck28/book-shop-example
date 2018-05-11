import com.example.application.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Does not work.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/applicationContext-datasource-test.xml",
})
@DirtiesContext
public class TestDAO {

//    private BookDAO bookDAO;
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test.xml");

    @Test
    public void testBookById() {
        Session session = SessionUtilTest.getSessionFactory().openSession();
        Query query = session.createQuery("select b from Book  b where b.id = 1");
        Book result = (Book) query.uniqueResult();
        Assert.assertEquals(1, result.getId());
        Assert.assertEquals("Catcher in the Rye", result.getTitle());
        Assert.assertEquals("Jerome David Salinger", result.getAuthor());
        Assert.assertEquals("Little, Brown and Company", result.getPublisher());
        Assert.assertEquals(1951, result.getYear());

//        bookDAO = (BookDAO) context.getBean("bookDAO");
//        Book book = bookDAO.getBookById(1);
//        Assert.assertEquals(1, book.getId());
//        Assert.assertEquals("Catcher in the Rye", book.getTitle());
//        Assert.assertEquals("Jerome David Salinger", book.getAuthor());
//        Assert.assertEquals("Little, Brown and Company", book.getPublisher());
//        Assert.assertEquals(1951, book.getYear());
    }


//    @Test
//    public void testBooks() {
//        bookDAO = (BookDAO) context.getBean("bookDAO");
//        List<Book> books = bookDAO.getAllBooks();
//        Assert.assertEquals(3, books.size());
//        for (Book book : books) {
//            int id = book.getId();
//            if (id == 1) {
//                Assert.assertEquals("Catcher in the Rye", book.getTitle());
//                Assert.assertEquals("Jerome David Salinger", book.getAuthor());
//                Assert.assertEquals("Little, Brown and Company", book.getPublisher());
//                Assert.assertEquals(1951, book.getYear());
//            }
//        }
//    }

//    @Test
//    public void testAddBook() {
//        bookDAO = (BookDAO) context.getBean("bookDAO");
//        Book book = new Book();
//        book.setAuthor("Franz Kafka");
//        book.setTitle("Metamorphosis");
//        book.setPublisher("Praha");
//        book.setYear(1945);
//        bookDAO.addBook(book);
//        Assert.assertEquals(bookDAO.getBookById(4).getAuthor(), book.getAuthor());
//
//    }
}
