package com.itwill.spring2.dto;

import java.sql.Timestamp;

import com.itwill.spring2.domain.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //기본생성자
@Getter //private 변수를 읽어야지
@Setter
@ToString
@AllArgsConstructor //builder타입을 만들기 위해서
@Builder
public class ReplyReadDto {

    
    private long id;
    private long postId;
    private String replyText;
    private String write;
    private Timestamp modifiedTime;
    
    //DB에서 select한 Reply 타입 객체를 replyReadDto 타입 객체로 변환해서 리턴.
    public static ReplyReadDto fromEntity(Reply entity) {
        return ReplyReadDto.builder()
                .id(entity.getId())
                .postId(entity.getPost_id())
                .replyText(entity.getReply_text())
                .write(entity.getWriter())
                .modifiedTime(Timestamp.valueOf(entity.getModified_time()))
                .build();
    }
}
