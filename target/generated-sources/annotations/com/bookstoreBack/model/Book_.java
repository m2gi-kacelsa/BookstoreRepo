package com.bookstoreBack.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Integer> nbOfPages;
	public static volatile SingularAttribute<Book, Float> unitCost;
	public static volatile SingularAttribute<Book, String> isbn;
	public static volatile SingularAttribute<Book, String> imageURL;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, Language> language;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Date> publicationDate;

}

