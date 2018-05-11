    import com.example.application.DAO.BookDAO;
    import com.example.application.DAO.BookDAOImpl;
    import com.example.application.entity.Book;
    import org.hibernate.Session;
    import org.hibernate.query.Query;
    import org.junit.Assert;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.springframework.test.annotation.DirtiesContext;
    import org.springframework.test.context.ContextConfiguration;
    import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

    import javax.inject.Inject;
    import javax.sql.DataSource;
    import java.util.List;

    /**
     * Does not work.
     */

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {
            "/applicationContext-datasource-test.xml",
            "/applicationContext-test.xml"
    })
    @DirtiesContext
    public class TestDAO {

        private BookDAO bookDAO = new BookDAOImpl(new SessionUtilTest());

        @Test
        public void assertIfSessionWorks() {
            SessionUtilTest testutil = new SessionUtilTest();
            Session session = testutil.getSessionFactory().openSession();
            Assert.assertNotNull(session);
        }

        @Test
        public void testBookById() {
            Book result = bookDAO.getBookById(1);
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


        @Test
        public void testBooks() {
            List<Book> books = bookDAO.getAllBooks();
            Assert.assertNotNull(books);
    //        Assert.assertEquals(3, books.size());
    //        for (Book book : books) {
    //            int id = book.getId();
    //            if (id == 1) {
    //                Assert.assertEquals("Catcher in the Rye", book.getTitle());
    //                Assert.assertEquals("Jerome David Salinger", book.getAuthor());
    //                Assert.assertEquals("Little, Brown and Company", book.getPublisher());
    //                Assert.assertEquals(1951, book.getYear());
                }
            }


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

