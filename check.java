package selenium;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class check {
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
    	System.out.print(Mymethod());
    }
    public static List<Person> Mymethod () throws JsonMappingException, JsonProcessingException {
        dataRead ReadData = new dataRead();
        String jsonArray = ReadData.data();
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse JSON array into a list of Person objects
         List<Person> personList = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});

        return personList;
    }

    // Define a POJO class representing the structure of JSON data
    static class Person {
        private String name;
        private int age;
        private String gender;
        // Getters and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender(String gender) {
            return gender;
        }
        
        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

       @Override
        public String toString() {
            return name +" "+ age + " " +gender;
        }
    }
}
