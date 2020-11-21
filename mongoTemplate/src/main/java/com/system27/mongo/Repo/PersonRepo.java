package com.system27.mongo.Repo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.system27.mongo.Model.Person;
import com.system27.mongo.MongoApplication;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepo {

    private final MongoTemplate mongoTemplate;

    public List<Person> findAll() {
        return mongoTemplate.findAll(Person.class);
    }

    public Person add(Person person) {
      return mongoTemplate.save(person);
    }

    public Person update(Person person) {
        return mongoTemplate.save(person);
    }

    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Person.class, "person");

//        MongoCollection<Document> collection = db.getCollection("people");
//        try{
//            BasicDBObject filter = new BasicDBObject("_id", new ObjectId(id));
//            collection.deleteOne(filter);
//        }catch (Exception e){
//            throw new RuntimeException("something went wrong" + e.getMessage());
//        }
    }

    public List<Person> getBySalary(int salary) {
        Query query = new Query();
        query.addCriteria(Criteria.where("salary").gt(salary));
        return mongoTemplate.find(query,Person.class);
    }
}
