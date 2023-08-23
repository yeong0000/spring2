package com.itwill.spring2.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.domain.Reply;
import com.itwill.spring2.dto.ReplyCreateDto;
import com.itwill.spring2.dto.ReplyReadDto;
import com.itwill.spring2.dto.ReplyUpdateDto;
import com.itwill.spring2.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로그 사용
@RequiredArgsConstructor
@RestController //클라이언트로 직접 전송
@RequestMapping("/api/reply")
public class ReplyController {

    private final ReplyService replyservice;
    
   @PostMapping
   public ResponseEntity<Integer> createReply(@RequestBody ReplyCreateDto dto){
       log.info("createReply(dto={})", dto);
       
       int result = replyservice.create(dto);
       
       return ResponseEntity.ok(result);
   }
   @GetMapping("/all/{postId}")
   public ResponseEntity<List<ReplyReadDto>> read(@PathVariable long postId) {
       log.info("read(postId={})", postId);
       
       List<ReplyReadDto> list = replyservice.read(postId);
       log.info("# of replies = {}", list.size());
       
       return ResponseEntity.ok(list);
   }
   
   @DeleteMapping("/{id}") 
   public ResponseEntity<Integer> deleteReply(@PathVariable long id){
       log.info("deleteReply(id={})", id);
       
       int result = replyservice.delete(id);
       
       return ResponseEntity.ok(result);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<ReplyReadDto> readById(@PathVariable long id){
       log.info("readById(id={})",id);
       
       ReplyReadDto dto = replyservice.readById(id);
       log.info("dto={}", dto);
       
       return ResponseEntity.ok(dto);
   }
   
   @PutMapping("/{id}") //번호는 변수라서 {}
   public ResponseEntity<String> update(
           @PathVariable long id,
           @RequestBody ReplyUpdateDto dto ){ //업데이트할 내용 찾음
           log.info("updateReply(id={}, dto= {}", id, dto);
           
           //DB업데이트 서비스 메서드 호출
           replyservice.update(id, dto);
           
       return ResponseEntity.ok("Success");
               //ResponseEntity.ok(result);
   }
   
   
}
