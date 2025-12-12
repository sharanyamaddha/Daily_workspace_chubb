package com.fileupload.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



//import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDB {

	@Id
	private String id;
	
	private String name;
	
	private String type;
	
	  public FileDB(String name, String type, byte[] data) {
		    this.name = name;
		    this.type = type;
		    this.data = data;
		  }
	
	//@Lob
	private byte[] data;
}
