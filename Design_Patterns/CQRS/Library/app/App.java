import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iluwatar.cqrs.commandes.CommandServiceImpl;
import com.iluwatar.cqrs.commandes.ICommandService;
import com.iluwatar.cqrs.dto.Author;
import com.iluwatar.cqrs.dto.Book;
import com.iluwatar.cqrs.queries.IQueryService;
import com.iluwatar.cqrs.queries.QueryServiceImpl;
import com.iluwatar.cqrs.util.HibernateUtil;


/**
 * CQRS : Command Query Responsibility Segregation. A pattern used to separate query services from commands or writes
 * services. The pattern is very simple but it has many consequences. For example, it can be used to tackle down a
 * complex domain, or to use other architectures that were hard to implement with the classical way.
 * 
 * This implementation is an example of managing books and authors in a library. The persistence of books and authors is
 * done according to the CQRS architecture. A command side that deals with a data model to persist(insert,update,delete)
 * objects to a database. And a query side that uses native queries to get data from the database and return objects as
 * DTOs (Data transfer Objects).
 */
public class App {


    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Program entry point
     * 
     * @param args
     *          command line args
     */
    public static void main(String[] args) {
        
        ICommandService commands = new CommandServiceImpl();

        // Create Authors and Books using CommandService
        commands.authorCreated("eEvans", "Eric Evans", "eEvans@email.com");
        commands.authorCreated("jBloch", "Joshua Bloch", "jBloch@email.com");
        commands.authorCreated("mFowler", "Martin Fowler", "mFowler@email.com");

        commands.bookAddedToAuthor("Domain-Driven Design", 60.08, "eEvans");
        commands.bookAddedToAuthor("Effective Java", 40.54, "jBloch");
        commands.bookAddedToAuthor("Java Puzzlers", 39.99, "jBloch");
        commands.bookAddedToAuthor("Java Concurrency in Practice", 29.40, "jBloch");
        commands.bookAddedToAuthor("Patterns of Enterprise Application Architecture", 54.01, "mFowler");
        commands.bookAddedToAuthor("Domain Specific Languages", 48.89, "mFowler");
        commands.authorNameUpdated("eEvans", "Eric J. Evans");

        IQueryService queries = new QueryServiceImpl();

        // Query the database using QueryService
        Author nullAuthor = queries.getAuthorByUsername("username");
        Author eEvans = queries.getAuthorByUsername("eEvans");
        BigInteger jBlochBooksCount = queries.getAuthorBooksCount("jBloch");
        BigInteger authorsCount = queries.getAuthorsCount();
        Book dddBook = queries.getBook("Domain-Driven Design");
        List<Book> jBlochBooks = queries.getAuthorBooks("jBloch");

        LOGGER.info("Author username : {}", nullAuthor);
        LOGGER.info("Author eEvans : {}", eEvans);
        LOGGER.info("jBloch number of books : {}", jBlochBooksCount);
        LOGGER.info("Number of authors : {}", authorsCount);
        LOGGER.info("DDD book : {}", dddBook);
        LOGGER.info("jBloch books : {}", jBlochBooks);

        HibernateUtil.getSessionFactory().close();
    }
}
