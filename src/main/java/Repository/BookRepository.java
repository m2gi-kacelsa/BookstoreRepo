/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import bookstoe.util.TextUtil;
import com.bookstoreBack.model.Book;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL_PC
 */

@Transactional(SUPPORTS)
public class BookRepository {
    
    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager em;
    
    @Inject
    private NumberGenerator numberGenerator;
    
    @Inject
    private TextUtil textUtil;
    
    public Book find(@NotNull @Min(10) Long id){
        return em.find(Book.class, id);
    }
    
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b from Book b ORDER BY b.title DESC", Book.class);
        return query.getResultList();
    }
    
    public Long countAll(){
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) from Book b", Long.class);
        return query.getSingleResult();
    }
    
    @Transactional(REQUIRED)
    public Book create(@NotNull Book book){
        book.setIsbn(numberGenerator.generateNumber());
        book.setTitle(textUtil.sanitize(book.getTitle()));
        em.persist(book);
        return book;
    }
    
    @Transactional(REQUIRED)
    public void delete(@NotNull @Min(1) @Max(1000) Long id){
        em.remove(em.getReference(Book.class, id));
    }
    
}
