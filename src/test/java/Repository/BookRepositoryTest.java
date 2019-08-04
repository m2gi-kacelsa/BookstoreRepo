/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import bookstoe.util.TextUtil;
import com.bookstoreBack.model.Book;
import com.bookstoreBack.model.Language;
import java.util.Date;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author DELL_PC
 */
@RunWith(Arquillian.class)
public class BookRepositoryTest {
    
    @Inject
    private BookRepository bookRepository;
    
    @Test(expected = Exception.class)
    public void findWithInvalidId() {
        bookRepository.find(null);
    }
    
    @Test(expected = Exception.class)
    public void createInvalideBook(){
        Book book = new Book(null, "description", 12F, "isbn" ,new Date(), 15, "www.picture", Language.ENGLISH);
        bookRepository.create(book);
    }

    @Test
    public void testCreate() throws Exception{
        assertEquals(Long.valueOf(0), bookRepository.countAll());
        assertEquals(0, bookRepository.findAll().size());
        Book book = new Book("book", "description", 12F, "isbn" ,new Date(), 15, "www.picture", Language.ENGLISH);
        book = bookRepository.create(book);
        Long bookId = book.getId();
        
        assertNotNull(bookId);
        
        Book bookFound = bookRepository.find(bookId);
        
        assertEquals("book", bookFound.getTitle());
        assertTrue(bookFound.getIsbn().startsWith("13"));
    }
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BookRepository.class)
                .addClass(Book.class)
                .addClass(Language.class)
                .addClass(TextUtil.class)
                .addClass(NumberGenerator.class)
                .addClass(IsbnGenerator.class)
                .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
   
}
