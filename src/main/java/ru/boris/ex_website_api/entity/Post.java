package ru.boris.ex_website_api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "author_id")
    @Column(name = "author_id")
    private Integer author;

    @Column(name = "topic", length = 20)
    private String topic;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "full_text", length = 5000)
    private String fullText;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public Post(String title, String topic, String full_text) {
    }
    public Post(){
    }
}