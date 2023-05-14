package com.example.studyjpa;

import com.example.studyjpa.entity.Member;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyJpaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(StudyJpaApplication.class, args);
        test();
    }

    public static void test() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("testUnit");

        //entityManager는 데이터베이스 커넥션을 하나 가져온다.
        EntityManager manager = factory.createEntityManager();
        //모든 쓰기 내용은 트랜잭션의 안에서 실행되어야 한다.
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            //jpql(manager);
            insert(manager);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback(); //문제가 발생하면 롤백한다.
        } finally {
            manager.close(); //close()를 호출하면 데이터베이스 커넥션을 반환한다.
        }

        factory.close(); //어플리케이션이 종료되면 factory를 닫는다.
    }



    public static void insert(EntityManager manager) {

        //manager.persist(member);
    }

    public static void jpql(EntityManager manager){
        String name = "name22";

        String jpql = "";
        //String jpql = "select m from Member m where m.name = ?1";
        TypedQuery<Member> query = manager.createQuery(jpql, Member.class); //JPQL 생성
        query.setParameter(1, name); //:name 파라미터에 name 변수를 바인딩한다.
        Member member = query.getSingleResult(); //단건 조회

    }

}
