package ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //ép kiểu về kiểu text
    //nullable là xem cho notnull
    @Column(name = "content",nullable = false,columnDefinition = "text")
    private String content;
    @Column(name = "status")
    private boolean status;

    public Todo() {
    }

    public Todo(Long id, String content, boolean status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}