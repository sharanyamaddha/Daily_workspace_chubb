package com.fileupload.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fileupload.model.FileDB;

@Repository
public interface FileDBRepository extends MongoRepository<FileDB,String>{

}
