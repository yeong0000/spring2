package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Reply;

public interface ReplyRepository {

    //reply-mapper.xml의 id랑 같게 만들어야함(<select id="selectByPostId")
    List<Reply> selectByPostId(long postId);
    Reply selectById(long id); //댓글에 아이디를 주면 댓글하나를 리턴
    int insert(Reply reply);
    int update(Reply reply); //메서드 이름이 mapper의 이름과 같아야함.
    int delete(long id); //메서드 이름이 mapper의 이름과 같아야함.
    
    //포스트에 달린 댓글의 개수를 리턴하는 메서드
    long selectReplyCountWithPostId(long postId);
    
    
}
