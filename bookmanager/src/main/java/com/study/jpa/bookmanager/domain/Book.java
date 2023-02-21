package com.study.jpa.bookmanager.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.study.jpa.bookmanager.domain.listener.Auditable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(value = AuditingEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String category;
	
	private Long authorId;
	
//	private Long publisherId;
	
	@OneToOne
	@ToString.Exclude
	private BookReviewInfo bookReviewInfo;
	
	@OneToMany
	@JoinColumn(name = "book_id")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToOne
	@ToString.Exclude
	private Publisher publisher;
	
	@ManyToMany
	@ToString.Exclude
	private List<Author> authors = new ArrayList<>();
	
	public void addAuthor(Author... author) {
		Collections.addAll(this.authors, author);
	}
}
