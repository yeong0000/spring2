package com.itwill.spring2.domain;
//MVC에서 model부분
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //Post() 기본생성자를 자동으로 만들어줌
@AllArgsConstructor //Post(long, String, String, String, LocalDateTime, LocalDateTime)만들어줌
@Builder //내부 클래스를 만들어줌
@Getter //getter 메서드 추가됨
@Setter //setter 메서드 추가됨
@ToString
public class Post {

    private long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime created_time;
    private LocalDateTime modified_time;
    
    
}
